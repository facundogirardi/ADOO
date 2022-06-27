package strategies;

import adapters.AdapterEmail;

public class EnvioEmail implements IEstrategiaEnvio {

    private AdapterEmail adapter;

    public void setAdapter(AdapterEmail adapter) {
        this.adapter = adapter;
    }

    public EnvioEmail(AdapterEmail adapter) {
		super();
		this.adapter = adapter;
	}

    public void envioNotificacion(Notificacion notificacion) {
        this.adapter.envioNotificacion(notificacion);
 
    }

}
