/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author M.BAHRIL.I
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jKoneksi {
    public static String almtDir = System.getProperty("user.dir")+"/src/report/";
    public static Connection vkoneksi = null; //+static
    private boolean blnlsConnected = false;
    private String jServer = "localhost:3306"; //setting sesuai setting instal xampp server dan port
    private String jDatabase = "uniska_press"; //database yang akan di tuju
    private String jUser = "root"; //isi sesuai dengan kreteria user akses data di xampp
    private String jPassword = ""; //sesuai dengan pasword jika ada 
    
    public void setServer(String value){
    jServer = value;
    System.out.println(jServer);
    }
    
    public void setUser(String value){
        jUser = value;
    }
    
    public void setDatabase(String value){
        jDatabase = value;
    }
    
    public String getServer(){
        return jServer;
    }
    
    public String getUser(){
        return jUser;
    }
    
    public String getPassword(){
        return jPassword;
    }
    
    public String getDatabase(){
        return jDatabase;
    }
    
    public static Connection getConnection(){
        return vkoneksi;
    }
    
    public boolean isConnected(){
        return blnlsConnected;
    }
    
    private boolean isValidConf(){
        boolean result = false;
        try{
            if (jServer.equals("") || jDatabase.equals("") || jUser.equals("")){
                result = false;
            }else{
                result = true;
            }
            } catch (Exception e){
                System.out.println(e);
        }
        return result;
    }
    
    public boolean makeConnect(){
        String urlValue ;
        blnlsConnected = false;
        try{
            Class.forName("com.mysql.jdbc.Driver"); //load Driver
            urlValue = "jdbc:mysql://" + jServer + "/" + jDatabase + "?user=" + jUser + "&password=" + jPassword;
           if(isValidConf()){
               vkoneksi = DriverManager.getConnection(urlValue);
               blnlsConnected =true;
               System.out.println("koneksi sesuai kondisi, ditemukan");
           } 
           }catch (SQLException e){
               System.out.println("koneksi gagal" + e.toString());
           }catch(ClassNotFoundException e){
               System.out.println("jdbc.Driver tidak ditemukan");
           }
        if(blnlsConnected == false){
            System.out.println("Koneksi Gagalll");
        }
        return blnlsConnected;
    }

    public void konek(){
        vkoneksi = null;
        makeConnect();
    }
    
    public static int executestatement(String Q){
        int status = 0;
        try{
            Statement st = getConnection().createStatement();
            status = st.executeUpdate(Q);
        } catch (SQLException ex){
            Logger.getLogger(jKoneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static ResultSet executeQuery(String SQL){
        ResultSet rs = null;
        try{
            Statement st = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(SQL);
        }catch(SQLException ex){
            Logger.getLogger(jKoneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
