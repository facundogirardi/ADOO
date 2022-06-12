package adapters;

public class AdapterSMS implements IAdapterSMS {

    public void envioNotificacion() {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de SMS externo.
        System.out.printf("Envio SMS Externo");
        System.out.println("");

    }
}
