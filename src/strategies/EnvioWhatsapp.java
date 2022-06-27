package strategies;

import adapters.AdapterWhatsapp;

public class EnvioWhatsapp implements IEstrategiaEnvio {

    private AdapterWhatsapp adapter;

    public void setAdapter(AdapterWhatsapp adapter) {
        this.adapter = adapter;
    }

    public EnvioWhatsapp(AdapterWhatsapp adapter) {
        super();
        this.adapter = adapter;
    }

    public void envioNotificacion(Notificacion notificacion) {
        this.adapter.envioNotificacion(notificacion);

    }

}
