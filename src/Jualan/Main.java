/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jualan;

/**
 *
 * @author fajar
 */
public class Main {
    public static void main(String[] args) {
        new Menu_Barang().setVisible(true);
        Koneksi.KoneksiDatabase();
    }
}
