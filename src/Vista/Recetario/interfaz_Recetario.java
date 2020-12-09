/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Recetario;


import Clases.Conexion_BD;
import Vista.Mesas.*;
import Vista.Usuario.*;
import Clases.Manejadora;
import static Clases.Manejadora.eliminarReceta;
import Clases.Mesa;
import Clases.Personal;
import Clases.Receta;
//import Ventanas.*;
import Ventanas_Administracion.Administrar_Mesas;
import Ventanas_Administracion.Administrar_Proveedor;
import Ventanas_Administracion.Administrar_datos_personal;
import Ventanas_Administracion.Menu_principal;
import Vista.Factura.Interfaz_Factura;
import Vista.Ingrediente.interfaz_Ingrediente;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class interfaz_Recetario extends javax.swing.JFrame {

    
             int lastid;      
            Connection con;
            ResultSet rs;
            Statement st;
            PreparedStatement pst;
    
    
    
        
    public interfaz_Recetario() {
        initComponents();
        getlastid();
        this.setLocationRelativeTo(this);
        setColor(btn_inicio_agre_mesa); 
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_datper_agre_mesa,btn_ingred_adm_mesa,btn_admmes_agre_mesa}, new JPanel[]{ind_2,ind_3, ind_4});
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
            String sql = "Select max(ID_RECETA) from RECETARIO";
          Connection con = DriverManager.getConnection(DB, user, pass);  
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next())
            {
                lastid = rs.getInt(1);
                lastid++;
                text_id_receta.setText(Integer.toString(lastid));
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
        modelo.addColumn("Nombre de plato");
        modelo.addColumn("tipo de Plato");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        this.jTable_mostrar.setModel(modelo);

        try {
            ResultSet rs = Manejadora.mostrarReceta();
            String [] datos = new String[5];
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                modelo.addRow(datos);
                this.jTable_mostrar.setModel(modelo);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Receta.class.getName()).log(Level.SEVERE, null, ex);
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
        btn_modificar_mod_mesa = new javax.swing.JButton();
        pnl_barra_amarilla_agre_mesa4 = new javax.swing.JPanel();
        pnl_barra_amarilla_agre_mesa3 = new javax.swing.JPanel();
        pnl_barra_amarilla_agre_mesa2 = new javax.swing.JPanel();
        pnl_barra_amarilla_agre_mesa1 = new javax.swing.JPanel();
        btn_buscar_most_mesa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_descripcion = new javax.swing.JTextArea();
        jCombo_tipo_receta1 = new javax.swing.JComboBox<>();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_mostrar = new javax.swing.JTable();
        lbl_filtrar_nombre = new javax.swing.JLabel();
        text_nombre_ingrediente1 = new javax.swing.JTextField();
        btn_buscar_nombre = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_generar_reporte = new javax.swing.JButton();
        jCombo_tipo_receta = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_mostrar_most_mesa = new javax.swing.JButton();
        text_precio_receta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        text_nombre_plato = new javax.swing.JTextField();
        lbl_logoazul_restau = new javax.swing.JLabel();
        text_id_receta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        pnl_barra_lateral_agre_mesa = new javax.swing.JPanel();
        btn_inicio_agre_mesa = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        lbl_inicio_agre_mesa = new javax.swing.JLabel();
        pnl_barra_amarilla_agre_mesa = new javax.swing.JPanel();
        btn_prove_agre_mesa = new javax.swing.JPanel();
        ind_11 = new javax.swing.JPanel();
        lbl_proveedores_agre_mesa = new javax.swing.JLabel();
        btn_datper_agre_mesa = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        lbl_dtos_perso_agre_mesa = new javax.swing.JLabel();
        btn_admmes_agre_mesa = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        lbl_adm_mesa_agre_mesa = new javax.swing.JLabel();
        btn_ingred_adm_mesa = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        lbl_ingre_agre_mesa = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        btn_recetario = new javax.swing.JPanel();
        ind_12 = new javax.swing.JPanel();
        lbl_recetario = new javax.swing.JLabel();
        btn_modulo_documento = new javax.swing.JPanel();
        ind_13 = new javax.swing.JPanel();
        lbl_documentos = new javax.swing.JLabel();
        pnl_barra_superior_agre_mesa = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl_logorojo_restau = new javax.swing.JLabel();
        lbl_fondo_interfaz_agre_mesa = new javax.swing.JLabel();

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

        btn_modificar_mod_mesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Update.png"))); // NOI18N
        btn_modificar_mod_mesa.setText("Modificar");
        btn_modificar_mod_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_mod_mesaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar_mod_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 720, 130, -1));

        pnl_barra_amarilla_agre_mesa4.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_barra_amarilla_agre_mesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 840, 10));

        pnl_barra_amarilla_agre_mesa3.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_barra_amarilla_agre_mesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 840, 10));

        pnl_barra_amarilla_agre_mesa2.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_barra_amarilla_agre_mesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 160, 10, 230));

        pnl_barra_amarilla_agre_mesa1.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_barra_amarilla_agre_mesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 10, 230));

        btn_buscar_most_mesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_P.png"))); // NOI18N
        btn_buscar_most_mesa.setText("Buscar por tipo ");
        btn_buscar_most_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_most_mesaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar_most_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, 210, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FILTRAR POR TIPO DE RECETA:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 180, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRECIO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 50, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DESCRIPCION:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 80, 20));

        text_descripcion.setColumns(20);
        text_descripcion.setRows(5);
        jScrollPane2.setViewportView(text_descripcion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 610, -1));

        jCombo_tipo_receta1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "PLATO PRINCIPAL", "ENTRADA", "ENSALADA", "POSTRE", "BAJATIVO", " ", " " }));
        getContentPane().add(jCombo_tipo_receta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 190, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 720, 120, -1));

        jTable_mostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_mostrarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_mostrar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 740, 200));

        lbl_filtrar_nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_filtrar_nombre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_filtrar_nombre.setText("FILTRAR POR NOMBRE:");
        getContentPane().add(lbl_filtrar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 200, 20));

        text_nombre_ingrediente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nombre_ingrediente1ActionPerformed(evt);
            }
        });
        text_nombre_ingrediente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_nombre_ingrediente1KeyTyped(evt);
            }
        });
        getContentPane().add(text_nombre_ingrediente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 190, -1));

        btn_buscar_nombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_P.png"))); // NOI18N
        btn_buscar_nombre.setText("Buscar por nombre");
        btn_buscar_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 210, 30));

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        btn_agregar.setText("Guardar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 720, 140, -1));

        btn_generar_reporte.setText("Generar Listado de RECETAS");
        btn_generar_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_reporteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_generar_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, 240, 40));

        jCombo_tipo_receta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "PLATO PRINCIPAL", "ENTRADA", "ENSALADA", "POSTRE", "BAJATIVO", " ", " " }));
        getContentPane().add(jCombo_tipo_receta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 160, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TIPO PLATO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 70, 20));

        btn_mostrar_most_mesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Read.png"))); // NOI18N
        btn_mostrar_most_mesa.setText("Mostrar");
        btn_mostrar_most_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrar_most_mesaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mostrar_most_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 720, 140, -1));

        text_precio_receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_precio_recetaActionPerformed(evt);
            }
        });
        text_precio_receta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_precio_recetaKeyTyped(evt);
            }
        });
        getContentPane().add(text_precio_receta, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE PLATO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 90, 20));

        text_nombre_plato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nombre_platoActionPerformed(evt);
            }
        });
        text_nombre_plato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_nombre_platoKeyTyped(evt);
            }
        });
        getContentPane().add(text_nombre_plato, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 610, -1));

        lbl_logoazul_restau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_superior_blanco.png"))); // NOI18N
        getContentPane().add(lbl_logoazul_restau, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 90));

        text_id_receta.setEditable(false);
        text_id_receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_id_recetaActionPerformed(evt);
            }
        });
        getContentPane().add(text_id_receta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 70, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID RECETA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Volver.png"))); // NOI18N
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 800, 150, 40));

        pnl_barra_lateral_agre_mesa.setBackground(new java.awt.Color(23, 35, 51));
        pnl_barra_lateral_agre_mesa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_inicio_agre_mesa.setBackground(new java.awt.Color(23, 35, 51));
        btn_inicio_agre_mesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_inicio_agre_mesaMousePressed(evt);
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

        javax.swing.GroupLayout btn_inicio_agre_mesaLayout = new javax.swing.GroupLayout(btn_inicio_agre_mesa);
        btn_inicio_agre_mesa.setLayout(btn_inicio_agre_mesaLayout);
        btn_inicio_agre_mesaLayout.setHorizontalGroup(
            btn_inicio_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_inicio_agre_mesaLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lbl_inicio_agre_mesa)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        btn_inicio_agre_mesaLayout.setVerticalGroup(
            btn_inicio_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_inicio_agre_mesaLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_inicio_agre_mesaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_inicio_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral_agre_mesa.add(btn_inicio_agre_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 120, -1));

        pnl_barra_amarilla_agre_mesa.setBackground(new java.awt.Color(251, 243, 0));
        pnl_barra_amarilla_agre_mesa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_barra_lateral_agre_mesa.add(pnl_barra_amarilla_agre_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 10, 780));

        btn_prove_agre_mesa.setBackground(new java.awt.Color(23, 35, 51));
        btn_prove_agre_mesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_prove_agre_mesaMouseReleased(evt);
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

        javax.swing.GroupLayout btn_prove_agre_mesaLayout = new javax.swing.GroupLayout(btn_prove_agre_mesa);
        btn_prove_agre_mesa.setLayout(btn_prove_agre_mesaLayout);
        btn_prove_agre_mesaLayout.setHorizontalGroup(
            btn_prove_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_prove_agre_mesaLayout.createSequentialGroup()
                .addComponent(ind_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_proveedores_agre_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btn_prove_agre_mesaLayout.setVerticalGroup(
            btn_prove_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_prove_agre_mesaLayout.createSequentialGroup()
                .addComponent(ind_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_prove_agre_mesaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_proveedores_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral_agre_mesa.add(btn_prove_agre_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 140, -1));

        btn_datper_agre_mesa.setBackground(new java.awt.Color(23, 35, 51));
        btn_datper_agre_mesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_datper_agre_mesaMouseReleased(evt);
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

        javax.swing.GroupLayout btn_datper_agre_mesaLayout = new javax.swing.GroupLayout(btn_datper_agre_mesa);
        btn_datper_agre_mesa.setLayout(btn_datper_agre_mesaLayout);
        btn_datper_agre_mesaLayout.setHorizontalGroup(
            btn_datper_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_datper_agre_mesaLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_dtos_perso_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        btn_datper_agre_mesaLayout.setVerticalGroup(
            btn_datper_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_datper_agre_mesaLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_datper_agre_mesaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_dtos_perso_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral_agre_mesa.add(btn_datper_agre_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 140, -1));

        btn_admmes_agre_mesa.setBackground(new java.awt.Color(23, 35, 51));
        btn_admmes_agre_mesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_admmes_agre_mesaMousePressed(evt);
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

        javax.swing.GroupLayout btn_admmes_agre_mesaLayout = new javax.swing.GroupLayout(btn_admmes_agre_mesa);
        btn_admmes_agre_mesa.setLayout(btn_admmes_agre_mesaLayout);
        btn_admmes_agre_mesaLayout.setHorizontalGroup(
            btn_admmes_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_admmes_agre_mesaLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_adm_mesa_agre_mesa)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        btn_admmes_agre_mesaLayout.setVerticalGroup(
            btn_admmes_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_admmes_agre_mesaLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_admmes_agre_mesaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_adm_mesa_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral_agre_mesa.add(btn_admmes_agre_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 140, -1));

        btn_ingred_adm_mesa.setBackground(new java.awt.Color(23, 35, 51));
        btn_ingred_adm_mesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ingred_adm_mesaMousePressed(evt);
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

        lbl_ingre_agre_mesa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_ingre_agre_mesa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ingre_agre_mesa.setText("Ingredientes");

        javax.swing.GroupLayout btn_ingred_adm_mesaLayout = new javax.swing.GroupLayout(btn_ingred_adm_mesa);
        btn_ingred_adm_mesa.setLayout(btn_ingred_adm_mesaLayout);
        btn_ingred_adm_mesaLayout.setHorizontalGroup(
            btn_ingred_adm_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingred_adm_mesaLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_ingre_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        btn_ingred_adm_mesaLayout.setVerticalGroup(
            btn_ingred_adm_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingred_adm_mesaLayout.createSequentialGroup()
                .addGroup(btn_ingred_adm_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ingre_agre_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_barra_lateral_agre_mesa.add(btn_ingred_adm_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 140, 40));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Exit_25px.png"))); // NOI18N
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });
        pnl_barra_lateral_agre_mesa.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 790, 30, 46));

        btn_recetario.setBackground(new java.awt.Color(251, 243, 0));
        btn_recetario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_recetarioMouseReleased(evt);
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

        lbl_recetario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_recetario.setText("Recetario");

        javax.swing.GroupLayout btn_recetarioLayout = new javax.swing.GroupLayout(btn_recetario);
        btn_recetario.setLayout(btn_recetarioLayout);
        btn_recetarioLayout.setHorizontalGroup(
            btn_recetarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_recetarioLayout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_recetario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btn_recetarioLayout.setVerticalGroup(
            btn_recetarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_recetarioLayout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_recetarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_recetario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral_agre_mesa.add(btn_recetario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 140, -1));

        btn_modulo_documento.setBackground(new java.awt.Color(23, 35, 51));
        btn_modulo_documento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_modulo_documentoMouseReleased(evt);
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

        lbl_documentos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_documentos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_documentos.setText("Documentos");

        javax.swing.GroupLayout btn_modulo_documentoLayout = new javax.swing.GroupLayout(btn_modulo_documento);
        btn_modulo_documento.setLayout(btn_modulo_documentoLayout);
        btn_modulo_documentoLayout.setHorizontalGroup(
            btn_modulo_documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_modulo_documentoLayout.createSequentialGroup()
                .addComponent(ind_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_documentos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btn_modulo_documentoLayout.setVerticalGroup(
            btn_modulo_documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_modulo_documentoLayout.createSequentialGroup()
                .addComponent(ind_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_modulo_documentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_documentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_barra_lateral_agre_mesa.add(btn_modulo_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 140, -1));

        getContentPane().add(pnl_barra_lateral_agre_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 860));

        pnl_barra_superior_agre_mesa.setBackground(new java.awt.Color(23, 35, 51));
        pnl_barra_superior_agre_mesa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnl_barra_superior_agre_mesaMouseDragged(evt);
            }
        });
        pnl_barra_superior_agre_mesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_barra_superior_agre_mesaMousePressed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(123, 156, 225));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setPreferredSize(new java.awt.Dimension(2, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Usuario: Administrador");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_User_48px.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Modulo de recetas");

        javax.swing.GroupLayout pnl_barra_superior_agre_mesaLayout = new javax.swing.GroupLayout(pnl_barra_superior_agre_mesa);
        pnl_barra_superior_agre_mesa.setLayout(pnl_barra_superior_agre_mesaLayout);
        pnl_barra_superior_agre_mesaLayout.setHorizontalGroup(
            pnl_barra_superior_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barra_superior_agre_mesaLayout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addGroup(pnl_barra_superior_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barra_superior_agre_mesaLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barra_superior_agre_mesaLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(238, 238, 238)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        pnl_barra_superior_agre_mesaLayout.setVerticalGroup(
            pnl_barra_superior_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barra_superior_agre_mesaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnl_barra_superior_agre_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnl_barra_superior_agre_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1100, 90));

        lbl_logorojo_restau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_final.png"))); // NOI18N
        getContentPane().add(lbl_logorojo_restau, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 490, 260, 310));

        lbl_fondo_interfaz_agre_mesa.setBackground(new java.awt.Color(83, 83, 83));
        lbl_fondo_interfaz_agre_mesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_recetario.jpg"))); // NOI18N
        getContentPane().add(lbl_fondo_interfaz_agre_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 1070, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int xx,xy;
    private void pnl_barra_superior_agre_mesaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_barra_superior_agre_mesaMousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnl_barra_superior_agre_mesaMousePressed

    private void pnl_barra_superior_agre_mesaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_barra_superior_agre_mesaMouseDragged
        // TODO add your handling code here:
        
        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_pnl_barra_superior_agre_mesaMouseDragged

    private void btn_inicio_agre_mesaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inicio_agre_mesaMousePressed
        // TODO add your handling code here:
        setColor(btn_inicio_agre_mesa);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_datper_agre_mesa,btn_ingred_adm_mesa,btn_admmes_agre_mesa}, new JPanel[]{ind_2,ind_3, ind_4});
        Menu_principal mp = new Menu_principal();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_inicio_agre_mesaMousePressed

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

    private void btn_prove_agre_mesaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prove_agre_mesaMouseReleased
        // TODO add your handling code here:
        Administrar_Proveedor adm_prove = new Administrar_Proveedor();
        adm_prove.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_prove_agre_mesaMouseReleased

    private void btn_datper_agre_mesaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_datper_agre_mesaMouseReleased
        // TODO add your handling code here:
        setColor(btn_datper_agre_mesa);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_inicio_agre_mesa,btn_ingred_adm_mesa,btn_admmes_agre_mesa}, new JPanel[]{ind_1,ind_3, ind_4});
        Administrar_datos_personal dp = new Administrar_datos_personal();
        dp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_datper_agre_mesaMouseReleased

    private void btn_admmes_agre_mesaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_admmes_agre_mesaMousePressed
        // TODO add your handling code here:
        setColor(btn_admmes_agre_mesa);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_datper_agre_mesa,btn_ingred_adm_mesa,btn_inicio_agre_mesa}, new JPanel[]{ind_2,ind_3, ind_1});
        Administrar_Mesas adm_mesa = new Administrar_Mesas();
        adm_mesa.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_admmes_agre_mesaMousePressed

    private void btn_ingred_adm_mesaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingred_adm_mesaMousePressed
        // TODO add your handling code here:
        setColor(btn_ingred_adm_mesa);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_datper_agre_mesa,btn_inicio_agre_mesa,btn_admmes_agre_mesa}, new JPanel[]{ind_2,ind_1, ind_4});
        interfaz_Ingrediente adm_ingre = new interfaz_Ingrediente();
        adm_ingre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ingred_adm_mesaMousePressed

    private void btn_recetarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recetarioMouseReleased
        interfaz_Recetario adm_ingre = new interfaz_Recetario();
        adm_ingre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_recetarioMouseReleased

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        try
        {
            getlastid();
            Receta per = new Receta();
            per.setId_receta(Integer.parseInt(text_id_receta.getText().trim()));
            per.setNombre_plato(text_nombre_plato.getText().trim());
           
            if(jCombo_tipo_receta.getSelectedIndex() == 0)
            {
                per.setTipo_receta("Sin definir");
            }else {
                per.setTipo_receta(jCombo_tipo_receta.getSelectedItem().toString());
            }
            
            
            per.setPrecio_receta(Integer.parseInt(text_precio_receta.getText().trim()));
            per.setDescripcion_receta(text_descripcion.getText().trim());
           
            if (Manejadora.agregarReceta(per))
            {
                JOptionPane.showMessageDialog(null, "Se ha creado una receta exitosamente");
                getlastid();
                this.text_precio_receta.setText(null);
                this.text_nombre_plato.setText(null);
                this.jCombo_tipo_receta.setSelectedIndex(0);
                this.text_descripcion.setText(null);
                mostrarDatosPanel();
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo crear el registro","ERROR",0);
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "no se han ingresado datos", "Informacion", 1);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void text_nombre_platoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nombre_platoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_text_nombre_platoActionPerformed

    private void jTable_mostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_mostrarMouseClicked
        // TODO add your handling code here:
        try
        {
            int x = jTable_mostrar.getSelectedRow();
            String id_receta = (String)jTable_mostrar.getValueAt(x, 0);
            String nombre_plato = (String)jTable_mostrar.getValueAt(x, 1);
            String tipo = (String)jTable_mostrar.getValueAt(x, 2);
            String precio = (String)jTable_mostrar.getValueAt(x, 4);
            String descripcion = (String)jTable_mostrar.getValueAt(x, 3);
      

            text_id_receta.setText(id_receta);
            text_nombre_plato.setText(nombre_plato);
            jCombo_tipo_receta.setSelectedItem(tipo);
            text_precio_receta.setText(precio);
            text_descripcion.setText(descripcion);
         

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado ninguna fila");
        }
    }//GEN-LAST:event_jTable_mostrarMouseClicked

    private void text_id_recetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_id_recetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_id_recetaActionPerformed

    private void btn_mostrar_most_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrar_most_mesaActionPerformed
        // TODO add your handling code here:
       mostrarDatosPanel();
    }//GEN-LAST:event_btn_mostrar_most_mesaActionPerformed

    private void btn_buscar_most_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_most_mesaActionPerformed
        // TODO add your handling code here:
        try
        {
            DefaultTableModel modelo= new DefaultTableModel();
             modelo.addColumn("ID");
            modelo.addColumn("Nombre de plato");
            modelo.addColumn("tipo de Plato");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Precio");
            this.jTable_mostrar.setModel(modelo);
            try {
                ResultSet rs = Manejadora.buscarReceta((String) jCombo_tipo_receta1.getSelectedItem());
                String [] datos = new String[5];
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    modelo.addRow(datos);
                    this.jTable_mostrar.setModel(modelo);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "no se ha encontrado ninguna mesa");
        }
    }//GEN-LAST:event_btn_buscar_most_mesaActionPerformed

    private void btn_modificar_mod_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_mod_mesaActionPerformed

        try
        {
            Receta per = new Receta();
            per.setId_receta(Integer.parseInt(text_id_receta.getText().trim()));
            per.setNombre_plato(text_nombre_plato.getText().trim());
       

            if(jCombo_tipo_receta.getSelectedIndex() == 0)
            {
                per.setTipo_receta("Sin definir");
            }else {
                per.setTipo_receta(jCombo_tipo_receta.getSelectedItem().toString());
            }
            
            per.setDescripcion_receta(text_descripcion.getText().trim());
            per.setPrecio_receta(Integer.parseInt(text_precio_receta.getText().trim()));

            if (Manejadora.modificarReceta(per))
            {
                JOptionPane.showMessageDialog(null, "Se Modifico Exitosamente");
                // txtrut.setText("");
                text_nombre_plato.setText("");
                text_descripcion.setText("");
                text_precio_receta.setText("");
                jCombo_tipo_receta.setSelectedIndex(0);
                getlastid();
                mostrarDatosPanel();

            } else {
                JOptionPane.showMessageDialog(null, "no se pudo modificar el registro");
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ingrese Todos los Campos restantes.");
        }
    }//GEN-LAST:event_btn_modificar_mod_mesaActionPerformed

    private void text_precio_recetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_precio_recetaActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_text_precio_recetaActionPerformed

    private void text_precio_recetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_precio_recetaKeyTyped
       
        char n = evt.getKeyChar();
        if( n<'0' || n>'9' )evt.consume();
    }//GEN-LAST:event_text_precio_recetaKeyTyped

    private void text_nombre_platoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_nombre_platoKeyTyped

         char n = evt.getKeyChar();
        if((n<'a' || n>'z') && (n<'A' || n>'Z') && (n<' ' || n>' '))evt.consume();
    }//GEN-LAST:event_text_nombre_platoKeyTyped

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
                    Manejadora.eliminarReceta(conf, rut);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(interfaz_Recetario.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this,"Registro eliminado");
                mostrarDatosPanel();
             
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modulo_documentoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modulo_documentoMouseReleased
        Interfaz_Factura adm_ingre = new Interfaz_Factura();
        adm_ingre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_modulo_documentoMouseReleased

    private void btn_generar_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_reporteActionPerformed
        try {

            Conexion_BD con = new Conexion_BD();
            Connection conn = Conexion_BD.getConexion_BD();

            JasperReport reporte = null;
            String path = "src\\Vista\\Recetario\\Reporte_recetas.jasper";

            Map parametro = new HashMap();
            parametro.put("id_estado", 36);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(interfaz_Ingrediente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_generar_reporteActionPerformed

    private void text_nombre_ingrediente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nombre_ingrediente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nombre_ingrediente1ActionPerformed

    private void text_nombre_ingrediente1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_nombre_ingrediente1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nombre_ingrediente1KeyTyped

    private void btn_buscar_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_nombreActionPerformed
        try
        {
            DefaultTableModel modelo= new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre de plato");
            modelo.addColumn("tipo de Plato");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Precio");
            this.jTable_mostrar.setModel(modelo);
            try {
                ResultSet rs = Manejadora.buscar_receta_nombre(this.text_nombre_ingrediente1.getText().toUpperCase());
                String [] datos = new String[5];
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    modelo.addRow(datos);
                    this.jTable_mostrar.setModel(modelo);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Receta.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningun Ingrediente");
        }
    }//GEN-LAST:event_btn_buscar_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(interfaz_Recetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz_Recetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz_Recetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz_Recetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz_Recetario().setVisible(true);
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
    private javax.swing.JPanel btn_admmes_agre_mesa;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar_most_mesa;
    private javax.swing.JButton btn_buscar_nombre;
    private javax.swing.JPanel btn_datper_agre_mesa;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JButton btn_generar_reporte;
    private javax.swing.JPanel btn_ingred_adm_mesa;
    private javax.swing.JPanel btn_inicio_agre_mesa;
    private javax.swing.JButton btn_modificar_mod_mesa;
    private javax.swing.JPanel btn_modulo_documento;
    private javax.swing.JButton btn_mostrar_most_mesa;
    private javax.swing.JPanel btn_prove_agre_mesa;
    private javax.swing.JPanel btn_recetario;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_11;
    private javax.swing.JPanel ind_12;
    private javax.swing.JPanel ind_13;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JComboBox<String> jCombo_tipo_receta;
    private javax.swing.JComboBox<String> jCombo_tipo_receta1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_mostrar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_adm_mesa_agre_mesa;
    private javax.swing.JLabel lbl_documentos;
    private javax.swing.JLabel lbl_dtos_perso_agre_mesa;
    private javax.swing.JLabel lbl_filtrar_nombre;
    private javax.swing.JLabel lbl_fondo_interfaz_agre_mesa;
    private javax.swing.JLabel lbl_ingre_agre_mesa;
    private javax.swing.JLabel lbl_inicio_agre_mesa;
    private javax.swing.JLabel lbl_logoazul_restau;
    private javax.swing.JLabel lbl_logorojo_restau;
    private javax.swing.JLabel lbl_proveedores_agre_mesa;
    private javax.swing.JLabel lbl_recetario;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa1;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa2;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa3;
    private javax.swing.JPanel pnl_barra_amarilla_agre_mesa4;
    private javax.swing.JPanel pnl_barra_lateral_agre_mesa;
    private javax.swing.JPanel pnl_barra_superior_agre_mesa;
    private javax.swing.JTextArea text_descripcion;
    private javax.swing.JTextField text_id_receta;
    private javax.swing.JTextField text_nombre_ingrediente1;
    private javax.swing.JTextField text_nombre_plato;
    private javax.swing.JTextField text_precio_receta;
    // End of variables declaration//GEN-END:variables
}
