/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jualan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fajar
 */
public class Menu_Barang extends javax.swing.JFrame {
private PreparedStatement ps = null;
    /**
     * Creates new form Menu_Barang
     */
    public Menu_Barang() {
        initComponents();
        tampilkanTable();
        
        
    }
    
    private void Simpan(){
        try {
            if((txtkd_brg.getText().equals(""))
                    || (txtnama_brg.getText().equals(""))
                    || (txthrg_beli.getText().equals(""))
                    || (txthrg_jual.getText().equals(""))
                    || (txtstock.getText().equals(""))
                    || (txtstock_min.getText().equals(""))){
                JOptionPane.showMessageDialog(null,"Lengkapi data dengan benar");
            } else{
                // samakan dengan isi tabel 
                String SQLB = "insert into barang(kd_brg,nama_brg,hrg_beli,hrg_jual,stock,stock_min)values"
                        +"('"+txtkd_brg.getText()
                        +"','"+txtnama_brg.getText()
                        +"','"+txthrg_beli.getText()
                        +"','"+txthrg_jual.getText()
                        +"','"+txtstock.getText()
                        +"','"+txtstock_min.getText()+"')";
                
                ps = Koneksi.KoneksiDatabase().prepareStatement(SQLB);
                ps.executeUpdate(SQLB);
                JOptionPane.showMessageDialog(this,"Data Berhasil disimpan");
                tampilkanTable();
                
                refres();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"ERROR"+e.getMessage());
        }
    }
    
    private void tampilkanTable(){
        try {
            String SQLB = "select * from barang";
            Object[] row = {"Kode barang", "Nama Barang","Harga Beli","Harga Jual","Stock","Stock Min"};
            DefaultTableModel dtm = new DefaultTableModel(null,row);
            tbjual.setModel(dtm);
            jScrollPane1.setEnabled(true);
            jScrollPane1.setBorder(null);
            jScrollPane1.setViewportView(tbjual);
            
            ResultSet rs ;
            ps = Koneksi.KoneksiDatabase().prepareStatement(SQLB);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String kode = rs.getString(1);
                String nama = rs.getString(2);
                String harga = rs.getString(3);
                String jual = rs.getString(4);
                String Stock = rs.getString(5);
                String StockMin = rs.getString(6);
                
                String[] baris = {kode,nama,harga,jual,Stock,StockMin};
                dtm.addRow(baris);
            }
        } catch (SQLException e) {
        }
    }
    
    // tombol refres
    private void refres(){
        txthrg_beli.setText("");
        txthrg_jual.setText("");
        txtkd_brg.setText("");
        txtnama_brg.setText("");
        txtstock.setText("");
        txtstock_min.setText("");
    }
    
    // tombol edit
    private void edit(){
        try {
            if((txtkd_brg.getText().equals(""))
                    || (txtnama_brg.getText().equals(""))
                    || (txthrg_jual.getText().equals(""))
                    || (txthrg_beli.getText().equals(""))
                    || (txtstock.getText().equals(""))
                    || (txtstock_min.getText().equals(""))){
                JOptionPane.showMessageDialog(null,"Pilih yang akan di edit");
            } else{
                String SQLB = "Update barang set nama_brg='"+txtnama_brg.getText()
                        +"',hrg_beli='"+ txthrg_beli.getText()
                        +"',hrg_jual='"+ txthrg_jual.getText()
                        +"',stock ='"+ txtstock.getText()
                        +"', stock_min ='"+txtstock_min.getText()
                        +"'Where kd_brg ='"+ txtkd_brg.getText()+"'";
                ps = Koneksi.KoneksiDatabase().prepareStatement(SQLB);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data berhasil di rubah");
                refres();
                tampilkanTable();
            }
        } catch (SQLException e) {
        }
    }
    
    // Tombol hapus
    private void hapus(){
        try {
            if((txtkd_brg.getText().equals(""))
                    || (txtnama_brg.getText().equals(""))
                    || (txthrg_jual.getText().equals(""))
                    || (txthrg_beli.getText().equals(""))
                    || (txtstock.getText().equals(""))
                    || (txtstock_min.getText().equals(""))){
                JOptionPane.showMessageDialog(null,"Pilih yang akan di hapus");
            } else{
                String hapus = "Delete from barang where kd_brg='"+txtkd_brg.getText()+"'";
                ps = Koneksi.KoneksiDatabase().prepareStatement(hapus);
                ps.executeUpdate();
                tampilkanTable();
                refres();
                JOptionPane.showMessageDialog(null,"Data Berhasil di hapus");
            }
        } catch (SQLException e) {
        }
    }
    

    
    // mengambil data dari tabale ke kolom
    private void ambildata(){
        int ambil = tbjual.getSelectedRow();
        txtkd_brg.setText(tbjual.getModel().getValueAt(ambil, 0).toString());
        txtnama_brg.setText(tbjual.getModel().getValueAt(ambil, 1).toString());
        txthrg_beli.setText(tbjual.getModel().getValueAt(ambil, 2).toString());
        txthrg_jual.setText(tbjual.getModel().getValueAt(ambil, 3).toString());
        txtstock.setText(tbjual.getModel().getValueAt(ambil, 4).toString());
        txtstock_min.setText(tbjual.getModel().getValueAt(ambil, 5).toString());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txthrg_beli = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();
        txtstock_min = new javax.swing.JTextField();
        btnSImpan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode Barang");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Barang");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Harga Beli");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga Jual");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Stock Min");

        btnSImpan.setBackground(new java.awt.Color(102, 102, 102));
        btnSImpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSImpan.setText("Simpan");
        btnSImpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSImpanActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Refres");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSImpan)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtkd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(156, 156, 156)
                            .addComponent(jLabel5))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtnama_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txthrg_beli, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                        .addComponent(txthrg_jual))
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtstock, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addComponent(txtstock_min))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txtnama_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstock_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txthrg_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txthrg_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btnSImpan)
                    .addComponent(jButton4)
                    .addComponent(jButton2)))
        );

        tbjual.setModel(new javax.swing.table.DefaultTableModel(
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
        tbjual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbjualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbjual);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSImpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSImpanActionPerformed
        // TODO add your handling code here:
        Simpan();
    }//GEN-LAST:event_btnSImpanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        refres();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbjualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbjualMouseClicked
        // TODO add your handling code here:
        ambildata();
    }//GEN-LAST:event_tbjualMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSImpan;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTable tbjual = new javax.swing.JTable();
    private javax.swing.JTextField txthrg_beli;
    public static final javax.swing.JTextField txthrg_jual = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtkd_brg = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtnama_brg = new javax.swing.JTextField();
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtstock_min;
    // End of variables declaration//GEN-END:variables
}
