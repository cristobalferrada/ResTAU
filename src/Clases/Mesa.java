package Clases;

/**
 *
 * @author the_t
 */
public class Mesa {
    
    private String id_mesa; 
    private int numero_mesa;
    private int capacidad_mesa;
    private String estilo_mesa;
    private String fecha_registro;
    private String en_uso;

    public Mesa() {
    }

    public String getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(String id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getNumero_mesa() {
        return numero_mesa;
    }

    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

    public int getCapacidad_mesa() {
        return capacidad_mesa;
    }

    public void setCapacidad_mesa(int capacidad_mesa) {
        this.capacidad_mesa = capacidad_mesa;
    }

    public String getEstilo_mesa() {
        return estilo_mesa;
    }

    public void setEstilo_mesa(String estilo_mesa) {
        this.estilo_mesa = estilo_mesa;
    }

    public String getEn_uso() {
        return en_uso;
    }

    public void setEn_uso(String en_uso) {
        this.en_uso = en_uso;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    


 public String toString() {
        return "Mesa{" + "id_mesa=" + id_mesa + ", numero_mesa=" + numero_mesa + ", capacidad_mesa=" + capacidad_mesa + ", estilo_mesa=" + estilo_mesa + ", fecha_registro=" + fecha_registro + ", en_uso=" + en_uso +'}';
    }
    
    
    
    
}
