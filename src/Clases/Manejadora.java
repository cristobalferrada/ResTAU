/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            
            String query = "insert into INGREDIENTE (id_ingrediente,nombre_ingrediente,stock) values (?,?,?)";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_ingrediente());
            insertar.setString(2, p.getNombre_ingrediente());
            insertar.setInt(3, p.getStock());        
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
        
        PreparedStatement pst = reg.prepareStatement("DELETE FROM INGREDIENTE where nombre_ingrediente=('"+nom_prod+"')");
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
        String query = "select * from INGREDIENTE where nombre_ingrediente=('"+nombre_ingrediente+"')";
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
            String v_sub_nomprod = p.getNombre_ingrediente();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update INGREDIENTE set ID_INGREDIENTE=(?), NOMBRE_INGREDIENTE=?, STOCK=? where NOMBRE_INGREDIENTE =('" +v_sub_nomprod+"')";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_ingrediente());
            insertar.setString(2, p.getNombre_ingrediente());
            insertar.setInt(3, p.getStock());
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
        String query = "select * from Personal";
        PreparedStatement mostrar = conexion.prepareStatement(query);
        rs = mostrar.executeQuery(); 
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        } 
        return(rs);
    }
    
    public static ResultSet buscarPersonal(String rut, String dvrut) throws ClassNotFoundException
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from Personal where rut_personal='"+rut+"' and dvrut_personal='" + dvrut +"'";
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
            insertar.setInt(1, p.getId_mesa());
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
            int v_sub_rut = p.getId_mesa();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update MESA set id_mesa=?,NUMERO_MESA=?, CAPACIDAD_MESA=?, ESTILO_MESA=?, FECHA_REGISTRO=?, EN_USO=? where id_mesa=" +v_sub_rut+" ";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_mesa());
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
            
            String query = "insert into PROVEEDOR (id_proveedor,nombre_proveedor,telefono_proveedor, direccion_proveedor, descripcion_proveedor, email_proveedor) values (?,?,?,?,?,?)";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_proveedor());
            insertar.setString(2, p.getNom_proveedor());
            insertar.setInt(3, p.getTelefono_proveedor());
            insertar.setString(4, p.getDireccion_proveedor());
            insertar.setString(5, p.getDescripcion_proveedor());
            insertar.setString(6, p.getEmail_proveedor());
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
          
           public static ResultSet buscarProveedor(String numero_mesa) throws ClassNotFoundException    
    {
        ResultSet rs=null;
        try{
        Connection conexion = Conexion_BD.getConexion_BD();
        String query = "select * from MESA where nombre_proveedor = ('"+numero_mesa+"')";
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
            int v_sub_rut = p.getId_proveedor();
            Connection conn = Conexion_BD.getConexion_BD();
            
            String query = "update PROVEEDOR set id_proveedor=?,nombre_proveedor=?, telefono_proveedor=?, direccion_proveedor=?, descripcion_proveedor=?, email_proveedor=? where id_proveedor=" +v_sub_rut+" ";
            PreparedStatement insertar = conn.prepareCall(query);
            insertar.setInt(1, p.getId_proveedor());
            insertar.setString(2, p.getNom_proveedor());
            insertar.setInt(3, p.getTelefono_proveedor());
            insertar.setString(4, p.getDireccion_proveedor());
            insertar.setString(5, p.getDescripcion_proveedor());
            insertar.setString(6, p.getEmail_proveedor());
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
