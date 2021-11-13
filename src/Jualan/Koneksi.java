/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jualan;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fajar
 */
public class Koneksi {
    private static java.sql.Connection koneksi_db = null;
    
    public static java.sql.Connection KoneksiDatabase(){
        MysqlDataSource pelajar = new MysqlDataSource();
        
        pelajar.setDatabaseName("penjualan");// Nama database
        pelajar.setPassword("");
        pelajar.setUser("root");
        
        try {
            koneksi_db = pelajar.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR"+e.getMessage());
        }
        
        if(koneksi_db == null){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal");
        } 
        return koneksi_db;
    }
}
