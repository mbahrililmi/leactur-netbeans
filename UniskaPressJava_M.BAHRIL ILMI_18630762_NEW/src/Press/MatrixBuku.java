/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Press;


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

/**
 *
 * @author M.BAHRIL.I
 */
public class MatrixBuku extends javax.swing.JInternalFrame {
    
    private DefaultTableModel _Modtab;
    Connection _Cnn;
    /**
     * Creates new form MatrixBuku
     */
    public MatrixBuku() {
        initComponents();
        setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        
        String[] setKolom = {"'HAL/EKS'", "'50 EKS'", "'100 EKS'", "'150 EKS'", "'200 EKS'", "'250 EKS'", "300 EKS"};
        _Modtab = new DefaultTableModel(null, setKolom) {
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
                 
            };
            
            public Class getColumClass(int columnIndex){
                return types[columnIndex];
            }
            
            public boolean isCellEditable(int row, int col){
                int kol = _Modtab.getColumnCount();
                return (col < kol) ? false : true;
            }     
        };
    jTable1.setModel(_Modtab); 
    loadDatatb1();
    }
    
    public void hapusRowData(){
                int row = _Modtab.getColumnCount();
                
                while (_Modtab.getRowCount() > 0){
                    _Modtab.setRowCount(0);
                }
    }
    
    private  void loadDatatb1(){
        String _sql = "";
        jKoneksi vConn = new jKoneksi();
        vConn.makeConnect();
        hapusRowData();
        try{
            _Cnn = vConn.vkoneksi;
            if (txt_pencarian.getText().equals("")) {
                _sql = "SELECT * FROM `buku_matrix`";
            }else{
                _sql = "SELECT * FROM `buku_matrix` WHERE `" +
            cb_pencarian.getSelectedItem()
                        + "` LIKE '%" + txt_pencarian.getText() + "%'";
                System.out.println(_sql);
            }
            System.out.println(_sql);
            Statement st = _Cnn.createStatement();
            ResultSet res = st.executeQuery(_sql);
            while (res.next()) {
                String hal = res.getString(1);
                String eks50 = res.getString(2);
                String eks100 = res.getString(3);
                String eks150 = res.getString(4);
                String eks200 = res.getString(5);
                String eks250 = res.getString(6);
                String eks300 = res.getString(7);
                
                Object[] data = {hal, eks50, eks100, eks150, eks200, eks250, eks300};
                _Modtab.addRow(data);
            }
        
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            
        } catch (Exception e){
            System.out.println("Error" + e);
        }
    }
    
    void ambilNilaiBaris(){
        try {
            txt_hal.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            txt_50.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            txt_100.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                txt_hal.setEnabled(false);     
            txt_150.setText(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
            txt_200.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            txt_250.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
            txt_300.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        } catch (Exception e){
        }
    }
    
    void panggilHapus(){
        String kode_ambil = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        int pilih = JOptionPane.showConfirmDialog(this, "Hapus Data HAL/EKS "+ kode_ambil +" KONFIRMASI ", "KONFIRMASI ",
                JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_NO_OPTION){
            try{
                _Cnn = jKoneksi.getConnection();
                String _sqlDelete = "DELETE FROM `buku_matrix`"
                        + " WHERE `buku_matrix`.`hal/eks`='"+ kode_ambil +"'";
                PreparedStatement pre = _Cnn.prepareStatement(_sqlDelete);
                pre.executeUpdate();
                pre.close();
                System.out.println(_sqlDelete);
                loadDatatb1();
                panggilBersih();
            }catch (SQLException e){
                Logger.getLogger(jKoneksi.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    void panggilBersih(){
        try{
            txt_hal.setText(null);
             txt_hal.setEnabled(true);  
            txt_50.setText(null);
            txt_100.setText(null);
            txt_150.setText(null);
            txt_200.setText(null);
            txt_250.setText(null);
            txt_300.setText(null);
            
            loadDatatb1();
        } catch (Exception e){
        }
    } 
    
    void panggilSimpandata(){
        try{
            String _sql = "";
            _Cnn = jKoneksi.getConnection();
            //gunakan query mysql
            _sql = "INSERT INTO `buku_matrix` (`hal/eks`, `50eks`, `100eks`, `150eks`, `200eks`, `250eks`, `300eks`) VALUES "
                    + "('"+ txt_hal.getText() +"', '"+ txt_50.getText()
                    + "', '"+ txt_100.getText() +"', '"+ txt_150.getText()
                    + "', '"+ txt_200.getText() +"', '"+ txt_250.getText() +"', '"+ txt_300.getText() +"');";
                    //dengan menggunakan ketentuan ini akan diubah sesuai keperluan
                    //value berdasarkan variabel yang telah ditentukan sebelumnya
            int status = jKoneksi.executestatement(_sql);
            if(status == 1){
                System.out.println(_sql);
                loadDatatb1();
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
            SQLUpdateQuery = "UPDATE `buku_matrix` SET"
                    +"`hal/eks` = '"+ txt_hal.getText() +"',"
                    +"`50eks` = '"+ txt_50.getText() +"',"
                    +"`100eks` = '"+ txt_100.getText() +"',"
                    +"`150eks` = '"+ txt_150.getText() +"',"
                    +"`200eks` = '"+ txt_200.getText() +"',"
                    +"`250eks` = '"+ txt_250.getText() +"',"
                    +"`300eks` = '"+ txt_300.getText() +"'"
                    +" WHERE `buku_matrix`.`hal/eks` = '"+ txt_hal.getText() +"'";
            int status = jKoneksi.executestatement(SQLUpdateQuery);
            PreparedStatement pre = _Cnn.prepareStatement(SQLUpdateQuery);
            _Cnn.prepareStatement(SQLUpdateQuery);
            if(status == 1){
                pre.setString(1, this.txt_hal.getText());
                pre.setString(2, this.txt_50.getText());
                pre.setString(3, this.txt_100.getText());
                pre.setString(4, this.txt_150.getText());
                pre.setString(5, this.txt_200.getText());
                pre.setString(6, this.txt_250.getText());
                pre.setString(7, this.txt_300.getText());
                
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_pencarian = new javax.swing.JComboBox<>();
        txt_pencarian = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_hal = new javax.swing.JTextField();
        txt_50 = new javax.swing.JTextField();
        txt_100 = new javax.swing.JTextField();
        txt_150 = new javax.swing.JTextField();
        txt_200 = new javax.swing.JTextField();
        txt_250 = new javax.swing.JTextField();
        txt_300 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        bt_tambah = new javax.swing.JButton();
        bt_ubah = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_refres = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("pencarian");

        cb_pencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HAL/EKS", "50EKS", "100EKS", "150EKS", "200EKS", "250EKS", "300EKS" }));

        txt_pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pencarianKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pencarianKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pencarianKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cb_pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_pencarian))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setText("hal/eks");

        jLabel3.setText("50 eks");

        jLabel4.setText("100 eks");

        jLabel5.setText("150 eks");

        jLabel6.setText("200 eks");

        jLabel7.setText("250 eks");

        jLabel8.setText("300 eks");

        txt_hal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_halActionPerformed(evt);
            }
        });
        txt_hal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_halKeyTyped(evt);
            }
        });

        txt_50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_50ActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_150, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txt_200, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_250)
                            .addComponent(txt_100)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_50, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(txt_hal)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addComponent(txt_300, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_hal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_150, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_300, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_ubah.setText("Ubah");
        bt_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ubahActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_refres.setText("refresh");
        bt_refres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_refresActionPerformed(evt);
            }
        });

        bt_keluar.setText("keluar");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bt_tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_refres))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(bt_keluar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tambah)
                    .addComponent(bt_ubah)
                    .addComponent(bt_hapus)
                    .addComponent(bt_refres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_keluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_50ActionPerformed

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_keluarActionPerformed
       dispose();
    }//GEN-LAST:event_bt_keluarActionPerformed

    private void txt_pencarianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pencarianKeyPressed
       loadDatatb1();
    }//GEN-LAST:event_txt_pencarianKeyPressed

    private void txt_pencarianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pencarianKeyReleased
      loadDatatb1();
    }//GEN-LAST:event_txt_pencarianKeyReleased

    private void txt_pencarianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pencarianKeyTyped
        loadDatatb1();
    }//GEN-LAST:event_txt_pencarianKeyTyped

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
       try{
            txt_hal.setEnabled(true);
            if (txt_50.getText().equals(null)
                || txt_100.getText().equals(null)
                || txt_150.getText().equals(null)
                || txt_200.getText().equals(null)
                || txt_250.getText().equals(null)
                || txt_300.getText().equals(null)){
                JOptionPane.showMessageDialog(null, "ERROR DATA KOSONG ");
            } else {
                panggilSimpandata();
            }
            panggilBersih();
                
        }catch (Exception e){
            
        }
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ubahActionPerformed
        PanggilUpdatedata();
    }//GEN-LAST:event_bt_ubahActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        panggilHapus();
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_refresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_refresActionPerformed
        panggilBersih();
    }//GEN-LAST:event_bt_refresActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        ambilNilaiBaris();
    }//GEN-LAST:event_jTable1MouseClicked

    private void txt_halActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_halActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_halActionPerformed

    private void txt_halKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_halKeyTyped
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
            txt_hal.requestFocus();
        }
    }//GEN-LAST:event_txt_halKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_refres;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JButton bt_ubah;
    private javax.swing.JComboBox<String> cb_pencarian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_100;
    private javax.swing.JTextField txt_150;
    private javax.swing.JTextField txt_200;
    private javax.swing.JTextField txt_250;
    private javax.swing.JTextField txt_300;
    private javax.swing.JTextField txt_50;
    private javax.swing.JTextField txt_hal;
    private javax.swing.JTextField txt_pencarian;
    // End of variables declaration//GEN-END:variables
}
