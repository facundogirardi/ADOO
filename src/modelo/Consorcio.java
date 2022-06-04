package modelo;

public class Consorcio {

    private String nombreConsorcio;
    private String idConsorcio;
    private UnidadFuncional[] unidadesFuncionales;
    // adaptercuentaBancaria: IAdapterSaldo
    // estrategiaEnvio: IObserverEnvio
    // estrategiaPago: AbstractEstrategiaPago
    private Gasto[] gasto;
    private Double saldoActual;
    // private Operador operador;

    // Constructor
    public Consorcio(String idConsorcio, String nombreConsorcio) {
        super();
        this.idConsorcio = idConsorcio;
        this.nombreConsorcio = nombreConsorcio;
    }

    public String getNombreConsorcio() {
        return nombreConsorcio;
    }

    public String getIdConsorcio() {
        return idConsorcio;
    }

    public void setNombreConsorcio(String nombreConsorcio) {
        this.nombreConsorcio = nombreConsorcio;
    }

    public void setIdConsorcio(String idConsorcio) {
        this.idConsorcio = idConsorcio;
    }

    // public static Double obtenerSaldoAtual() {
    // return 3.0;
    // }

    // public static void generarExpensa(UnidadFuncional unidadFuncional,
    // AbstractEstrategiaPago estrategia) {}

    // public static void cambioEstrategiaPago(AbstractEstrategiaPago
    // nuevaEstrategia) {}

    // public static void agregarObservador(UnidadFuncional unidadFuncional) {}

    // public static void eliminarObservador(UnidadFuncional unidadFuncional) {}

    // public static void cambioEstrategiaEnvio(AbstractEstrategiaPago
    // nuevaEstrategia) {}

}
