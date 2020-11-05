
package Clases;

/**
 *
 * 
 */
public class Usuario {
    

    private int id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String email;
    private int fecha_registro;
    private String id_tipo_usuario;
    private String correo;
    private String celular;

    
    
    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(int fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(String id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
            
     public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", email=" + email + ", fecha_registro=" + fecha_registro + ", id_tipo_usuario=" + id_tipo_usuario + ", correo=" + correo + ", celular=" + celular +'}';
    }
    
}
