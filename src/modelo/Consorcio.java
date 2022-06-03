package modelo;

public class Consorcio {

    private String nombreConsorcio;
    private UnidadFuncional[] unidadesFuncionales;
    // adaptercuentaBancaria: IAdapterSaldo
    // estrategiaEnvio: IObserverEnvio
    // estrategiaPago: AbstractEstrategiaPago
    private Gasto[] gasto;
    private Double saldoActual;
    // private Operador operador;

    public Consorcio(String nombreConsorcio) {
        this.nombreConsorcio = nombreConsorcio;
    }

    public String getNombreConsorcio() {
        return nombreConsorcio;
    }

    // public static void agregarOperador(Operador operador) {}

    // public static void eliminarOperador(Operador operador) {}
    
    // public static Double obtenerSaldoAtual() {
    //     return 3.0;
    // }

    // public static void generarExpensa(UnidadFuncional unidadFuncional, AbstractEstrategiaPago estrategia) {}

    // public static void cambioEstrategiaPago(AbstractEstrategiaPago nuevaEstrategia) {}

    // public static void agregarObservador(UnidadFuncional unidadFuncional) {}

    // public static void eliminarObservador(UnidadFuncional unidadFuncional) {}

    // public static void cambioEstrategiaEnvio(AbstractEstrategiaPago nuevaEstrategia) {}

}
