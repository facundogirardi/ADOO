package modelo;

import java.util.ArrayList;

import controlador.ControladorUnidadFuncional;
import strategies.IEstrategiaEnvio;
import strategies.AbstractEstrategiaPago;

public class Consorcio {

    private String nombreConsorcio;
    private String idConsorcio;
    private ArrayList<UnidadFuncional> unidadesFuncionales;
    // adaptercuentaBancaria: IAdapterSaldo
    private IEstrategiaEnvio estrategiaEnvio;
    private AbstractEstrategiaPago estrategiaPago;
    private ArrayList<GastoNormal> gastos;
    private Double saldoActual;
    // private Operador operador;

    // Constructor
    public Consorcio(String idConsorcio, String nombreConsorcio, IEstrategiaEnvio estrategiaEnvio) {
        this.idConsorcio = idConsorcio;
        this.nombreConsorcio = nombreConsorcio;
        this.estrategiaEnvio = estrategiaEnvio;
        this.gastos = new ArrayList<GastoNormal>();
        this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
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
        System.out.println("");
    }

    public void generarExpensa(AbstractEstrategiaPago estrategia, String idUsuario) {
        this.cambioEstrategiaPago(estrategia);
        Double total = this.estrategiaPago.calculoDeGastos(gastos);
        this.estrategiaPago.divisionExpensas(total, unidadesFuncionales, idUsuario);
        // this.estrategiaEnvio.envioNotificacion();
    }
 
    public void cambioEstrategiaPago(AbstractEstrategiaPago nuevaEstrategia) {
        System.out.println("Estableciendo estrategia de pago");
        this.estrategiaPago = nuevaEstrategia;
        System.out.println("");
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
        unidadFuncional.pagarExpensa(mes);
    }

}
