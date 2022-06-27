package adapters;

import strategies.Notificacion;

public interface IAdapterEmail {
    void envioNotificacion(Notificacion notificacion);
}
