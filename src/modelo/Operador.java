package modelo;

import adapters.AdapterLogin;
import adapters.IAdapterLogin;

public class Operador {
	private String nombre;
	private String apellido;
	private String telefono;
	private String mail;
	private String usuario;
	private String contraseña;

	// Constructor
	public Operador(String nombre, String apellido, String telefono, String mail, String usuario, String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void seUsuario(String mail) {
		this.mail = mail;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void login(String usuario, String contraseña) {
		IAdapterLogin adapterLogin = new AdapterLogin();
		adapterLogin.login(usuario, contraseña);
	}
}