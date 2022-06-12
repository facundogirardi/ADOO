package adapters;

public class AdapterEmail implements IAdapterEmail {

    public void envioNotificacion() {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de Email externo.
        System.out.printf("Envio Email Externo");
        System.out.println("");
    }
}
