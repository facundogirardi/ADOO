package modelo;
import java.util.ArrayList;

import enums.TipoUnidadFuncional;

public class UnidadFuncional {

    private String tipoDeUnidad;
    private Float porcentajeDePago;
    private Float metrosCuadrados;
    private Persona propietario;
    private ArrayList<Persona> inquilinos;
    private ArrayList<Factura> expensas;

    public Double calcularDeudaAnterior() {
        return null;
    }

}
