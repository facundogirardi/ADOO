package controlador;

import java.util.ArrayList;

import modelo.Consorcio;
import modelo.GastoNormal;
import modelo.GastoRecurrente;
import modelo.Persona;
import modelo.UnidadFuncional;

public class ControladorConsorcio {

    private ArrayList<Consorcio> consorcios;
    private static ControladorConsorcio instancia;

    public ControladorConsorcio() {
        consorcios = new ArrayList<Consorcio>();
    }

    public static ControladorConsorcio getInstancia() {
        if (instancia == null) {
            instancia = new ControladorConsorcio();
        }
        return instancia;
    }

    public void crearNuevoConsorcio(String idConsorcio, String nombreConsorcio) {
        Consorcio newConsorcio = buscarConsorcio(idConsorcio);
        if (newConsorcio == null) {
            newConsorcio = new Consorcio(idConsorcio, nombreConsorcio);
            consorcios.add(newConsorcio);
        }
    }

    public Consorcio buscarConsorcio(String idConsorcio) {
        for (int i = 0; i < consorcios.size(); i++) {
            Consorcio aux = consorcios.get(i);
            if (aux.sosElConsorcio(idConsorcio))
                return aux;
        }
        return null;
    }

    public Consorcio getConsorcio(String usuario) {
        for (int i = 0; i < consorcios.size(); i++) {
            if (consorcios.get(i).getIdConsorcio().equals(usuario)) {
                return consorcios.get(i);
            }
        }
        return null;
    }

    public void generarExpensas(String idConsorcio, String idUsuario) {
        Consorcio consorcio = buscarConsorcio(idConsorcio);
        consorcio.generarExpensa(idUsuario);
    }

    public void pagarExpensa(String idConsorcio, String idUnidadFuncional, String mes) {
        Consorcio consorcio = buscarConsorcio(idConsorcio);
        consorcio.pagarExpensa(idUnidadFuncional, mes);
    }

    public void aĆ±adirGastoNormalConsorcio(String idConsorcio, GastoNormal gastoNormal) {
        Consorcio consorcio = this.buscarConsorcio(idConsorcio);
        if (consorcio != null && gastoNormal != null) {
            consorcio.aĆ±adirGastoNormalConsorcio(gastoNormal);
        }
    }

    public void aĆ±adirGastoRecurrenteConsorcio(String idConsorcio, GastoRecurrente gastoRecurrente) {
        Consorcio consorcio = this.buscarConsorcio(idConsorcio);
        if (consorcio != null && gastoRecurrente != null) {
            consorcio.aĆ±adirGastoRecurrenteConsorcio(gastoRecurrente);
        }
    }

    public void aĆ±adirUnidadFuncionalConsorcio(String idConsorcio, UnidadFuncional unidadFuncional) {
        Consorcio consorcio = this.buscarConsorcio(idConsorcio);
        if (consorcio != null && unidadFuncional != null) {
            consorcio.aĆ±adirUnidadFuncionalConsorcio(unidadFuncional);
        }
    }

    public void suscribirObservador(String idConsorcio, Persona persona) {
        Consorcio consorcio = this.buscarConsorcio(idConsorcio);
        if (consorcio != null && persona != null) {
            consorcio.suscribirObservador(persona);
        }
    }

    public void eliminarObservador(String idConsorcio, Persona persona) {
        Consorcio consorcio = this.buscarConsorcio(idConsorcio);
        if (consorcio != null && persona != null) {
            consorcio.eliminarObservador(persona);

        }
    }

}
