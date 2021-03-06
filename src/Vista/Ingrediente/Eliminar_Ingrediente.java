/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Ingrediente;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Clases.*;
import Ventanas_Administracion.*;

/**
 *
 * @author lawlo
 */
public class Eliminar_Ingrediente extends javax.swing.JFrame {

    /**
     * Creates new form Eliminar_productos
     */
    public Eliminar_Ingrediente() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("eliminar stock");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nomprod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_mostrar = new javax.swing.JTable();
        jb_buscar = new javax.swing.JButton();
        jb_volver = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jb_eliminar = new javax.swing.JButton();
        jbmostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Eliminar Ingrediente");

        jLabel2.setText("Nombre del Ingrediente");

        txt_nomprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nomprodKeyTyped(evt);
            }
        });

        jt_mostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jt_mostrar);

        jb_buscar.setText("Buscar");
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });

        jb_volver.setText("Volver");
        jb_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_volverActionPerformed(evt);
            }
        });

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        jb_eliminar.setText("Eliminar");
        jb_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminarActionPerformed(evt);
            }
        });

        jbmostrar.setText("Mostrar");
        jbmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbmostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_nomprod, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(233, 233, 233)
                                .addComponent(jb_buscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_eliminar)
                .addGap(39, 39, 39)
                .addComponent(jbmostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_volver)
                .addGap(42, 42, 42)
                .addComponent(jb_salir)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nomprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_volver)
                    .addComponent(jb_salir)
                    .addComponent(jb_eliminar)
                    .addComponent(jbmostrar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_volverActionPerformed
        // TODO add your handling code here:
        Ventana_administracion_ingrediente ads = new Ventana_administracion_ingrediente();
        ads.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jb_volverActionPerformed

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        // TODO add your handling code here:
        try
        {
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Stock");
        this.jt_mostrar.setModel(modelo);
          try 
          {
            ResultSet rs = Manejadora.buscarIngrediente(this.txt_nomprod.getText());
            String [] datos = new String[3];
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                modelo.addRow(datos);
                this.jt_mostrar.setModel(modelo);
            }
          }
          catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Eliminar_Ingrediente.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se ha ingresado un NOMBRE");
        }
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void txt_nomprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomprodKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if((n<'a' || n>'z') && (n<'A' || n>'Z') && (n<' ' || n>' '))evt.consume();
    }//GEN-LAST:event_txt_nomprodKeyTyped

    private void jb_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selec;
        selec = (Integer)this.jt_mostrar.getSelectedRow();
       
        if (selec==-1) 
        {
            JOptionPane.showMessageDialog(this,"No se ha seleccionado ninguna fila");
        }
        else
        {
     
        int conf = JOptionPane.showConfirmDialog(this,"Esta seguro de eliminar seleccionado?");
        if (JOptionPane.OK_OPTION == conf) {

        selec = (Integer)this.jt_mostrar.getSelectedRow();
        String nom_prod;
        nom_prod = this.jt_mostrar.getValueAt(selec, 1).toString();
        try {
            Manejadora.eliminarIngrediente(conf, nom_prod);
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(Eliminar_Ingrediente.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(this,"Registro eliminado");
            this.txt_nomprod.setText(null);
        }     
        }   
    }//GEN-LAST:event_jb_eliminarActionPerformed

    private void jbmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbmostrarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre Ingrediente");
        modelo.addColumn("Stock Producto");
        this.jt_mostrar.setModel(modelo);

        try {
            ResultSet rs = Manejadora.mostrarIngrediente();
            String [] datos = new String[10];
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                modelo.addRow(datos);
                this.jt_mostrar.setModel(modelo);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Ingrediente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbmostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Eliminar_Ingrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Ingrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Ingrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Ingrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar_Ingrediente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_eliminar;
    private javax.swing.JButton jb_salir;
    private javax.swing.JButton jb_volver;
    private javax.swing.JButton jbmostrar;
    private javax.swing.JTable jt_mostrar;
    private javax.swing.JTextField txt_nomprod;
    // End of variables declaration//GEN-END:variables
}
