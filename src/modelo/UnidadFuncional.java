package modelo;

import java.util.ArrayList;

import enums.TipoUnidadFuncional;
import states.FacturaPaga;

public class UnidadFuncional {

    private TipoUnidadFuncional tipoDeUnidad;
    private Double porcentajeDePago;
    private Double metrosCuadrados;
    private String codigo;
    private ArrayList<Persona> propietarios;
    private ArrayList<Persona> inquilinos;
    private ArrayList<Factura> expensas;

    public UnidadFuncional(TipoUnidadFuncional tipoDeUnidad, Double porcentajeDePago, String codigo,
            Double metrosCuadrados, ArrayList<Persona> propietarios,
            ArrayList<Persona> inquilinos, ArrayList<Factura> expensas) {
        this.tipoDeUnidad = tipoDeUnidad;
        this.porcentajeDePago = porcentajeDePago;
        this.metrosCuadrados = metrosCuadrados;
        this.codigo = codigo;
        this.propietarios = new ArrayList<Persona>();
        this.inquilinos = new ArrayList<Persona>();
        this.expensas = new ArrayList<Factura>();
    }

    public TipoUnidadFuncional getTipoUnidad() {
        return this.tipoDeUnidad;
    }

    public Double getMetrosCuadrados() {
        return this.metrosCuadrados;
    }

    public Double getPorcentajeDePago() {
        return this.porcentajeDePago;
    }

    public String getCodigo() {
        return this.codigo;
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

    public ArrayList<Persona> getPropietarios() {
        return propietarios;
    }

    public void getExpensas() {
        System.out.println(this.expensas);
    }

    public boolean sosLaUnidadFuncional(String codigoBuscado) {
        if (codigo.equalsIgnoreCase(codigoBuscado)) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarDueño(Persona persona) {
        propietarios.add(persona);
    }

    public void agregarInquilino(Persona persona) {
        inquilinos.add(persona);
    }

    public void pagarExpensa(String mes) {
        for (Factura expensa : expensas) {
            if (expensa.getMes() == mes) {
                expensa.cambiarEstado(new FacturaPaga());
            }
        }
        System.out.print(this.expensas);
    }

}
