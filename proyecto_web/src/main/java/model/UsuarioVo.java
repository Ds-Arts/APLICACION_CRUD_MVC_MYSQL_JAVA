
package model;

public class UsuarioVo {

    //atributos
    private int IdUsuario;
    private String nombre;
    private String contrasena;
    private int telefono;
    private String direccion;
    private String email;
    private boolean estado;


    //constructor sin parametros
    public UsuarioVo() {

    }

     //constructor con parametros



    public int getIdUsuario() {
        return IdUsuario;
    }

    public UsuarioVo(int idUsuario, String nombre, String contrasena, int telefono, String direccion, String email,
            boolean estado) {
        IdUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }





}
