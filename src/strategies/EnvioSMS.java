package strategies;

import adapters.AdapterSMS;

public class EnvioSMS implements IEstrategiaEnvio {

    private AdapterSMS adapter;

    public void setAdapter(AdapterSMS adapter) {
        this.adapter = adapter;
    }

    public EnvioSMS(AdapterSMS adapter) {
        super();
        this.adapter = adapter;
    }

    public void envioNotificacion(Notificacion notificacion) {
        this.adapter.envioNotificacion(notificacion);

    }

}
