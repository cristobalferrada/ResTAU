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
    private int stock;
    private String tipo_producto;

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }
    
    
    @Override
    public String toString() {
        return "Ingrediente{" + "id_ingrediente=" + id_ingrediente + ", nombre_ingrediente=" + nombre_ingrediente + ", stock=" + stock + ", tipo_producto=" + tipo_producto +'}';
    }
    
}
