package modelo;

import java.text.SimpleDateFormat;

import states.FacturaImpaga;
import states.IEstadoFactura;

public class Factura {

    private Double total;
    private IEstadoFactura estado;
    private String mes; 
    private SimpleDateFormat fechaGeneracion;
    private String usuarioGenerador;
    private String criterioElegido;
    
    public Factura(Double total, String mes, String usuarioGenerador, SimpleDateFormat fechaGeneracion, String criterioElegido) {
        this.total = total;
        this.mes = mes;
        this.usuarioGenerador = usuarioGenerador;
        this.fechaGeneracion = fechaGeneracion;
        this.criterioElegido = criterioElegido;
        this.estado = new FacturaImpaga();
    }

    public void cambiarEstado(IEstadoFactura nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String getMes() {
        return this.mes;
    }

    public String getCriterioElegido() {
        return this.criterioElegido;
    }

    public Double getTotal() {
        return this.total;
    }

    public String getUsuarioGenerador() {
        return this.usuarioGenerador;
    }

    public SimpleDateFormat getFechaGeneracion() {
        return this.fechaGeneracion;
    }

    public IEstadoFactura getEstado() {
        return estado;
    }

}
