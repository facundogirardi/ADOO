package modelo;

import java.util.ArrayList;

import adapters.AdapterEmail;
import adapters.AdapterSMS;
import adapters.AdapterWhatsapp;
import controlador.ControladorUnidadFuncional;
import enums.TipoNotificacion;
import states.FacturaImpaga;
import strategies.IEstrategiaEnvio;
import strategies.Notificacion;
import strategies.Notificador;
import strategies.AbstractEstrategiaPago;
import strategies.EnvioEmail;
import strategies.EnvioSMS;
import strategies.EnvioWhatsapp;

public class Consorcio {

    private String nombreConsorcio;
    private String idConsorcio;
    private ArrayList<UnidadFuncional> unidadesFuncionales;
    private AbstractEstrategiaPago estrategiaPago;
    private ArrayList<GastoNormal> gastos;
    private ArrayList<GastoRecurrente> gastosRecurrentes;
    private ArrayList<Persona> observadores;

    // Constructor
    public Consorcio(String idConsorcio, String nombreConsorcio) {
        this.idConsorcio = idConsorcio;
        this.nombreConsorcio = nombreConsorcio;
        this.gastos = new ArrayList<GastoNormal>();
        this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
        this.gastosRecurrentes = new ArrayList<GastoRecurrente>();
        this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
        observadores = new ArrayList<Persona>();
    }

    public String getNombreConsorcio() {
        return this.nombreConsorcio;
    }

    public String getIdConsorcio() {
        return this.idConsorcio;
    }

    public ArrayList<GastoNormal> getGastos() {
        return this.gastos;
    }

    public void setNombreConsorcio(String nombreConsorcio) {
        this.nombreConsorcio = nombreConsorcio;
    }

    public void setIdConsorcio(String idConsorcio) {
        this.idConsorcio = idConsorcio;
    }

    public void generarExpensa(String idUsuario) {
        Double total = this.estrategiaPago.calculoDeGastos(gastos);
        this.estrategiaPago.divisionExpensas(total, unidadesFuncionales, idUsuario);

        for (int i = 0; i < observadores.size(); i++) {
            Persona persona = (Persona) observadores.get(i);
            Notificador notificador = new Notificador();
            Notificacion notificacion = new Notificacion(persona);

            IEstrategiaEnvio nuevaEstrategia = new EnvioEmail(new AdapterEmail());

            if (persona.geTipoNotificacion() == TipoNotificacion.WHATSAPP) {
                nuevaEstrategia = new EnvioWhatsapp(new AdapterWhatsapp());
            }
            if (persona.geTipoNotificacion() == TipoNotificacion.SMS) {
                nuevaEstrategia = new EnvioSMS(new AdapterSMS());
            }

            notificador.setEstrategia(nuevaEstrategia);
            notificador.enviar(notificacion);
        }
    }

    public void cambioEstrategiaPago(AbstractEstrategiaPago nuevaEstrategia) {
        System.out.println("Estableciendo estrategia de pago");
        this.estrategiaPago = nuevaEstrategia;
    }

    public boolean sosElConsorcio(String idConsorcioBuscado) {
        if (idConsorcio.equalsIgnoreCase(idConsorcioBuscado)) {
            return true;
        } else {
            return false;
        }
    }

    public void pagarExpensa(String idUnidadFuncional, String mes) {
        UnidadFuncional unidadFuncional = ControladorUnidadFuncional.getInstancia().buscarUnidadFuncional(idUnidadFuncional);
        ArrayList<Factura> facturas = unidadFuncional.getExpensas();
        Double TotalDeuda = 0.00;
        for (Factura factura : facturas) {
            if (factura.getEstado() instanceof FacturaImpaga) {
                 TotalDeuda = factura.getTotal() + TotalDeuda;
            }
        }
         System.out.println("Tiene facturas impagas, usted debe : " + TotalDeuda);
         unidadFuncional.pagarExpensa(mes);
    }

    public void añadirGastoNormalConsorcio(GastoNormal gastoNormal) {
        gastos.add(gastoNormal);
    }

    public void añadirGastosNormalesConsorcio(ArrayList<GastoNormal> gastosNormales) {
        gastos.addAll(gastosNormales);
    }

    public void añadirGastoRecurrenteConsorcio(GastoRecurrente gastoRecurrente) {
        gastosRecurrentes.add(gastoRecurrente);
    }

    public void añadirUnidadFuncionalConsorcio(UnidadFuncional unidadFuncional) {
        unidadesFuncionales.add(unidadFuncional);
    }

    public void suscribirObservador(Persona observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Persona observador) {
        observadores.remove(observador);
    }

}
