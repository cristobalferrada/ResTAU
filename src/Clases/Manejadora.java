package Clases;
import Clases.Ingrediente;
import Clases.Conexion_BD;
import java.sql.*;

/**
 *
 * @author tobal
 */
public class Manejadora {
     //CRUD INGREDIENTES
     public static boolean agregarIngrediente (Ingrediente p)
    {
        try 
        {
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "insert into INGREDIENTE (id_ingrediente,nombre_ingrediente,tipo_ingrediente,cantidad_ingrediente,unidad_medida) values (?,?,?,?,?)";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_ingrediente());
            insertar.setString(2, p.getNombre_ingrediente());
            insertar.setString(3, p.getTipo_ingrediente());    
            insertar.setInt(4, p.getCantidad_ingrediente());
            insertar.setString(5, p.getUnidad_medida());    
        
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }   
     
    public static void eliminarIngrediente(int fila,String nom_prod) throws ClassNotFoundException {
    
        Connection reg =  Conexion_BD.getConexion_BD();
        try
        {
        
        PreparedStatement pst = reg.prepareStatement("DELETE FROM INGREDIENTE where id_ingrediente=('"+nom_prod+"')");
        pst.executeUpdate();
  
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
     public static ResultSet mostrarIngrediente() throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from INGREDIENTE";
        PreparedStatement mostrar = conexion.prepareStatement(query);
        rs = mostrar.executeQuery(); 
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    } 
    
    public static ResultSet buscarIngrediente (String nombre_ingrediente) throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from INGREDIENTE where nombre_ingrediente like '"+nombre_ingrediente+"%' ";
        PreparedStatement busca = conexion.prepareStatement(query);
        rs = busca.executeQuery(); 
        
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }  
    
    
    public static ResultSet buscarIngrediente_grupo (String tipo_ingrediente) throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from INGREDIENTE where tipo_ingrediente=('"+tipo_ingrediente+"')";
        PreparedStatement busca = conexion.prepareStatement(query);
        rs = busca.executeQuery(); 
        
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }  
    
     public static boolean actualizarIngrediente (Ingrediente p)
    {
        try 
        {
            int v_sub_nomprod = p.getId_ingrediente();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update INGREDIENTE set ID_INGREDIENTE=(?), NOMBRE_INGREDIENTE=?, TIPO_INGREDIENTE=?, CANTIDAD_INGREDIENTE=?, UNIDAD_MEDIDA=? where id_ingrediente =('" +v_sub_nomprod+"')";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_ingrediente());
            insertar.setString(2, p.getNombre_ingrediente());
            insertar.setString(3, p.getTipo_ingrediente());
            insertar.setInt(4, p.getCantidad_ingrediente());
            insertar.setString(5, p.getUnidad_medida());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
     
     
     
     
     //CRUD USUARIO PERSONAL Y USUARIOS NORMALES
     
       public static boolean agregarPersonal (Personal p)
    {
        try 
        {
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "insert into personal (rut_personal,dvrut_personal,nom_personal,apell_personal,correo,celular,tipo_personal) values (?,?,?,?,?,?,?)";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setString(1, p.getRut_personal());
            insertar.setString(2, p.getDigito_v());
            insertar.setString(3, p.getNombre_p());
            insertar.setString(4, p.getApellido_p());
            insertar.setString(5, p.getCorreo_p());
            insertar.setInt(6, p.getNumero_p());
            insertar.setString(7, p.getTip_personal());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
    
    public static ResultSet mostrarPersonal() throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from Personal ORDER BY TIPO_PERSONAL ASC";
        PreparedStatement mostrar = conexion.prepareStatement(query);
        rs = mostrar.executeQuery(); 
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }
    
    public static ResultSet buscarPersonal(String rut) throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from Personal where rut_personal='"+rut+"' ";
        PreparedStatement busca = conexion.prepareStatement(query);
        rs = busca.executeQuery(); 
        
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }   
    
    public static void eliminarPersonal(int fila,String rut) throws ClassNotFoundException {
    
        Connection reg =  Conexion_BD.getConexion_BD();
        try
        {
        
        PreparedStatement pst = reg.prepareStatement("DELETE FROM Personal where rut_personal="+rut+"");
        pst.executeUpdate();
  
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
      }
    
    public static boolean actualizarPersonal (Personal p)
    {
        try 
        {
            String v_sub_rut = p.getRut_personal();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update Personal set rut_personal=?,dvrut_personal=?, nom_personal=?, apell_personal=?, correo=?, celular=?,tipo_personal=? where rut_personal=" +v_sub_rut+" ";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setString(1, p.getRut_personal());
            insertar.setString(2, p.getDigito_v());
            insertar.setString(3, p.getNombre_p());
            insertar.setString(4, p.getApellido_p());
            insertar.setString(5, p.getCorreo_p());
            insertar.setInt(6, p.getNumero_p());
            insertar.setString(7, p.getTip_personal());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
    
    // CURD MESAS
    
    
    
       public static boolean agregarMesa (Mesa p)
    {
        try 
        {
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "insert into MESA (id_mesa,numero_mesa,capacidad_mesa,estilo_mesa,fecha_registro_mesa,en_uso) values (?,?,?,?,?,?)";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setString(1, p.getId_mesa());
            insertar.setInt(2, p.getNumero_mesa());
            insertar.setInt(3, p.getCapacidad_mesa());
            insertar.setString(4, p.getEstilo_mesa());
            insertar.setString(5, p.getFecha_registro());
            insertar.setString(6, p.getEn_uso());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
       
       
       public static ResultSet mostrarMesa() throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from MESA";
        PreparedStatement mostrar = conexion.prepareStatement(query);
        rs = mostrar.executeQuery(); 
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    } 
       
        public static ResultSet buscarMesa(String numero_mesa) throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from MESA where NUMERO_MESA = lower('"+numero_mesa+"')";
        PreparedStatement busca = conexion.prepareStatement(query);
        rs = busca.executeQuery(); 
        
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }  
        
        
        public static void eliminarMesa(int fila,String rut) throws ClassNotFoundException {
    
        Connection reg =  Conexion_BD.getConexion_BD();
        try
        {
        
        PreparedStatement pst = reg.prepareStatement("DELETE FROM MESA where ID_MESA ="+rut+"");
        pst.executeUpdate();
  
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
      }
        
        public static boolean actualizarMesa (Mesa p)
    {
        try 
        {
            String id_mesa = p.getId_mesa();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update MESA set id_mesa=?,NUMERO_MESA=?, CAPACIDAD_MESA=?, ESTILO_MESA=?, FECHA_REGISTRO_MESA=?, EN_USO=? where id_mesa=" +id_mesa+" ";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setString(1, p.getId_mesa());
            insertar.setInt(2, p.getNumero_mesa());
            insertar.setInt(3, p.getCapacidad_mesa());
            insertar.setString(4, p.getEstilo_mesa());
            insertar.setString(5, p.getFecha_registro());
            insertar.setString(6, p.getEn_uso());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
        
        
        //CRUD PROVEEDOR
        
    
         public static boolean agregarProveedor (Proveedor p)
         {
        try 
        {
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "insert into PROVEEDOR (id_proveedor,nombre_proveedor,telefono_proveedor, direccion_proveedor, descripcion_proveedor, email_proveedor,tipo_proveedor) values (?,?,?,?,?,?,?)";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_proveedor());
            insertar.setString(2, p.getNom_proveedor());
            insertar.setInt(3, p.getTelefono_proveedor());
            insertar.setString(4, p.getDireccion_proveedor());
            insertar.setString(5, p.getDescripcion_proveedor());
            insertar.setString(6, p.getEmail_proveedor());
            insertar.setString(7, p.getTipo_proveedor());
            
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
         
         
          public static void eliminarProveedor(int fila,String nom_prod) throws ClassNotFoundException {
    
        Connection reg =  Conexion_BD.getConexion_BD();
        try
        {
        
        PreparedStatement pst = reg.prepareStatement("DELETE FROM PROVEEDOR where id_proveedor=('"+nom_prod+"')");
        pst.executeUpdate();
  
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
          
          
          public static ResultSet mostrarProveedor() throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from PROVEEDOR";
        PreparedStatement mostrar = conexion.prepareStatement(query);
        rs = mostrar.executeQuery(); 
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    } 
          
           public static ResultSet buscarProveedor(String nombre_proveedor) throws ClassNotFoundException    
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from PROVEEDOR where nombre_proveedor like '"+nombre_proveedor+"%'";
        PreparedStatement busca = conexion.prepareStatement(query);
        rs = busca.executeQuery(); 
        
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }  
           
           
             public static boolean actualizarProveedor (Proveedor p)
    {
        try 
        {
            int id_prov = p.getId_proveedor();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update PROVEEDOR set id_proveedor=?,nombre_proveedor=?, telefono_proveedor=?, direccion_proveedor=?, descripcion_proveedor=?, email_proveedor=?, tipo_proveedor=? where id_proveedor=" +id_prov+" ";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_proveedor());
            insertar.setString(2, p.getNom_proveedor());
            insertar.setInt(3, p.getTelefono_proveedor());
            insertar.setString(4, p.getDireccion_proveedor());
            insertar.setString(5, p.getDescripcion_proveedor());
            insertar.setString(6, p.getEmail_proveedor());
            insertar.setString(7, p.getTipo_proveedor());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
             
             
             
             
             //CRUD RECETA
             
         public static boolean agregarReceta (Receta p)
         {
        try 
        {
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "insert into RECETARIO (id_receta,nombre_plato,tipo_receta, descripcion_receta, precio_receta) values (?,?,?,?,?)";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_receta());
            insertar.setString(2, p.getNombre_plato());
            insertar.setString(3, p.getTipo_receta());
            insertar.setString(4, p.getDescripcion_receta());
            insertar.setInt(5, p.getPrecio_receta());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
            public static ResultSet mostrarReceta() throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from RECETARIO";
        PreparedStatement mostrar = conexion.prepareStatement(query);
        rs = mostrar.executeQuery(); 
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    } 
            
         public static ResultSet buscarReceta(String tipo_receta) throws ClassNotFoundException    
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from RECETARIO where tipo_receta = ('"+tipo_receta+"')";
        PreparedStatement busca = conexion.prepareStatement(query);
        rs = busca.executeQuery(); 
        
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }  
         
           public static ResultSet buscar_receta_nombre (String nombre_ingrediente) throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from RECETARIO where NOMBRE_PLATO like '"+nombre_ingrediente+"%' ";
        PreparedStatement busca = conexion.prepareStatement(query);
        rs = busca.executeQuery(); 
        
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }  
         
         
         
            
         
          public static boolean modificarReceta (Receta p)
    {
        try 
        {
            int id_prov = p.getId_receta();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update RECETARIO set id_receta=?,nombre_plato=?, tipo_receta=?, descripcion_receta=?, precio_receta=? where id_receta=" +id_prov+" ";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_receta());
            insertar.setString(2, p.getNombre_plato());
            insertar.setString(3, p.getTipo_receta());
            insertar.setString(4, p.getDescripcion_receta());
            insertar.setInt(5, p.getPrecio_receta());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
          
          
           public static void eliminarReceta(int fila,String nom_prod) throws ClassNotFoundException {
    
        Connection reg =  Conexion_BD.getConexion_BD();
        try
        {
        
        PreparedStatement pst = reg.prepareStatement("DELETE FROM RECETARIO where id_receta=('"+nom_prod+"')");
        pst.executeUpdate();
  
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
           
           
           
           //CRUD FACTURA 
           
           
           public static boolean agregarFactura (Factura p)
         {
        try 
        {
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "insert into DOCUMENTO (id_documento,Numero_documento ,tipo_documento , nombre_proveedor , giro, rut_empresa, fecha_emision , fecha_vencimiento , forma_de_pago ,impuesto , descuento , subtotal , total_factura , Descripcion_Factura   ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_documento());
            insertar.setInt(2, p.getNumero_documento());
            insertar.setString(3, p.getTipo_documento());
            insertar.setString(4, p.getNombre_proveedor());
            insertar.setString(5, p.getGiro());
            insertar.setString(6, p.getRut_empresa());
            insertar.setString(7, p.getFecha_emision());
            insertar.setString(8, p.getFecha_vencimiento());
            insertar.setString(9, p.getForma_de_pago());
            insertar.setString(10, p.getImpuesto());
            insertar.setInt(11, p.getDescuento());
            insertar.setInt(12, p.getSubTotal());
            insertar.setInt(13, p.getTotal_factura());
            insertar.setString(14, p.getDescripcion_factura());
            
            
            
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
    }
           
            public static ResultSet mostrarFactura() throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from DOCUMENTO";
        PreparedStatement mostrar = conexion.prepareStatement(query);
        rs = mostrar.executeQuery(); 
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    } 
            
             
           
          
                      
             public static ResultSet buscar_estado_pago(String estado_de_pago) throws ClassNotFoundException    
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from DOCUMENTO where FORMA_DE_PAGO = ('"+estado_de_pago+"')";
        PreparedStatement busca = conexion.prepareStatement(query);
        rs = busca.executeQuery(); 
        
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }  
             
             
              public static void eliminarDocumento(int fila,String id_documento) throws ClassNotFoundException {
    
        Connection reg =  Conexion_BD.getConexion_BD();
        try
        {
        
        PreparedStatement pst = reg.prepareStatement("DELETE FROM DOCUMENTO where id_documento="+id_documento+"");
        pst.executeUpdate();
  
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
      }

               public static boolean modificarDocumento (Factura p)
    {
        try 
        {
            int id_docu = p.getId_documento();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update DOCUMENTO set id_documento=(?), Numero_documento=?, tipo_documento =?, nombre_proveedor =?, giro =? , rut_empresa=? , fecha_emision=? , fecha_vencimiento=?, forma_de_pago=? , impuesto=? , descuento=? , subtotal=?, total_factura=?, Descripcion_Factura=?  where id_documento =('" +id_docu+"')";
            PreparedStatement insertar = conn.prepareCall(query);
             insertar.setInt(1, p.getId_documento());
            insertar.setInt(2, p.getNumero_documento());
            insertar.setString(3, p.getTipo_documento());
            insertar.setString(4, p.getNombre_proveedor());
            insertar.setString(5, p.getGiro());
            insertar.setString(6, p.getRut_empresa());
            insertar.setString(7, p.getFecha_emision());
            insertar.setString(8, p.getFecha_vencimiento());
            insertar.setString(9, p.getForma_de_pago());
            insertar.setString(10, p.getImpuesto());
            insertar.setInt(11, p.getDescuento());
            insertar.setInt(12, p.getSubTotal());
            insertar.setInt(13, p.getTotal_factura());
            insertar.setString(14, p.getDescripcion_factura());
            insertar.execute();
            insertar.close();
            conn.close();
            
            return true;
        } catch (SQLException e)
        {
            System.out.println("Error de sql" +e.getMessage());
            return false;
        }
             
             
             
             
             
             
            
            
             
            
          
          
          
          
          
          
             
             
          
          
          
          
          
          
          
          
          
          
         
         
          
         
         
         
        
        
    
    
}

               
               
}