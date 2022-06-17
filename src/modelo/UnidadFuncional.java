package modelo;

import java.util.ArrayList;

import enums.TipoUnidadFuncional;

public class UnidadFuncional {

    private TipoUnidadFuncional tipoDeUnidad;
    private Double porcentajeDePago;
    private Float metrosCuadrados;
    private Persona propietario;
    private ArrayList<Persona> inquilinos;
    private ArrayList<Factura> expensas;

    public UnidadFuncional(TipoUnidadFuncional tipoDeUnidad, Double porcentajeDePago, Float metrosCuadrados, Persona propietario,
            ArrayList<Persona> inquilinos, ArrayList<Factura> expensas) {
        this.tipoDeUnidad = tipoDeUnidad;
        this.porcentajeDePago = porcentajeDePago;
        this.metrosCuadrados = metrosCuadrados;
     //   this.Persona = propietario;
        this.inquilinos = new ArrayList<Persona>();
        this.expensas = new ArrayList<Factura>();
    }

    public TipoUnidadFuncional getTipoUnidad() {
        return this.tipoDeUnidad;
    }

    public Persona getPropietario() {
        return this.propietario;
    }

    public Float getMetrosCuadrados() {
        return this.metrosCuadrados;
    }
 
    public Double getPorcentajeDePago() {
        return this.porcentajeDePago;
    }

    public Double calcularDeudaAnterior() {
        return null;
    }

    public void agregarExpensa(Factura factura) {
        this.expensas.add(factura);
    }

    public void getInquilinos() {
        System.out.println(this.inquilinos);
    }

    public void getExpensas() {
        System.out.println(this.expensas);
    }
  
}
