package modelo;
import java.util.ArrayList;

import enums.TipoUnidadFuncional;

public class UnidadFuncional {

    private String tipoDeUnidad;
    private Double porcentajeDePago;
    private Float metrosCuadrados;
    private Persona propietario;
    private ArrayList<Persona> inquilinos;
    private ArrayList<Factura> expensas;

    public UnidadFuncional(Double porcentajeDePago) {
        this.porcentajeDePago = porcentajeDePago;
        this.expensas = new ArrayList<Factura>();
    }

    public Double calcularDeudaAnterior() {
        return null;
    }

    public void agregarExpensa(Factura factura) {
        this.expensas.add(factura);
    }

    public void getExpensas() {
        System.out.println(this.expensas);
    }

    public Double getPorcentajeDePago() {
        return this.porcentajeDePago;
    }

}
