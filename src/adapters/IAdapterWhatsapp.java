package adapters;

import strategies.Notificacion;

public interface IAdapterWhatsapp {
    void envioNotificacion(Notificacion notificacion);
}
