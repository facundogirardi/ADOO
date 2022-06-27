package adapters;

import strategies.Notificacion;

public interface IAdapterSMS {
    void envioNotificacion(Notificacion notificacion);
}
