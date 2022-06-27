package controlador;

import java.util.ArrayList;

import modelo.Consorcio;
import strategies.AbstractEstrategiaPago;
import strategies.IEstrategiaEnvio;

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

    public void crearNuevoConsorcio(String idConsorcio, String nombreConsorcio, IEstrategiaEnvio estrategiaEnvio) {
        Consorcio newConsorcio = buscarConsorcio(idConsorcio);
        if (newConsorcio == null) {
            newConsorcio = new Consorcio(idConsorcio, nombreConsorcio, estrategiaEnvio);
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

    public void generarExpensas(String idConsorcio, String idUsuario, AbstractEstrategiaPago estrategia) {
        Consorcio consorcio = buscarConsorcio(idConsorcio);
        consorcio.generarExpensa(estrategia, idUsuario);
    }

    public void pagarExpensa(String idConsorcio, String idUnidadFuncional, String mes) {
        Consorcio consorcio = buscarConsorcio(idConsorcio);
        consorcio.pagarExpensa(idUnidadFuncional, mes);
    }

}
