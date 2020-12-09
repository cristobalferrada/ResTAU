/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Factura {
    
 private int id_documento;
 private int numero_documento;
 private String tipo_documento;
 private String nombre_proveedor;
 private String giro;
 private String rut_empresa;
 private String fecha_emision;
 private String fecha_vencimiento;
 private String forma_de_pago;
 private String impuesto;
 private int descuento;
 private int subTotal;
 private int total_factura;
 private String descripcion_factura;

    public Factura() {
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(String forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(int total_factura) {
        this.total_factura = total_factura;
    }

    public String getDescripcion_factura() {
        return descripcion_factura;
    }

    public void setDescripcion_factura(String descripcion_factura) {
        this.descripcion_factura = descripcion_factura;
    }
 

  public String toString() {
        return "Factura{" + "id_documento=" + id_documento + ", numero_documento=" + numero_documento + ", tipo_documento=" + tipo_documento + ", nombre_proveedor=" + nombre_proveedor + 
                ", giro="  + giro + ", rut_empresa=" + rut_empresa + ", fecha_emision=" + fecha_emision + ", fecha_vencimiento="+ fecha_vencimiento + ", forma_de_pago=" + forma_de_pago +
                ", impuesto=" + impuesto + ", descuento=" + descuento + ", subTotal=" + subTotal + ", total_factura=" + total_factura + ", descripcion_factura="+ descripcion_factura +'}';
    }
 
 
}
