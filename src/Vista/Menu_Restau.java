/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import javax.swing.JOptionPane;
import Ventanas_Administracion.*;

/**
 *
 * @author toobal
 */
public class Menu_Restau extends javax.swing.JFrame {

    public Menu_Restau() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButtonsalir = new javax.swing.JButton();
        jButtonstock = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonsalir.setBackground(new java.awt.Color(255, 255, 255));
        jButtonsalir.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonsalir.setText("Salir");
        jButtonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 100, -1));

        jButtonstock.setBackground(new java.awt.Color(255, 255, 255));
        jButtonstock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonstock.setForeground(new java.awt.Color(51, 51, 51));
        jButtonstock.setText("Administracion de Ingredientes");
        jButtonstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonstockActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 240, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_final.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, -10, 240, 360));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoooo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 1200, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonsalirActionPerformed

    private void jButtonstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonstockActionPerformed
        Ventanas_Administracion.Ventana_administracion_ingrediente ingred = new Ventanas_Administracion.Ventana_administracion_ingrediente();
        ingred.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonstockActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Restau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Restau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Restau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Restau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Restau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonsalir;
    private javax.swing.JButton jButtonstock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
