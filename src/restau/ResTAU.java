/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restau;
import Vista.Login.Login_PRINCIPAL;
/**
 *
 * @author the_t
 */
public class ResTAU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Vista.Login.Login_PRINCIPAL login = new Login_PRINCIPAL();
        login.setVisible(true);
        login.setTitle("Restaurant siglo 21");
        login.setLocationRelativeTo(login);
        
    }
    
}
