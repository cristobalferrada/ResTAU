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
public class Ingrediente {
    
    
    
    private int id_ingrediente;
    private String nombre_ingrediente;
    private String tipo_ingrediente;
    private int cantidad_ingrediente;
    private String unidad_medida;

    public Ingrediente()
           {
                
            }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public String getTipo_ingrediente() {
        return tipo_ingrediente;
    }

    public void setTipo_ingrediente(String tipo_ingrediente) {
        this.tipo_ingrediente = tipo_ingrediente;
    }

    public int getCantidad_ingrediente() {
        return cantidad_ingrediente;
    }

    public void setCantidad_ingrediente(int cantidad_ingrediente) {
        this.cantidad_ingrediente = cantidad_ingrediente;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }
    
    
    @Override
    public String toString() {
        return "Ingrediente{" + "id_ingrediente=" + id_ingrediente + ", nombre_ingrediente=" + nombre_ingrediente + ", tipo_ingrediente=" + tipo_ingrediente + ", cantidad_ingrediente=" + cantidad_ingrediente + ", unidad_medida="  + unidad_medida +'}';
    }
    
}
