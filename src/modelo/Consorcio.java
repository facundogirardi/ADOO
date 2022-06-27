package modelo;

import java.util.ArrayList;

import controlador.ControladorUnidadFuncional;
import observers.IObserver;
import strategies.IEstrategiaEnvio;
import strategies.Notificacion;
import strategies.AbstractEstrategiaPago;

public class Consorcio {

    private String nombreConsorcio;
    private String idConsorcio;
    private ArrayList<UnidadFuncional> unidadesFuncionales;
    // adaptercuentaBancaria: IAdapterSaldo
    private IEstrategiaEnvio estrategiaEnvio;
    private AbstractEstrategiaPago estrategiaPago;
    private ArrayList<GastoNormal> gastos;
    private ArrayList<GastoRecurrente> gastosRecurrentes;
    private Double saldoActual;
    private ArrayList<IObserver> observadores;

    // Constructor
    public Consorcio(String idConsorcio, String nombreConsorcio) {
        this.idConsorcio = idConsorcio;
        this.nombreConsorcio = nombreConsorcio;
        this.gastos = new ArrayList<GastoNormal>();
        this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
        this.gastosRecurrentes = new ArrayList<GastoRecurrente>();
        this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
        observadores = new ArrayList<IObserver>();
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

    public IEstrategiaEnvio getEstrategiaEnvio() {
        return this.estrategiaEnvio;
    }

    public void cambioEstrategiaEnvio(IEstrategiaEnvio nuevaEstrategia) {
        System.out.println("Cambiando de estrategia de envío");
        this.estrategiaEnvio = nuevaEstrategia;
    }

    public void generarExpensa(AbstractEstrategiaPago estrategia, String idUsuario) {
        this.cambioEstrategiaPago(estrategia);
        Double total = this.estrategiaPago.calculoDeGastos(gastos);
        this.estrategiaPago.divisionExpensas(total, unidadesFuncionales, idUsuario);

        for (int i = 0; i < observadores.size(); i++) {
            Notificacion notificacion = new Notificacion((Persona) observadores.get(i));
            this.estrategiaEnvio.envioNotificacion(notificacion);
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
        UnidadFuncional unidadFuncional = ControladorUnidadFuncional.getInstancia()
                .buscarUnidadFuncional(idUnidadFuncional);
        unidadFuncional.pagarExpensa(mes);
    }

    public void añadirGastoNormalConsorcio(GastoNormal gastoNormal) {
        gastos.add(gastoNormal);
    }

    public void añadirGastoRecurrenteConsorcio(GastoRecurrente gastoRecurrente) {
        gastosRecurrentes.add(gastoRecurrente);
    }

    public void añadirUnidadFuncionalConsorcio(UnidadFuncional unidadFuncional) {
        unidadesFuncionales.add(unidadFuncional);
    }

    public void suscribirObservador(IObserver observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(IObserver observador) {
        observadores.remove(observador);
    }

}
