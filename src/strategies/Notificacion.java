package strategies;

public class Notificacion {
	private String emailDestinatario;
	private String emailRemitente;
	private String mensaje;
	private String nroCompletoDestinatario;
	private String nroCompletoRemitente;
	
	public String getEmailDestinatario() {
		return emailDestinatario;
	}
	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}
	public void setEmailRemitente(String emailRemitente) {
		this.emailRemitente = emailRemitente;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getNroCompletoDestinatario() {
		return nroCompletoDestinatario;
	}
	public void setNroCompletoDestinatario(String nroCompletoDestinatario) {
		this.nroCompletoDestinatario = nroCompletoDestinatario;
	}
	public String getNroCompletoRemitente() {
		return nroCompletoRemitente;
	}
	public void setNroCompletoRemitente(String nroCompletoRemitente) {
		this.nroCompletoRemitente = nroCompletoRemitente;
	}	
}

