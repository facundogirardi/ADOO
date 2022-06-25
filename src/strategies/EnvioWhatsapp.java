package strategies;

public class EnvioWhatsapp implements IEstrategiaEnvio {

    public void envioNotificacion(Notificacion notificacion) {
        System.out.println("Estrategia de envío de notificación: Whatsapp");
    }

}
