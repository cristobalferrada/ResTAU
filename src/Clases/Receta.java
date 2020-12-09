package Clases;

/**
 *
 * @author the_t
 */
public class Receta {

    private int id_receta;
    private String nombre_plato;
    private String tipo_receta;
    private String descripcion_receta;
    private int precio_receta;

    public Receta() {
    }

    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public String getTipo_receta() {
        return tipo_receta;
    }

    public void setTipo_receta(String tipo_receta) {
        this.tipo_receta = tipo_receta;
    }

    public String getDescripcion_receta() {
        return descripcion_receta;
    }

    public void setDescripcion_receta(String descripcion_receta) {
        this.descripcion_receta = descripcion_receta;
    }

    public int getPrecio_receta() {
        return precio_receta;
    }

    public void setPrecio_receta(int precio_receta) {
        this.precio_receta = precio_receta;
    }
    
     public String toString() {
        return "Receta{" + "id_receta=" + id_receta + ", nombre_plato=" + nombre_plato + ", tipo_receta=" + tipo_receta + ", descripcion_receta=" + descripcion_receta + ", precio_receta=" + precio_receta +'}';
    }
}


