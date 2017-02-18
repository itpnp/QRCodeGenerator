/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author hbb
 */
public class Connector {
  
   Statement stat;
   private static Connection konek;
   private static Connector koneksi = null;

    public  Connection getConnected(){
         try
         {
         String alamat_database = "jdbc:mysql://localhost:3306/astra";
         String user = "root";
         String psswd = "";    
         DriverManager.registerDriver(new com.mysql.jdbc.Driver());
         konek = DriverManager.getConnection(alamat_database, user, psswd);
         }
         catch(SQLException se)
         {
           JOptionPane.showMessageDialog(null, "Gagal terhubung ke database \nMaaf, Anda tidak dapat menggunakan aplikasi", "Kesalahan Sambungan", JOptionPane.INFORMATION_MESSAGE);
           System.out.println(se);
           System.exit(1);
         }
       return konek;
    }
    
    public Connector getInstance(){
        
     Connector con = null;
        if (koneksi == null) {
            koneksi = new Connector();
            con = koneksi;
        } else {
          con = koneksi;
        }
        return con;

    }
}
