/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Factura;


import Clases.Conexion_BD;
import Clases.Factura;
import Vista.Ingrediente.*;
import Clases.Ingrediente;
import Clases.Manejadora;

//import Ventanas.*;
import Ventanas_Administracion.Administrar_Mesas;
import Ventanas_Administracion.Administrar_Proveedor;
import Ventanas_Administracion.Administrar_datos_personal;
import Ventanas_Administracion.Menu_principal;
import Vista.Recetario.interfaz_Recetario;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Admin
 */
public class Interfaz_Factura extends javax.swing.JFrame {

    
             int lastid;      
            Connection con;
            ResultSet rs;
            Statement st;
            PreparedStatement pst;
    
    
    
        
    public Interfaz_Factura() {
        initComponents();
        getlastid();
        getlastid_n_factura();
        
        this.setLocationRelativeTo(this);
        setColor(btn_inicio); 
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_datper,btn_ingred_,btn_admmes}, new JPanel[]{ind_2,ind_3, ind_4});
        //jProgressBar1.setValue(50);
        btn_volver.setToolTipText(""
                + "<html>"
                + "<head>"
                + "<style>"
                + "#contenido{"
                + "backgroun: #f60;"
                + "color: black"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div id = 'contenido'>"
                + "<strong>Regresa una ventana atras.</strong>"
                + "</div>"
                + "</body>"
                + "</html>"
                +"");
   }
    
    
     public void getlastid()
    {
         try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String DB="jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "portafolio_tobal";
            String pass = "toballxd";
            String sql = "Select max(id_documento) from DOCUMENTO";
          Connection con = DriverManager.getConnection(DB, user, pass);  
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next())
            {
                lastid = rs.getInt(1);
                lastid++;
                text_id_factura.setText(Integer.toString(lastid));
            }
            
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        }catch (ClassNotFoundException cs) {
            
            System.out.println(cs.getMessage());
            
        }       
    }
     
     public void getlastid_n_factura()
    {
         try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String DB="jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "portafolio_tobal";
            String pass = "toballxd";
            String sql = "Select max(Numero_documento) from DOCUMENTO";
          Connection con = DriverManager.getConnection(DB, user, pass);  
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next())
            {
                lastid = rs.getInt(1);
                lastid++;
                text_n_documento.setText(Integer.toString(lastid));
            }
            
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        }catch (ClassNotFoundException cs) {
            
            System.out.println(cs.getMessage());
            
        }       
    }
 
     
     public void mostrarDatosPanel()
     {
         DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("N°Documento");
        modelo.addColumn("Tipo Documento");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Giro");
        modelo.addColumn("RUT");
        modelo.addColumn("Fecha Emision");
        modelo.addColumn("Fecha Vencimiento");
        modelo.addColumn("Medio Pago");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Descuento");
        modelo.addColumn("SubTotal");
        modelo.addColumn("Total Factura");
        modelo.addColumn("Descripcion Factura");
        
        
        this.jTable_mostrar.setModel(modelo);

        try {
            ResultSet rs = Manejadora.mostrarFactura();
            String [] datos = new String[14];
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                
                modelo.addRow(datos);
                this.jTable_mostrar.setModel(modelo);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
     public void LimpiarDatos()
     {
                this.jComboBox_tipo_documento.setSelectedIndex(0);
                this.text_nombre_proveedor.setText(null);
                this.text_giro.setText(null);
                this.text_rut_empresa.setText(null);
                this.txt_fecha_emision.setText(null);
                this.txt_fecha_vencimiento.setText(null);
                this.jComboBox_forma_pago.setSelectedIndex(0); 
                this.txt_impuesto.setText(null);
                this.text_descuento.setText(null);
                this.text_subtotal.setText(null);
                this.text_total_factura.setText(null);
                this.TextArea_descripcion.setText(null);
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
        btn_buscar_nombre = new javax.swing.JButton();
        text_nombre_proveedor = new javax.swing.JTextField();
        btn_modificar_mod_mesa = new javax.swing.JButton();
        btnLimpiar_datos = new javax.swing.JButton();
        pnl_barra_amarilla_agre_mesa4 = new javax.swing.JPanel();
        pnl_barra_amarilla_agre_mesa3 = new javax.swing.JPanel();
        pnl_barra_amarilla_agre_mesa2 = new javax.swing.JPanel();
        pnl_barra_amarilla_agre_mesa1 = new javax.swing.JPanel();
        jComboBox_tipo_documento = new javax.swing.JComboBox<>();
        txt_id_factura_pdf = new javax.swing.JTextField();
        btn_ver_factura = new javax.swing.JButton();
        lbl_num_documento = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        lbl_forma_pago = new javax.swing.JLabel();
        lbl_ingre_id_fac_pdf = new javax.swing.JLabel();
        lbl_fecha_venc = new javax.swing.JLabel();
        lbl_rut_empresa = new javax.swing.JLabel();
        lbl_giro = new javax.swing.JLabel();
        lbl_detalle_factura = new javax.swing.JLabel();
        text_rut_empresa = new javax.swing.JTextField();
        lbl_descuento = new javax.swing.JLabel();
        txt_fecha_emision = new javax.swing.JFormattedTextField();
        lbl_fecha_emision = new javax.swing.JLabel();
        lbl_impuesto = new javax.swing.JLabel();
        lbl_total_factura = new javax.swing.JLabel();
        lbl_subtotal = new javax.swing.JLabel();
        text_descuento = new javax.swing.JTextField();
        text_total_factura = new javax.swing.JTextField();
        txt_detalle_factura = new javax.swing.JScrollPane();
        TextArea_descripcion = new javax.swing.JTextArea();
        txt_fecha_vencimiento = new javax.swing.JFormattedTextField();
        text_subtotal = new javax.swing.JTextField();
        text_giro = new javax.swing.JTextField();
        txt_impuesto = new javax.swing.JFormattedTextField();
        text_n_documento = new javax.swing.JTextField();
        jComboBox_forma_pago = new javax.swing.JComboBox<>();
        jCombo_estado_pago = new javax.swing.JComboBox<>();
        lbl_filtrar_estado_pago = new javax.swing.JLabel();
        txt_mostrar = new javax.swing.JScrollPane();
        jTable_mostrar = new javax.swing.JTable();
        btn_agregar = new javax.swing.JButton();
        lbl_nombre_prove = new javax.swing.JLabel();
        btn_mostrar_most_mesa = new javax.swing.JButton();
        lbl_tipo_documento = new javax.swing.JLabel();
        lbl_logoazul_restau = new javax.swing.JLabel();
        text_id_factura = new javax.swing.JTextField();
        lbl_id_documento = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        pnl_barra_lateral = new javax.swing.JPanel();
        btn_inicio = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        lbl_inicio_agre_mesa = new javax.swing.JLabel();
        pnl_barra_amarilla = new javax.swing.JPanel();
        btn_prove = new javax.swing.JPanel();
        ind_11 = new javax.swing.JPanel();
        lbl_proveedores_agre_mesa = new javax.swing.JLabel();
        btn_datper = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        lbl_dtos_perso_agre_mesa = new javax.swing.JLabel();
        btn_admmes = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        lbl_adm_mesa_agre_mesa = new javax.swing.JLabel();
        btn_ingred_ = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        lbl_ingre_agre_mesa = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        btn_modulo_documento = new javax.swing.JPanel();
        ind_12 = new javax.swing.JPanel();
        lbl_proveedores_agre_mesa1 = new javax.swing.JLabel();
        btn_recetario = new javax.swing.JPanel();
        ind_13 = new javax.swing.JPanel();
        lbl_proveedores_agre_mesa2 = new javax.swing.JLabel();
        pnl_barra_superior = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        lbl_tipo_usuario = new javax.swing.JLabel();
        lbl_img_usuario = new javax.swing.JLabel();
        lbl_titulo_modulo_doc = new javax.swing.JLabel();
        lbl_fondo_interfaz_mod_docume = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        side_pane8 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buscar_nombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_P.png"))); // NOI18N
        btn_buscar_nombre.setText("Buscar por estado de pago");
        btn_buscar_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, 200, 30));
        getContentPane().add(text_nombre_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 220, -1));

        btn_modificar_mod_mesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Update.png"))); // NOI18N
        btn_modificar_mod_mesa.setText("Modificar");
        btn_modificar_mod_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_mod_mesaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar_mod_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 820, 120, -1));

        btnLimpiar_datos.setText("Limpiar Datos");
        btnLimpiar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar_datosActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 140, 170, -1));

        pnl_barra_amarilla_agre_mesa4.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_barra_amarilla_agre_mesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 1190, 10));

        pnl_barra_amarilla_agre_mesa3.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_barra_amarilla_agre_mesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 1200, 10));

        pnl_barra_amarilla_agre_mesa2.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_barra_amarilla_agre_mesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 180, 10, 340));

        pnl_barra_amarilla_agre_mesa1.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_barra_amarilla_agre_mesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 10, 330));

        jComboBox_tipo_documento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "FACTURA", "BOLETA" }));
        getContentPane().add(jComboBox_tipo_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 220, -1));

        txt_id_factura_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_factura_pdfActionPerformed(evt);
            }
        });
        txt_id_factura_pdf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_id_factura_pdfKeyTyped(evt);
            }
        });
        getContentPane().add(txt_id_factura_pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 220, -1));

        btn_ver_factura.setText("Ver Documento");
        btn_ver_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ver_facturaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ver_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 530, 240, 60));

        lbl_num_documento.setForeground(new java.awt.Color(255, 255, 255));
        lbl_num_documento.setText("Numero Documento");
        getContentPane().add(lbl_num_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, 20));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 820, 120, -1));

        lbl_forma_pago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_forma_pago.setForeground(new java.awt.Color(255, 255, 255));
        lbl_forma_pago.setText("FORMA DE PAGO:");
        getContentPane().add(lbl_forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 140, 20));

        lbl_ingre_id_fac_pdf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_ingre_id_fac_pdf.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ingre_id_fac_pdf.setText("INGRESE ID PARA VER FACTURA EN PDF");
        getContentPane().add(lbl_ingre_id_fac_pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, 240, 20));

        lbl_fecha_venc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_fecha_venc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fecha_venc.setText("FECHA VENCIMIENTO:");
        getContentPane().add(lbl_fecha_venc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 150, 20));

        lbl_rut_empresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_rut_empresa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rut_empresa.setText("RUT EMPRESA:");
        getContentPane().add(lbl_rut_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 140, 20));

        lbl_giro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_giro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_giro.setText("GIRO:");
        getContentPane().add(lbl_giro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 140, 20));

        lbl_detalle_factura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_detalle_factura.setForeground(new java.awt.Color(255, 255, 255));
        lbl_detalle_factura.setText("DETALLE FACTURA:");
        getContentPane().add(lbl_detalle_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 360, 130, 20));
        getContentPane().add(text_rut_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 220, -1));

        lbl_descuento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_descuento.setForeground(new java.awt.Color(255, 255, 255));
        lbl_descuento.setText("DESCUENTO:");
        getContentPane().add(lbl_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 150, 20));

        try {
            txt_fecha_emision.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txt_fecha_emision, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 220, -1));

        lbl_fecha_emision.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_fecha_emision.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fecha_emision.setText("FECHA EMISION");
        getContentPane().add(lbl_fecha_emision, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 140, 20));

        lbl_impuesto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_impuesto.setForeground(new java.awt.Color(255, 255, 255));
        lbl_impuesto.setText("IMPUESTO:");
        getContentPane().add(lbl_impuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 90, 20));

        lbl_total_factura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_total_factura.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total_factura.setText("TOTAL FACTURA:");
        getContentPane().add(lbl_total_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 150, 20));

        lbl_subtotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_subtotal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_subtotal.setText("SUBTOTAL");
        getContentPane().add(lbl_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 150, 20));
        getContentPane().add(text_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 300, -1));
        getContentPane().add(text_total_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, 300, -1));

        TextArea_descripcion.setColumns(20);
        TextArea_descripcion.setRows(5);
        txt_detalle_factura.setViewportView(TextArea_descripcion);

        getContentPane().add(txt_detalle_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 480, 120));

        try {
            txt_fecha_vencimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txt_fecha_vencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 220, -1));
        getContentPane().add(text_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 280, 300, -1));
        getContentPane().add(text_giro, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 220, -1));

        try {
            txt_impuesto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##%")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_impuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_impuestoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_impuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 300, -1));
        getContentPane().add(text_n_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 80, -1));

        jComboBox_forma_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "PAGADA", "NO PAGADA" }));
        getContentPane().add(jComboBox_forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 220, -1));

        jCombo_estado_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "PAGADA", "NO PAGADA" }));
        getContentPane().add(jCombo_estado_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 220, 20));

        lbl_filtrar_estado_pago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_filtrar_estado_pago.setForeground(new java.awt.Color(255, 255, 255));
        lbl_filtrar_estado_pago.setText("FILTRAR ESTADO DE PAGO");
        getContentPane().add(lbl_filtrar_estado_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 200, 20));

        jTable_mostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_mostrarMouseClicked(evt);
            }
        });
        txt_mostrar.setViewportView(jTable_mostrar);

        getContentPane().add(txt_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 1260, 200));

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        btn_agregar.setText("Guardar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 820, 110, -1));

        lbl_nombre_prove.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_nombre_prove.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre_prove.setText("NOMBRE PROVEEDOR");
        getContentPane().add(lbl_nombre_prove, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 140, 20));

        btn_mostrar_most_mesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Read.png"))); // NOI18N
        btn_mostrar_most_mesa.setText("Mostrar");
        btn_mostrar_most_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrar_most_mesaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mostrar_most_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 820, 110, -1));

        lbl_tipo_documento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_tipo_documento.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipo_documento.setText("TIPO DOCUMENTO:");
        getContentPane().add(lbl_tipo_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 130, 20));

        lbl_logoazul_restau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_superior_blanco.png"))); // NOI18N
        getContentPane().add(lbl_logoazul_restau, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 90));

        text_id_factura.setEditable(false);
        text_id_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_id_facturaActionPerformed(evt);
            }
        });
        getContentPane().add(text_id_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 70, -1));

        lbl_id_documento.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id_documento.setText("ID Documento");
        getContentPane().add(lbl_id_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, 20));

        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Volver.png"))); // NOI18N
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 820, 130, -1));

        pnl_barra_lateral.setBackground(new java.awt.Color(23, 35, 51));
        pnl_barra_lateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_inicio.setBackground(new java.awt.Color(23, 35, 51));
        btn_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_inicioMousePressed(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lbl_inicio_agre_mesa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_inicio_agre_mesa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_inicio_agre_mesa.setText("Inicio");

        javax.swing.GroupLayout btn_inicioLayout = new javax.swing.GroupLayout(btn_inicio);
        btn_inicio.setLayout(btn_inicioLayout);
        btn_inicioLayout.setHorizontalGroup(
            btn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_inicioLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lbl_inicio_agre_mesa)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        btn_inicioLayout.setVerticalGroup(
            btn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_inicioLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_inicio_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral.add(btn_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 120, -1));

        pnl_barra_amarilla.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_barra_lateral.add(pnl_barra_amarilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 10, 820));

        btn_prove.setBackground(new java.awt.Color(23, 35, 51));
        btn_prove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_proveMouseReleased(evt);
            }
        });

        ind_11.setOpaque(false);
        ind_11.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_11Layout = new javax.swing.GroupLayout(ind_11);
        ind_11.setLayout(ind_11Layout);
        ind_11Layout.setHorizontalGroup(
            ind_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_11Layout.setVerticalGroup(
            ind_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lbl_proveedores_agre_mesa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_proveedores_agre_mesa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_proveedores_agre_mesa.setText("Proveedores");

        javax.swing.GroupLayout btn_proveLayout = new javax.swing.GroupLayout(btn_prove);
        btn_prove.setLayout(btn_proveLayout);
        btn_proveLayout.setHorizontalGroup(
            btn_proveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_proveLayout.createSequentialGroup()
                .addComponent(ind_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_proveedores_agre_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btn_proveLayout.setVerticalGroup(
            btn_proveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_proveLayout.createSequentialGroup()
                .addComponent(ind_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_proveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_proveedores_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral.add(btn_prove, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 140, -1));

        btn_datper.setBackground(new java.awt.Color(23, 35, 51));
        btn_datper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_datperMouseReleased(evt);
            }
        });

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lbl_dtos_perso_agre_mesa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_dtos_perso_agre_mesa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dtos_perso_agre_mesa.setText("Datos de personal");

        javax.swing.GroupLayout btn_datperLayout = new javax.swing.GroupLayout(btn_datper);
        btn_datper.setLayout(btn_datperLayout);
        btn_datperLayout.setHorizontalGroup(
            btn_datperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_datperLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_dtos_perso_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        btn_datperLayout.setVerticalGroup(
            btn_datperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_datperLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_datperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_dtos_perso_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral.add(btn_datper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 140, -1));

        btn_admmes.setBackground(new java.awt.Color(23, 35, 51));
        btn_admmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_admmesMousePressed(evt);
            }
        });

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lbl_adm_mesa_agre_mesa.setBackground(new java.awt.Color(255, 255, 255));
        lbl_adm_mesa_agre_mesa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_adm_mesa_agre_mesa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_adm_mesa_agre_mesa.setText("Administrar Mesas");

        javax.swing.GroupLayout btn_admmesLayout = new javax.swing.GroupLayout(btn_admmes);
        btn_admmes.setLayout(btn_admmesLayout);
        btn_admmesLayout.setHorizontalGroup(
            btn_admmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_admmesLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_adm_mesa_agre_mesa)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        btn_admmesLayout.setVerticalGroup(
            btn_admmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_admmesLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_admmesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_adm_mesa_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral.add(btn_admmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 140, -1));

        btn_ingred_.setBackground(new java.awt.Color(23, 35, 51));
        btn_ingred_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ingred_MousePressed(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lbl_ingre_agre_mesa.setBackground(new java.awt.Color(255, 255, 255));
        lbl_ingre_agre_mesa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_ingre_agre_mesa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ingre_agre_mesa.setText("Ingredientes");

        javax.swing.GroupLayout btn_ingred_Layout = new javax.swing.GroupLayout(btn_ingred_);
        btn_ingred_.setLayout(btn_ingred_Layout);
        btn_ingred_Layout.setHorizontalGroup(
            btn_ingred_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingred_Layout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_ingre_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        btn_ingred_Layout.setVerticalGroup(
            btn_ingred_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingred_Layout.createSequentialGroup()
                .addGroup(btn_ingred_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ingre_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_barra_lateral.add(btn_ingred_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 140, 40));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Exit_25px.png"))); // NOI18N
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });
        pnl_barra_lateral.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 790, 30, 46));

        btn_modulo_documento.setBackground(new java.awt.Color(251, 243, 0));
        btn_modulo_documento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_modulo_documentoMouseReleased(evt);
            }
        });

        ind_12.setOpaque(false);
        ind_12.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_12Layout = new javax.swing.GroupLayout(ind_12);
        ind_12.setLayout(ind_12Layout);
        ind_12Layout.setHorizontalGroup(
            ind_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_12Layout.setVerticalGroup(
            ind_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lbl_proveedores_agre_mesa1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_proveedores_agre_mesa1.setText("Documentos");

        javax.swing.GroupLayout btn_modulo_documentoLayout = new javax.swing.GroupLayout(btn_modulo_documento);
        btn_modulo_documento.setLayout(btn_modulo_documentoLayout);
        btn_modulo_documentoLayout.setHorizontalGroup(
            btn_modulo_documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_modulo_documentoLayout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_proveedores_agre_mesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btn_modulo_documentoLayout.setVerticalGroup(
            btn_modulo_documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_modulo_documentoLayout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_modulo_documentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_proveedores_agre_mesa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral.add(btn_modulo_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 140, -1));

        btn_recetario.setBackground(new java.awt.Color(23, 35, 51));
        btn_recetario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_recetarioMouseReleased(evt);
            }
        });

        ind_13.setOpaque(false);
        ind_13.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_13Layout = new javax.swing.GroupLayout(ind_13);
        ind_13.setLayout(ind_13Layout);
        ind_13Layout.setHorizontalGroup(
            ind_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_13Layout.setVerticalGroup(
            ind_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lbl_proveedores_agre_mesa2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_proveedores_agre_mesa2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_proveedores_agre_mesa2.setText("Recetario");

        javax.swing.GroupLayout btn_recetarioLayout = new javax.swing.GroupLayout(btn_recetario);
        btn_recetario.setLayout(btn_recetarioLayout);
        btn_recetarioLayout.setHorizontalGroup(
            btn_recetarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_recetarioLayout.createSequentialGroup()
                .addComponent(ind_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_proveedores_agre_mesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btn_recetarioLayout.setVerticalGroup(
            btn_recetarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_recetarioLayout.createSequentialGroup()
                .addComponent(ind_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_recetarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_proveedores_agre_mesa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral.add(btn_recetario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 140, -1));

        getContentPane().add(pnl_barra_lateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 900));

        pnl_barra_superior.setBackground(new java.awt.Color(23, 35, 51));
        pnl_barra_superior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnl_barra_superiorMouseDragged(evt);
            }
        });
        pnl_barra_superior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_barra_superiorMousePressed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(123, 156, 225));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setPreferredSize(new java.awt.Dimension(2, 20));

        lbl_tipo_usuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_tipo_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipo_usuario.setText("Usuario: Administrador");

        lbl_img_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_User_48px.png"))); // NOI18N

        lbl_titulo_modulo_doc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_titulo_modulo_doc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo_modulo_doc.setText("Modulo de Documentos");

        javax.swing.GroupLayout pnl_barra_superiorLayout = new javax.swing.GroupLayout(pnl_barra_superior);
        pnl_barra_superior.setLayout(pnl_barra_superiorLayout);
        pnl_barra_superiorLayout.setHorizontalGroup(
            pnl_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barra_superiorLayout.createSequentialGroup()
                .addContainerGap(561, Short.MAX_VALUE)
                .addGroup(pnl_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barra_superiorLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barra_superiorLayout.createSequentialGroup()
                        .addComponent(lbl_titulo_modulo_doc)
                        .addGap(273, 273, 273)
                        .addComponent(lbl_img_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lbl_tipo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        pnl_barra_superiorLayout.setVerticalGroup(
            pnl_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barra_superiorLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnl_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_img_usuario)
                    .addComponent(lbl_tipo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_titulo_modulo_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnl_barra_superior, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1370, 90));

        lbl_fondo_interfaz_mod_docume.setBackground(new java.awt.Color(83, 83, 83));
        lbl_fondo_interfaz_mod_docume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_factura_.jpg"))); // NOI18N
        getContentPane().add(lbl_fondo_interfaz_mod_docume, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 1340, 810));
        getContentPane().add(scrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 600, 10, -1));

        side_pane8.setBackground(new java.awt.Color(251, 243, 0));
        side_pane8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(side_pane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 80, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int xx,xy;
    private void pnl_barra_superiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_barra_superiorMousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnl_barra_superiorMousePressed

    private void pnl_barra_superiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_barra_superiorMouseDragged
        // TODO add your handling code here:
        
        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_pnl_barra_superiorMouseDragged

    private void btn_inicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inicioMousePressed
        // TODO add your handling code here:
        setColor(btn_inicio);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_datper,btn_ingred_,btn_admmes}, new JPanel[]{ind_2,ind_3, ind_4});
        Menu_principal mp = new Menu_principal();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_inicioMousePressed

    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea salir?");
        if (JOptionPane.OK_OPTION == exit)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_exitMousePressed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
        Menu_principal mp = new Menu_principal();
        mp.setVisible(true);
        this.setVisible(false);    
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_proveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_proveMouseReleased
        // TODO add your handling code here:
        Administrar_Proveedor adm_prove = new Administrar_Proveedor();
        adm_prove.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_proveMouseReleased

    private void btn_datperMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_datperMouseReleased
        // TODO add your handling code here:
        setColor(btn_datper);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_inicio,btn_ingred_,btn_admmes}, new JPanel[]{ind_1,ind_3, ind_4});
        Administrar_datos_personal dp = new Administrar_datos_personal();
        dp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_datperMouseReleased

    private void btn_admmesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_admmesMousePressed
        // TODO add your handling code here:
        setColor(btn_admmes);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_datper,btn_ingred_,btn_inicio}, new JPanel[]{ind_2,ind_3, ind_1});
        Administrar_Mesas adm_mesa = new Administrar_Mesas();
        adm_mesa.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_admmesMousePressed

    private void btn_ingred_MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingred_MousePressed
        // TODO add your handling code here:
        setColor(btn_ingred_);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_datper,btn_inicio,btn_admmes}, new JPanel[]{ind_2,ind_1, ind_4});
        interfaz_Ingrediente adm_ingre = new interfaz_Ingrediente();
        adm_ingre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ingred_MousePressed

    private void btn_modulo_documentoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modulo_documentoMouseReleased
        Interfaz_Factura adm_factura = new Interfaz_Factura();
        adm_factura.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_modulo_documentoMouseReleased

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        try
        {
            
      
            getlastid();
            getlastid_n_factura();
            Factura per = new Factura();
            per.setId_documento(Integer.parseInt(text_id_factura.getText().trim()));
            per.setNumero_documento(Integer.parseInt(text_n_documento.getText().trim()));
            
             if(jComboBox_tipo_documento.getSelectedIndex() == 0)
            {
                per.setTipo_documento("Sin definir");
            }else {
                per.setTipo_documento(jComboBox_tipo_documento.getSelectedItem().toString());
            }
            
            per.setNombre_proveedor(text_nombre_proveedor.getText().trim().toUpperCase());
            per.setGiro(text_giro.getText().trim());
            per.setRut_empresa(text_rut_empresa.getText().trim());
            per.setFecha_emision(txt_fecha_emision.getText().trim());
            per.setFecha_vencimiento(txt_fecha_vencimiento.getText().trim());
            
             if(jComboBox_forma_pago.getSelectedIndex() == 0)
            {
                per.setForma_de_pago("Sin definir");
            }else {
                per.setForma_de_pago(jComboBox_forma_pago.getSelectedItem().toString());
            }
             
             
              per.setImpuesto(txt_impuesto.getText().trim().toUpperCase());  
              per.setDescuento(Integer.parseInt(text_descuento.getText().trim()));
              per.setSubTotal(Integer.parseInt(text_subtotal.getText().trim())); 
              per.setTotal_factura(Integer.parseInt(text_total_factura.getText().trim()));
              per.setDescripcion_factura(TextArea_descripcion.getText().trim());
        
            if (Manejadora.agregarFactura(per))
            {
                JOptionPane.showMessageDialog(null, "Se ha creado una receta exitosamente");
                getlastid();
                getlastid_n_factura();
                LimpiarDatos();
                mostrarDatosPanel();
                
               
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo crear el registro, Faltan datos","ERROR",0);
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "no se han ingresado datos", "Informacion", 1);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void jTable_mostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_mostrarMouseClicked
        // TODO add your handling code here:
        try
        {
 
            
            
            
            int x = jTable_mostrar.getSelectedRow();
            String id_documento = (String)jTable_mostrar.getValueAt(x, 0);
            String n_documento = (String)jTable_mostrar.getValueAt(x, 1);
            String tipo_documento = (String)jTable_mostrar.getValueAt(x, 2);
            String nombre_proveedor_ = (String)jTable_mostrar.getValueAt(x, 3);
            String giro = (String)jTable_mostrar.getValueAt(x, 4);
            String rut_empresa = (String)jTable_mostrar.getValueAt(x, 5);
            String fecha_emision = (String)jTable_mostrar.getValueAt(x, 6);
            String fecha_vencimiento = (String)jTable_mostrar.getValueAt(x, 7);
            String forma_pago = (String)jTable_mostrar.getValueAt(x, 8);
            String impuesto = (String)jTable_mostrar.getValueAt(x, 9);
            String descuento = (String)jTable_mostrar.getValueAt(x, 10);
            String subtotal = (String)jTable_mostrar.getValueAt(x, 11);
            String total = (String)jTable_mostrar.getValueAt(x, 12);
            String descripcion = (String)jTable_mostrar.getValueAt(x, 13);
            
            
                 text_id_factura.setText(id_documento);
                 text_n_documento.setText(n_documento);
                 jComboBox_tipo_documento.setSelectedItem(tipo_documento);
                 text_nombre_proveedor.setText(nombre_proveedor_);
                 text_giro.setText(giro);
                text_rut_empresa.setText(rut_empresa);
                txt_fecha_emision.setText(fecha_emision);
                txt_fecha_vencimiento.setText(fecha_vencimiento);
                jComboBox_forma_pago.setSelectedItem(forma_pago); 
                txt_impuesto.setText(impuesto);
                text_descuento.setText(descuento);
                text_subtotal.setText(subtotal);
                text_total_factura.setText(total);
                TextArea_descripcion.setText(descripcion);
                
                txt_id_factura_pdf.setText(id_documento);
                

         

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado ninguna fila");
        }
    }//GEN-LAST:event_jTable_mostrarMouseClicked

    private void text_id_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_id_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_id_facturaActionPerformed

    private void btn_mostrar_most_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrar_most_mesaActionPerformed
        // TODO add your handling code here:
       mostrarDatosPanel();
    }//GEN-LAST:event_btn_mostrar_most_mesaActionPerformed

    private void btn_modificar_mod_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_mod_mesaActionPerformed

         try
        {
            
            Factura per = new Factura();
         
            per.setId_documento(Integer.parseInt(text_id_factura.getText().trim()));
            per.setNumero_documento(Integer.parseInt(text_n_documento.getText().trim()));
            
             if(jComboBox_tipo_documento.getSelectedIndex() == 0)
            {
                per.setTipo_documento("Sin definir");
            }else {
                per.setTipo_documento(jComboBox_tipo_documento.getSelectedItem().toString());
            }
            
            per.setNombre_proveedor(text_nombre_proveedor.getText().trim().toUpperCase());
            per.setGiro(text_giro.getText().trim());
            per.setRut_empresa(text_rut_empresa.getText().trim());
            per.setFecha_emision(txt_fecha_emision.getText().trim());
            per.setFecha_vencimiento(txt_fecha_vencimiento.getText().trim());
            
             if(jComboBox_forma_pago.getSelectedIndex() == 0)
            {
                per.setForma_de_pago("Sin definir");
            }else {
                per.setForma_de_pago(jComboBox_forma_pago.getSelectedItem().toString());
            }
             
             
              per.setImpuesto(txt_impuesto.getText().trim());  
              per.setDescuento(Integer.parseInt(text_descuento.getText().trim()));
              per.setSubTotal(Integer.parseInt(text_subtotal.getText().trim())); 
              per.setTotal_factura(Integer.parseInt(text_total_factura.getText().trim()));
              per.setDescripcion_factura(TextArea_descripcion.getText().trim());
        
            if (Manejadora.modificarDocumento(per))
            {
                JOptionPane.showMessageDialog(null, "Se modificado uan factura exitosamente");
                getlastid();
                getlastid_n_factura();
                LimpiarDatos();
                mostrarDatosPanel();
                
               
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo crear el registro, Faltan datos","ERROR",0);
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "no se han ingresado datos", "Informacion", 1);
        }
    }//GEN-LAST:event_btn_modificar_mod_mesaActionPerformed

    private void txt_id_factura_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_factura_pdfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_factura_pdfActionPerformed

    private void txt_id_factura_pdfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_factura_pdfKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_factura_pdfKeyTyped

    private void btn_buscar_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_nombreActionPerformed
          try
        {
            DefaultTableModel modelo= new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("N°Documento");
            modelo.addColumn("Tipo Documento");
            modelo.addColumn("Proveedor");
            modelo.addColumn("Giro");
            modelo.addColumn("RUT");
            modelo.addColumn("Fecha Emision");
            modelo.addColumn("Fecha Vencimiento");
            modelo.addColumn("Medio Pago");
            modelo.addColumn("Impuesto");
            modelo.addColumn("Descuento");
            modelo.addColumn("SubTotal");
            modelo.addColumn("Total Factura");
            modelo.addColumn("Descripcion Factura");
            this.jTable_mostrar.setModel(modelo);
            try {
                ResultSet rs = Manejadora.buscar_estado_pago((String) this.jCombo_estado_pago.getSelectedItem());
                String [] datos = new String[14];
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    datos[5]=rs.getString(6);
                    datos[6]=rs.getString(7);
                    datos[7]=rs.getString(8);
                    datos[8]=rs.getString(9);
                    datos[9]=rs.getString(10);
                    datos[10]=rs.getString(11);
                    datos[11]=rs.getString(12);
                    datos[12]=rs.getString(13);
                    datos[13]=rs.getString(14);
                    modelo.addRow(datos);
                    this.jTable_mostrar.setModel(modelo);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningun documento con Dicho Filtro");
        }
    }//GEN-LAST:event_btn_buscar_nombreActionPerformed

    private void txt_impuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_impuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_impuestoActionPerformed

    private void btnLimpiar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar_datosActionPerformed
        LimpiarDatos();
    }//GEN-LAST:event_btnLimpiar_datosActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:

        int selec;
        selec = (Integer)this.jTable_mostrar.getSelectedRow();

        if (selec==-1)
        {
            JOptionPane.showMessageDialog(this,"No se ha seleccionado ninguna fila");
        }
        else
        {

            int conf = JOptionPane.showConfirmDialog(this,"Esta seguro de eliminar seleccionado?");
            if (JOptionPane.OK_OPTION == conf) {

                selec = (Integer)this.jTable_mostrar.getSelectedRow();
                String rut;
                rut = this.jTable_mostrar.getValueAt(selec, 0).toString();
                try {
                    Manejadora.eliminarDocumento(conf, rut);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this,"Registro eliminado");
                mostrarDatosPanel();
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_ver_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ver_facturaActionPerformed

         int traer_int = Integer.parseInt(txt_id_factura_pdf.getText());                     
        try {
            
             
             
            Conexion_BD con = new Conexion_BD();
            Connection conn = Conexion_BD.getConexion_BD();
         
            JasperReport reporte = null;
            String path = "src\\Vista\\Factura\\Reporte.jasper";

            Map parametro = new HashMap();
            parametro.put("id_docu", traer_int);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(interfaz_Ingrediente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btn_ver_facturaActionPerformed

    private void btn_recetarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recetarioMouseReleased
        interfaz_Recetario adm_ingre = new interfaz_Recetario();
        adm_ingre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_recetarioMouseReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Interfaz_Factura().setVisible(true);
            }
        });
    }
   
    
    private void setColor(JPanel pane)
    {
        pane.setBackground(new Color(41,57,80));
    }
    
    private void resetColor(JPanel [] pane, JPanel [] indicators)
    {
        for(int i=0;i<pane.length;i++){
           pane[i].setBackground(new Color(23,35,51));
           
        } for(int i=0;i<indicators.length;i++){
           indicators[i].setOpaque(false);           
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextArea_descripcion;
    private javax.swing.JButton btnLimpiar_datos;
    private javax.swing.JPanel btn_admmes;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar_nombre;
    private javax.swing.JPanel btn_datper;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JPanel btn_ingred_;
    private javax.swing.JPanel btn_inicio;
    private javax.swing.JButton btn_modificar_mod_mesa;
    private javax.swing.JPanel btn_modulo_documento;
    private javax.swing.JButton btn_mostrar_most_mesa;
    private javax.swing.JPanel btn_prove;
    private javax.swing.JPanel btn_recetario;
    private javax.swing.JButton btn_ver_factura;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_11;
    private javax.swing.JPanel ind_12;
    private javax.swing.JPanel ind_13;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JComboBox<String> jComboBox_forma_pago;
    private javax.swing.JComboBox<String> jComboBox_tipo_documento;
    private javax.swing.JComboBox<String> jCombo_estado_pago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable_mostrar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_adm_mesa_agre_mesa;
    private javax.swing.JLabel lbl_descuento;
    private javax.swing.JLabel lbl_detalle_factura;
    private javax.swing.JLabel lbl_dtos_perso_agre_mesa;
    private javax.swing.JLabel lbl_fecha_emision;
    private javax.swing.JLabel lbl_fecha_venc;
    private javax.swing.JLabel lbl_filtrar_estado_pago;
    private javax.swing.JLabel lbl_fondo_interfaz_mod_docume;
    private javax.swing.JLabel lbl_forma_pago;
    private javax.swing.JLabel lbl_giro;
    private javax.swing.JLabel lbl_id_documento;
    private javax.swing.JLabel lbl_img_usuario;
    private javax.swing.JLabel lbl_impuesto;
    private javax.swing.JLabel lbl_ingre_agre_mesa;
    private javax.swing.JLabel lbl_ingre_id_fac_pdf;
    private javax.swing.JLabel lbl_inicio_agre_mesa;
    private javax.swing.JLabel lbl_logoazul_restau;
    private javax.swing.JLabel lbl_nombre_prove;
    private javax.swing.JLabel lbl_num_documento;
    private javax.swing.JLabel lbl_proveedores_agre_mesa;
    private javax.swing.JLabel lbl_proveedores_agre_mesa1;
    private javax.swing.JLabel lbl_proveedores_agre_mesa2;
    private javax.swing.JLabel lbl_rut_empresa;
    private javax.swing.JLabel lbl_subtotal;
    private javax.swing.JLabel lbl_tipo_documento;
    private javax.swing.JLabel lbl_tipo_usuario;
    private javax.swing.JLabel lbl_titulo_modulo_doc;
    private javax.swing.JLabel lbl_total_factura;
    private javax.swing.JPanel pnl_barra_amarilla;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa1;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa2;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa3;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa4;
    private javax.swing.JPanel pnl_barra_lateral;
    private javax.swing.JPanel pnl_barra_superior;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JPanel side_pane8;
    private javax.swing.JTextField text_descuento;
    private javax.swing.JTextField text_giro;
    private javax.swing.JTextField text_id_factura;
    private javax.swing.JTextField text_n_documento;
    private javax.swing.JTextField text_nombre_proveedor;
    private javax.swing.JTextField text_rut_empresa;
    private javax.swing.JTextField text_subtotal;
    private javax.swing.JTextField text_total_factura;
    private javax.swing.JScrollPane txt_detalle_factura;
    private javax.swing.JFormattedTextField txt_fecha_emision;
    private javax.swing.JFormattedTextField txt_fecha_vencimiento;
    private javax.swing.JTextField txt_id_factura_pdf;
    private javax.swing.JFormattedTextField txt_impuesto;
    private javax.swing.JScrollPane txt_mostrar;
    // End of variables declaration//GEN-END:variables
}
