package strategies;

public class EnvioEmail implements IEstrategiaEnvio {

    public void envioNotificacion(Notificacion notificacion) {
        System.out.println("Estrategia de envío de notificación: Email");
    }

}
