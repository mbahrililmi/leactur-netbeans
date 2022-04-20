/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Press;

/**
 *
 * @author M.BAHRIL.I
 */
import javax.swing.JTable;
import java.sql.*;
import Class.jKoneksi;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Penulis extends javax.swing.JInternalFrame {
    private DefaultTableModel _Modtab;
            DefaultTableModel _Modtab2;
    Connection _Cnn;
    /**
     * Creates new form Penulis
     */
    
    
    public Penulis() {
        initComponents();
        setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        tab1();
        tab2();
    }
    void tab1(){
        String[] setKolom = {"NAMA","NIDN","ISBN","JUDUL","TAHUN","JUMLAH HALAMAN","JUMLAH EKSEMPLAR","NOMINAL"};
        _Modtab = new DefaultTableModel(null, setKolom){
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
            };
            public Class getColumnClass(int columnIndex){
                return types[columnIndex];
            }
            public boolean isCellEditable(int row, int col){
                int kol = _Modtab.getColumnCount();
                return (col < kol) ? false : true;
            }
        };
        jTable1.setModel(_Modtab);
        loadData();
    }
    public void hapusRowData(){
        int row = _Modtab.getColumnCount();
        
        while (_Modtab.getRowCount() > 0){
            _Modtab.setRowCount(0);//removeRow(0)
        }
    }
    private void loadData(){
        String _sql = "";
        jKoneksi vConn = new jKoneksi();
        vConn.makeConnect();
        hapusRowData();
        try{
            _Cnn = vConn.vkoneksi;
            if (txt_cari.getText().equals("")) {
                _sql = "SELECT * FROM `tb_penulis`";
            }else{
                _sql = "SELECT * FROM `tb_penulis` WHERE `" +
            cb_pencarian.getSelectedItem()
                        + "` LIKE '%" + txt_cari.getText() + "%'";
                System.out.println(_sql);
            }
            System.out.println(_sql);
            Statement st = _Cnn.createStatement();
            ResultSet res = st.executeQuery(_sql);
            while (res.next()){
                String nama = res.getString(1);
                String nidn = res.getString(2);
                String isbn = res.getString(3);
                String judul = res.getString(4);
                String tahun = res.getString(5);
                String hal = res.getString(6);
                String eks = res.getString(7);
                String nominal = res.getString(8);
                Object[] data = {nama, nidn, isbn, judul, tahun, hal, eks, nominal};
                _Modtab.addRow(data);
            }
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
        } catch (Exception e){
            System.out.println("Error" + e);
        }
    }
    void tab2(){
        String[] SetKolom = {"Halaman", "50eks", "100eks", "150eks", "200eks", "250eks","300eks"};
        _Modtab2 = new DefaultTableModel (null,SetKolom){
         Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
            };
            public Class getColumnClass(int columnIndex){
                return types[columnIndex];
            }
            public boolean isCellEditable(int row, int col){
                int kol = _Modtab2.getColumnCount();
                return (col < kol) ? false : true;
            }
        };
        jTable2.setModel(_Modtab2);
        loadBukuMatriks();
    }
    public void hapusRowData2(){
        int row = _Modtab2.getColumnCount();
        
        while (_Modtab2.getRowCount() > 0){
            _Modtab2.setRowCount(0);//removeRow(0)
        }
    }
    private void loadBukuMatriks(){
        String _sql = "";
        jKoneksi vConn = new jKoneksi();
        vConn.makeConnect();
        hapusRowData2();
        try{
            _Cnn = vConn.vkoneksi;
            if (cb_halaman.getSelectedItem().equals("0")){
                _sql = "SELECT * FROM `buku_matrix`";
            }else{
                _sql = "SELECT * FROM `buku_matrix` WHERE `hal/eks` LIKE '%" + cb_halaman.getSelectedItem()+"%'";
                System.out.println(_sql);
            }
            System.out.println(_sql);
            Statement st = _Cnn.createStatement();
            ResultSet res = st.executeQuery(_sql);
            while (res.next()){
                String hal = res.getString(1);
                String eks50 = res.getString(2);
                String eks100 = res.getString(3);
                String eks150 = res.getString(4);
                String eks200 = res.getString(5);
                String eks250 = res.getString(6);
                String eks300 = res.getString(7);
                Object[] data = {hal, eks50, eks100, eks150, eks200, eks250, eks300};
                _Modtab2.addRow(data);
            }
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(40);
        } catch (Exception e){
            System.out.println("Error" + e);
        }
    }
    void HitunganTotal(){
        jTable2.selectAll();
        String a = cb_halaman.getSelectedItem().toString();
        String b = cb_eks.getSelectedItem().toString();
        String Hasil;
        // matrix 80hal 50-300Eks
        if
        ((cb_halaman.getSelectedItem().toString().equals("80"))
                &&
        (cb_halaman.getSelectedItem().toString().equals("50"))) {
            Hasil = Double.toString(Double.parseDouble(b) *
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("80"))
                &&
        (cb_eks.getSelectedItem().toString().equals("100"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("80"))
                &&
        (cb_eks.getSelectedItem().toString().equals("150"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("80"))
                &&
        (cb_eks.getSelectedItem().toString().equals("200"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("80"))
                &&
        (cb_eks.getSelectedItem().toString().equals("250"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("80"))
                &&
        (cb_eks.getSelectedItem().toString().equals("300"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        }
        //matix 100hal 50-300eks
        if
        ((cb_halaman.getSelectedItem().toString().equals("100"))
                &&
        (cb_halaman.getSelectedItem().toString().equals("50"))) {
            Hasil = Double.toString(Double.parseDouble(b) *
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("100"))
                &&
        (cb_eks.getSelectedItem().toString().equals("100"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("100"))
                &&
        (cb_eks.getSelectedItem().toString().equals("150"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("100"))
                &&
        (cb_eks.getSelectedItem().toString().equals("200"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("100"))
                &&
        (cb_eks.getSelectedItem().toString().equals("250"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("100"))
                &&
        (cb_eks.getSelectedItem().toString().equals("300"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        }
        
        //matrix 120hal 50-300eks
        if
        ((cb_halaman.getSelectedItem().toString().equals("120"))
                &&
        (cb_halaman.getSelectedItem().toString().equals("50"))) {
            Hasil = Double.toString(Double.parseDouble(b) *
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("120"))
                &&
        (cb_eks.getSelectedItem().toString().equals("100"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("120"))
                &&
        (cb_eks.getSelectedItem().toString().equals("150"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("120"))
                &&
        (cb_eks.getSelectedItem().toString().equals("200"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("120"))
                &&
        (cb_eks.getSelectedItem().toString().equals("250"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        }else if
        ((cb_halaman.getSelectedItem().toString().equals("120"))
                &&
        (cb_eks.getSelectedItem().toString().equals("300"))) {
            Hasil = Double.toString(Double.parseDouble(b)*
        Double.parseDouble(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString()));
            lNominal.setText(Hasil);
            mb_satuan.setText("x Biaya @Buku " + 
        jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        }
        
        mb_hal.setText(a + " Halaman");
        mb_eks.setText(b + " Eksemplar");
    }
    
    void ambilNilaiBaris(){
        try {
            txt_Nama.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            txt_nidn.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            txt_isbn.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                txt_isbn.setEnabled(false);     
            txt_judul.setText(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
            txt_tahun.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            cb_halaman.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
            cb_eks.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            lNominal.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        } catch (Exception e){
        }
    }
    void panggilHapus(){
        String kode_ambil = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        int pilih = JOptionPane.showConfirmDialog(this, "Hapus Data ISBN "+ kode_ambil +" KONFIRMASI ", "KONFIRMASI ",
                JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_NO_OPTION){
            try{
                _Cnn = jKoneksi.getConnection();
                String _sqlDelete = "DELETE FROM `tb_penulis`"
                        + " WHERE `tb_penulis`.`isbn`='"+ kode_ambil +"'";
                PreparedStatement pre = _Cnn.prepareStatement(_sqlDelete);
                pre.executeUpdate();
                pre.close();
                System.out.println(_sqlDelete);
                loadData();
                loadBukuMatriks();
                panggilBersih();
            }catch (SQLException e){
                Logger.getLogger(jKoneksi.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    void panggilBersih(){
        try{
            txt_Nama.setText(null);
            txt_nidn.setText(null);
            txt_isbn.setText(null);
             txt_isbn.setEnabled(true); 
            txt_judul.setText(null);
            txt_tahun.setText(null);
            cb_halaman.setSelectedItem("");
            cb_eks.setSelectedItem("");
            lNominal.setText("xxx.xxx.xxx");
            loadData();
            loadBukuMatriks();
        } catch (Exception e){
        }
    }  
    void panggilSimpandata(){
        try{
            String _sql = "";
            _Cnn = jKoneksi.getConnection();
            //gunakan query mysql
            _sql = "INSERT INTO `tb_penulis` (`NAMA`, `NIDN`, `ISBN`, `JUDUL`, `TAHUN`, `HAL`, `EKS`, `NOMINAL`) VALUES "
                    + "('"+ txt_Nama.getText() +"', '"+ txt_nidn.getText()
                    + "', '"+ txt_isbn.getText() +"', '"+ txt_judul.getText()
                    + "', '"+ txt_tahun.getText() +"',"+ " '"
                    + cb_halaman.getSelectedItem().toString() +"', '"
                    + cb_eks.getSelectedItem().toString() +"', '"+ lNominal.getText() +"');";
                    //dengan menggunakan ketentuan ini akan diubah sesuai keperluan
                    //value berdasarkan variabel yang telah ditentukan sebelumnya
            int status = jKoneksi.executestatement(_sql);
            if(status == 1){
                System.out.println(_sql);
                loadData();
                loadBukuMatriks();
                panggilBersih();
            }else{
                JOptionPane.showMessageDialog(null, "ERROR "+ _sql);
                System.out.println("Gagal simpan");
            }
        }catch (Exception e){
            System.out.println("ERROR"+ e);
        }
    }
    void PanggilUpdatedata(){
         String SQLUpdateQuery = "";
        try{
            _Cnn = jKoneksi.getConnection();
            Statement st = _Cnn.createStatement();
            //gunakan query sql,
            //jika error tidak bisa mengambil value variabel 
            //di coba dengan mengganti menjadi String.valueOf(nama)
            SQLUpdateQuery = "UPDATE `tb_penulis` SET"
                    +"`nama` = '"+ txt_Nama.getText() +"',"
                    +"`nidn` = '"+ txt_nidn.getText() +"',"
                    +"`isbn` = '"+ txt_isbn.getText() +"',"
                    +"`judul` = '"+ txt_judul.getText() +"',"
                    +"`tahun` = '"+ txt_tahun.getText() +"',"
                    +"`hal` = '"+ cb_halaman.getSelectedItem().toString()+"',"
                    +"`eks` = '"+ cb_eks.getSelectedItem().toString() +"',"
                    +"`nominal` = '"+ lNominal.getText() +"'"
                    +" WHERE `tb_penulis`.`isbn` = '"+ txt_isbn.getText() +"'";
            int status = jKoneksi.executestatement(SQLUpdateQuery);
            PreparedStatement pre = _Cnn.prepareStatement(SQLUpdateQuery);
            _Cnn.prepareStatement(SQLUpdateQuery);
            if(status == 1){
                pre.setString(1, this.txt_Nama.getText());
                pre.setString(2, this.txt_nidn.getText());
                pre.setString(3, this.txt_isbn.getText());
                pre.setString(4, this.txt_judul.getText());
                pre.setString(5, this.txt_tahun.getText());
                pre.setString(6, this.cb_halaman.getSelectedItem().toString());
                pre.setString(7, this.cb_eks.getSelectedItem().toString());
                pre.setString(8, this.lNominal.getText());
                pre.executeUpdate();
                _Cnn = jKoneksi.getConnection();
            }
            pre.close();
        }catch (Exception e){
            panggilBersih();
            System.out.println("Eksekusi"+ SQLUpdateQuery.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bRef = new javax.swing.JButton();
        bKeluar = new javax.swing.JButton();
        lmatrixbuku = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        mb_hal = new javax.swing.JLabel();
        mb_eks = new javax.swing.JLabel();
        lTotal = new javax.swing.JLabel();
        lRp = new javax.swing.JLabel();
        mb_satuan = new javax.swing.JLabel();
        lNominal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cb_pencarian = new javax.swing.JComboBox<>();
        txt_cari = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lnama = new javax.swing.JLabel();
        lisbn = new javax.swing.JLabel();
        ljudul = new javax.swing.JLabel();
        lnidn = new javax.swing.JLabel();
        txt_Nama = new javax.swing.JTextField();
        txt_nidn = new javax.swing.JTextField();
        txt_isbn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_judul = new javax.swing.JTextArea();
        ltahun = new javax.swing.JLabel();
        txt_tahun = new javax.swing.JTextField();
        lhalaman = new javax.swing.JLabel();
        cb_halaman = new javax.swing.JComboBox<>();
        leksemplar = new javax.swing.JLabel();
        cb_eks = new javax.swing.JComboBox<>();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bRef.setText("Refresh");
        bRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefActionPerformed(evt);
            }
        });

        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        lmatrixbuku.setText("Matrix Buku");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        mb_hal.setText("Halaman");

        mb_eks.setText("Eksemplar");

        lTotal.setText("Total Biaya :");

        lRp.setText("Rp.");

        mb_satuan.setText("x Biaya @Buku");

        lNominal.setText("xxx.xxx.xxx.xxx");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel8.setText("Pencarian");

        cb_pencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAMA", "NIDN", "ISBN", "JUDUL", "TAHUN" }));

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cari)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        lnama.setText("NAMA");

        lisbn.setText("ISBN");

        ljudul.setText("JUDUL");

        lnidn.setText("NIDN");

        txt_Nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NamaKeyTyped(evt);
            }
        });

        txt_nidn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nidnKeyTyped(evt);
            }
        });

        txt_isbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_isbnKeyTyped(evt);
            }
        });

        txt_judul.setColumns(20);
        txt_judul.setRows(5);
        jScrollPane1.setViewportView(txt_judul);

        ltahun.setText("TAHUN");

        txt_tahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tahunKeyTyped(evt);
            }
        });

        lhalaman.setText("Halaman");

        cb_halaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "80", "100", "120" }));
        cb_halaman.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_halamanItemStateChanged(evt);
            }
        });

        leksemplar.setText("Eksemplar");

        cb_eks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50", "100", "150", "200", "250", "300" }));
        cb_eks.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_eksItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lisbn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lnidn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_nidn, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lnama)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ljudul)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(leksemplar)
                            .addComponent(cb_eks, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ltahun)
                                    .addComponent(lhalaman, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(cb_halaman, 0, 182, Short.MAX_VALUE))
                                    .addComponent(txt_tahun))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnama)
                    .addComponent(txt_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnidn)
                    .addComponent(txt_nidn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lisbn)
                    .addComponent(txt_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ljudul)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ltahun)
                                .addComponent(txt_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_halaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lhalaman))
                        .addGap(9, 9, 9)
                        .addComponent(leksemplar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_eks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lmatrixbuku)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bTambah)
                                        .addGap(2, 2, 2)
                                        .addComponent(bUbah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bHapus)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bRef)
                                    .addComponent(bKeluar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mb_hal)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mb_eks)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(mb_satuan)))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lRp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lTotal)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bTambah)
                            .addComponent(bUbah)
                            .addComponent(bHapus)
                            .addComponent(bRef))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bKeluar)
                            .addComponent(lmatrixbuku))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mb_hal)
                            .addComponent(lTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mb_eks)
                            .addComponent(mb_satuan)
                            .addComponent(lRp)
                            .addComponent(lNominal))
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
        loadBukuMatriks();
    }//GEN-LAST:event_txt_cariKeyPressed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
       try {
           loadData();
       }catch (Exception e){
           
       }
    }//GEN-LAST:event_txt_cariKeyReleased

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        try {
            loadData();
       }catch (Exception e){
           
       }
    
    }//GEN-LAST:event_txt_cariKeyTyped

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        PanggilUpdatedata();
    }//GEN-LAST:event_bUbahActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        try{
            txt_isbn.setEnabled(true);
            if (txt_Nama.getText().equals(null)
                || txt_nidn.getText().equals(null)
                || txt_isbn.getText().equals(null)
                || txt_judul.getText().equals(null)
                || txt_tahun.getText().equals(null)){
                JOptionPane.showMessageDialog(null, "ERROR DATA KOSONG ");
            } else {
                panggilSimpandata();
            }
            panggilBersih();
                
        }catch (Exception e){
            
        }
    }//GEN-LAST:event_bTambahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        panggilHapus();
    }//GEN-LAST:event_bHapusActionPerformed

    private void bRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefActionPerformed
        panggilBersih();
    }//GEN-LAST:event_bRefActionPerformed

    private void txt_nidnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nidnKeyTyped
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c)
                ||(c == KeyEvent.VK_BACK_SPACE)
                ||(c == KeyEvent.VK_DELETE)
                ||(c == KeyEvent.VK_SPACE)
                ||(c == KeyEvent.VK_ENTER)))){
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Masukan Huruf 0-9");
            evt.consume();
        }
        if (c == evt.VK_ENTER){
            txt_isbn.requestFocus();
        }
    }//GEN-LAST:event_txt_nidnKeyTyped

    private void txt_tahunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tahunKeyTyped
       char c = evt.getKeyChar();
        if (!((Character.isDigit(c)
                ||(c == KeyEvent.VK_BACK_SPACE)
                ||(c == KeyEvent.VK_DELETE)
                ||(c == KeyEvent.VK_SPACE)
                ||(c == KeyEvent.VK_ENTER)))){
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Masukan Huruf 0-9");
            evt.consume();
        }
        if (c == evt.VK_ENTER){
            txt_isbn.requestFocus();
        }
    }//GEN-LAST:event_txt_tahunKeyTyped

    private void cb_halamanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_halamanItemStateChanged
      loadBukuMatriks();
      loadData();
    }//GEN-LAST:event_cb_halamanItemStateChanged

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_bKeluarActionPerformed

    private void cb_eksItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_eksItemStateChanged
        HitunganTotal();
    }//GEN-LAST:event_cb_eksItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        ambilNilaiBaris();
    }//GEN-LAST:event_jTable1MouseClicked

    private void txt_NamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NamaKeyTyped
         char c = evt.getKeyChar();
        if (!((Character.isLetter(c)
                ||(c == KeyEvent.VK_BACK_SPACE)
                ||(c == KeyEvent.VK_DELETE)
                ||(c == KeyEvent.VK_SPACE)
                ||(c == KeyEvent.VK_ENTER)))){
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Masukan Huruf A-Z");
            evt.consume();
        }
        if (c == evt.VK_ENTER){
            txt_isbn.requestFocus();
        }
    }//GEN-LAST:event_txt_NamaKeyTyped

    private void txt_isbnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_isbnKeyTyped
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c)
                ||(c == KeyEvent.VK_BACK_SPACE)
                ||(c == KeyEvent.VK_DELETE)
                ||(c == KeyEvent.VK_SPACE)
                ||(c == KeyEvent.VK_ENTER)))){
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Masukan Huruf A-Z");
            evt.consume();
        }
        if (c == evt.VK_ENTER){
            txt_isbn.requestFocus();
    }//GEN-LAST:event_txt_isbnKeyTyped
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bRef;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUbah;
    private javax.swing.JComboBox<String> cb_eks;
    private javax.swing.JComboBox<String> cb_halaman;
    private javax.swing.JComboBox<String> cb_pencarian;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lNominal;
    private javax.swing.JLabel lRp;
    private javax.swing.JLabel lTotal;
    private javax.swing.JLabel leksemplar;
    private javax.swing.JLabel lhalaman;
    private javax.swing.JLabel lisbn;
    private javax.swing.JLabel ljudul;
    private javax.swing.JLabel lmatrixbuku;
    private javax.swing.JLabel lnama;
    private javax.swing.JLabel lnidn;
    private javax.swing.JLabel ltahun;
    private javax.swing.JLabel mb_eks;
    private javax.swing.JLabel mb_hal;
    private javax.swing.JLabel mb_satuan;
    private javax.swing.JTextField txt_Nama;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_isbn;
    private javax.swing.JTextArea txt_judul;
    private javax.swing.JTextField txt_nidn;
    private javax.swing.JTextField txt_tahun;
    // End of variables declaration//GEN-END:variables
}
