package strategies;

import strategies.IEstrategiaEnvio;

public class Notificador {
	private IEstrategiaEnvio estrategia;
	
	public void enviar(Notificacion notificacion) {
		this.estrategia.envioNotificacion(notificacion);
	}
	
	public void setEstrategia(IEstrategiaEnvio estrategia) {
		this.estrategia = estrategia;
	}
}
