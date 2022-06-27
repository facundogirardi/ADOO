package modelo;

import java.time.LocalDate;

import states.FacturaImpaga;
import states.IEstadoFactura;

public class Factura {

    private Double total;
    private IEstadoFactura estado;
    private String mes; 
    private LocalDate fechaGeneracion;
    private String usuarioGenerador;
    
    public Factura(Double total, String mes, String usuarioGenerador, LocalDate fechaGeneracion) {
        this.total = total;
        this.mes = mes;
        this.usuarioGenerador = usuarioGenerador;
        this.fechaGeneracion = fechaGeneracion;
        this.estado = new FacturaImpaga();
    }

    public void verificarPago() {
        this.estado.verificarPago(this);
    }

    public void cambiarEstado(IEstadoFactura nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String getMes() {
        return this.mes;
    }

    public Double getTotal() {
        return this.total;
    }

    public String getUsuarioGenerador() {
        return this.usuarioGenerador;
    }

    
    public LocalDate getFechaGeneracion() {
        return this.fechaGeneracion;
    }

}
