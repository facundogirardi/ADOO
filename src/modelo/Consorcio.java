package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import adapters.AdapterSaldoCuenta;
import adapters.IAdapterSaldo;
import enums.TipoExpensa;
import strategies.IEstrategiaEnvio;
import strategies.AbstractEstrategiaPago;

public class Consorcio {

    private String nombreConsorcio;
    private String idConsorcio;
    private ArrayList<UnidadFuncional> unidadesFuncionales;
    // adaptercuentaBancaria: IAdapterSaldo
    private IEstrategiaEnvio estrategiaEnvio;
    private AbstractEstrategiaPago estrategiaPago;
    private ArrayList<Gasto> gastos;
    private Double saldoActual;
    // private Operador operador;

    // Constructor
    public Consorcio(String idConsorcio, String nombreConsorcio, IEstrategiaEnvio estrategiaEnvio) {
        this.idConsorcio = idConsorcio;
        this.nombreConsorcio = nombreConsorcio;
        this.estrategiaEnvio = estrategiaEnvio;
        this.gastos = new ArrayList<Gasto>();
        this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
    }

    public String getNombreConsorcio() {
        return this.nombreConsorcio;
    }

    public String getIdConsorcio() {
        return this.idConsorcio;
    }

    public ArrayList<Gasto> getGastos() {
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

    public void generarGastoRecurrente(Float monto, TipoExpensa tipoExpensa, Integer mes, String descripcion, LocalDate recurrenciaDesde, LocalDate recurrenciaHasta) {
        Gasto nuevoGastoRecurrente = new GastoRecurrente(monto, tipoExpensa, mes, descripcion, recurrenciaDesde, recurrenciaHasta);
        this.gastos.add(nuevoGastoRecurrente);
    }

    public void generarGasto(Float monto, TipoExpensa tipoExpensa, Integer mes, String descripcion) {
        Gasto nuevoGastoNormal = new Gasto(monto, tipoExpensa, mes, descripcion);
        this.gastos.add(nuevoGastoNormal);
    }

    public void generarExpensas() {
        Double total = this.estrategiaPago.calculoDeGastos(gastos);
        this.estrategiaPago.divisionExpensas(total, unidadesFuncionales);
        this.estrategiaEnvio.envioNotificacion();
    }

    public void cambioEstrategiaPago(AbstractEstrategiaPago nuevaEstrategia) {
        System.out.println("Cambiando de estrategia de pago");
        this.estrategiaPago = nuevaEstrategia;
        System.out.println("");
    }

}
