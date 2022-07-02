package adapters;

import strategies.Notificacion;

public class AdapterSMS implements IAdapterSMS {

    public void envioNotificacion(Notificacion notificacion) {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de SMS externo.
        System.out.println("Enviando notificacion de SMS Externa a " + notificacion.getPersona().getApellido());

    }
}
