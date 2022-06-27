package adapters;

import strategies.Notificacion;

public class AdapterWhatsapp implements IAdapterWhatsapp {

    public void envioNotificacion(Notificacion notificacion) {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de Whatsapp externo.
        System.out.println("Enviando Whatsapp Externo a " + notificacion.getPersona().getApellido());
    }
}
