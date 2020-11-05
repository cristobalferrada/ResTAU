/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author lawlo
 */
public class Personal {
    
    private String rut_personal;
    private String digito_v;
    private String nombre_p;
    private String apellido_p;
    private int numero_p;
    private String correo_p;
    private String tip_personal;
    
    public Personal() 
    {
        
    }

    public String getRut_personal() {
        return rut_personal;
    }

    public void setRut_personal(String rut_personal) {
       this.rut_personal = rut_personal;
    }

    public String getDigito_v() {
        return digito_v;
    }

    public void setDigito_v(String digito_v) {
        this.digito_v = digito_v;
    }
    
    public String getNombre_p() {
        return nombre_p;
    }

    public void setNombre_p(String nombre_p) {
        this.nombre_p = nombre_p;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public int getNumero_p() {
        return numero_p;
    }

    public void setNumero_p(int numero_p) {
        this.numero_p = numero_p;
    }

    public String getCorreo_p() {
        return correo_p;
    }

    public void setCorreo_p(String correo_p) {
        this.correo_p = correo_p;
    }

    public String getTip_personal() {
        return tip_personal;
    }

    public void setTip_personal(String tip_personal) {
        this.tip_personal = tip_personal;
    }

    @Override
    public String toString() {
        return "Personal{" + "rut_personal=" + rut_personal + ", digito_v=" + digito_v + ", nombre_p=" + nombre_p + ", apellido_p=" + apellido_p + ", numero_p=" + numero_p + ", correo_p=" + correo_p + ", tip_personal=" + tip_personal + '}';
    }

}
