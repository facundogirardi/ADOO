package modelo;

import enums.TipoNotificacion;

public class Persona {

    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private TipoNotificacion tipoNotificacion;

    public Persona(String dni, String nombre, String apellido, String email, String telefono, TipoNotificacion tipoNotificacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.tipoNotificacion = tipoNotificacion;
    }


    public String getDni() {
        return dni;
    };

    public String getNombre() {
        return nombre;
    };

    public String getApellido() {
        return apellido;
    };

    public String getEmail() {
        return email;
    };

    public String getTelefono() {
        return telefono;
    };

    public TipoNotificacion geTipoNotificacion() {
        return tipoNotificacion;
    };

}
