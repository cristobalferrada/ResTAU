package Clases;
import restau.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author the_t
 */
public class Conexion_BD {
    
   public static Connection getConexion_BD() {
        
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String DB="jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "portafolio_tobal";
            String pass = "toballxd";
        
            Connection con = DriverManager.getConnection(DB, user, pass);  
         
            return con;
            
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        }catch (ClassNotFoundException cs) {
            
            System.out.println(cs.getMessage());
            
        }
        
        return null;
    }
    
}