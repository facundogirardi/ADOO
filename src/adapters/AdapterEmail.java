package adapters;

import strategies.Notificacion;

public class AdapterEmail implements IAdapterEmail {

    public void envioNotificacion(Notificacion notificacion) {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de Email externo.
        System.out.println("Enviando Email Externo a " + notificacion.getPersona().getApellido());
    }
}
