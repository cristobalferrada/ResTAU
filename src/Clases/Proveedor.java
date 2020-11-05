/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author the_t
 */
public class Proveedor {
    
    
    private int id_proveedor;
    private String nom_proveedor;
    private int telefono_proveedor;
    private String direccion_proveedor;
    private String descripcion_proveedor;
    private String email_proveedor;
    
    public Proveedor()
    {
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }


    public String getNom_proveedor() {
        return nom_proveedor;
    }

    public void setNom_proveedor(String nom_proveedor) {
        this.nom_proveedor = nom_proveedor;
    }

    public int getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(int telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getDescripcion_proveedor() {
        return descripcion_proveedor;
    }

    public void setDescripcion_proveedor(String descripcion_proveedor) {
        this.descripcion_proveedor = descripcion_proveedor;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }

    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nom_proveedor=" + nom_proveedor + ", telefono_proveedor=" + telefono_proveedor + ", direccion_proveedorr=" + direccion_proveedor + ", descripcion_proveedor=" + descripcion_proveedor + ", email_proveedor=" + email_proveedor +'}';
    }
    
  
    
}
