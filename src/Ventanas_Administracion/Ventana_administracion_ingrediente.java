/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas_Administracion;
import Vista.Ingrediente.Ingresar_Ingrediente;
import Vista.*;
import Vista.Ingrediente.Mostrar_Ingrediente;
import Ventanas_Administracion.*;
import Vista.Ingrediente.Eliminar_Ingrediente;
import Vista.Ingrediente.Interfaz_modificar_ingrediente;
/**
 *
 * @author lawlo
 */
public class Ventana_administracion_ingrediente extends javax.swing.JFrame {

    
    /**
     * Creates new form Admin_stock
     */
    public Ventana_administracion_ingrediente() {
         initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonvolver = new javax.swing.JButton();
        jButtonsalir = new javax.swing.JButton();
        jButton_Ingresar_S = new javax.swing.JButton();
        jButton_modificar_S = new javax.swing.JButton();
        jButton_eliminar_S = new javax.swing.JButton();
        jButton_mostrar_S = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jButtonvolver.setText("Volver");
        jButtonvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonvolverActionPerformed(evt);
            }
        });

        jButtonsalir.setText("Salir");
        jButtonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsalirActionPerformed(evt);
            }
        });

        jButton_Ingresar_S.setText("Ingresar Ingrediente");
        jButton_Ingresar_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Ingresar_SActionPerformed(evt);
            }
        });

        jButton_modificar_S.setText("Modificar Ingrediente");
        jButton_modificar_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_SActionPerformed(evt);
            }
        });

        jButton_eliminar_S.setText("Eliminar Ingrediente");
        jButton_eliminar_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminar_SActionPerformed(evt);
            }
        });

        jButton_mostrar_S.setText("Mostrar Ingrediente");
        jButton_mostrar_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_mostrar_SActionPerformed(evt);
            }
        });

        jLabel1.setText("Administracion de ingredientes STOCK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButtonvolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                .addComponent(jButtonsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_S, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_Ingresar_S, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_eliminar_S, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_mostrar_S, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton_Ingresar_S)
                .addGap(27, 27, 27)
                .addComponent(jButton_modificar_S)
                .addGap(35, 35, 35)
                .addComponent(jButton_eliminar_S)
                .addGap(18, 18, 18)
                .addComponent(jButton_mostrar_S)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonvolver)
                    .addComponent(jButtonsalir))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonvolverActionPerformed
        Menu_principal principal = new Menu_principal();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonvolverActionPerformed

    private void jButtonsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonsalirActionPerformed

    private void jButton_eliminar_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminar_SActionPerformed
        // TODO add your handling code here:
       Eliminar_Ingrediente eleminar_prod = new Eliminar_Ingrediente();
        eleminar_prod.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_eliminar_SActionPerformed

    private void jButton_Ingresar_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Ingresar_SActionPerformed
        // TODO add your handling code here:
        Ingresar_Ingrediente ingr_ingre = new Ingresar_Ingrediente();
        ingr_ingre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_Ingresar_SActionPerformed

    private void jButton_modificar_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_SActionPerformed
        // TODO add your handling code here:
       Interfaz_modificar_ingrediente modificar_prod = new Interfaz_modificar_ingrediente();
        modificar_prod.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_modificar_SActionPerformed

    private void jButton_mostrar_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_mostrar_SActionPerformed
        // TODO add your handling code here:
        Mostrar_Ingrediente mostrar_prod = new Mostrar_Ingrediente();
        mostrar_prod.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_mostrar_SActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_administracion_ingrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_administracion_ingrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_administracion_ingrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_administracion_ingrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_administracion_ingrediente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Ingresar_S;
    private javax.swing.JButton jButton_eliminar_S;
    private javax.swing.JButton jButton_modificar_S;
    private javax.swing.JButton jButton_mostrar_S;
    private javax.swing.JButton jButtonsalir;
    private javax.swing.JButton jButtonvolver;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
