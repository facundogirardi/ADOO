package adapters;

import strategies.Notificacion;

public class AdapterSMS implements IAdapterSMS {

    public void envioNotificacion(Notificacion notificacion) {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de SMS externo.
        System.out.println("Enviando SMS Externo a " + notificacion.getPersona().getApellido());

    }
}
