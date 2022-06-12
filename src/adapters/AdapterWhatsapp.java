package adapters;

public class AdapterWhatsapp implements IAdapterWhatsapp {

    public void envioNotificacion() {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de Whatsapp externo.
        System.out.printf("Envio Whatsapp Externo");
        System.out.println("");
    }
}
