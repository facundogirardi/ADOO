package strategies;

public class EnvioSMS implements IEstrategiaEnvio {

    public void envioNotificacion(Notificacion notificacion) {
        System.out.println("Estrategia de envío de notificación: SMS");
    }

}
