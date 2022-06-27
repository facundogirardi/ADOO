package modelo;

import states.FacturaImpaga;
import states.IEstadoFactura;

public class Factura {

    private Double total;
    private IEstadoFactura estado;
    private String mes; 
    private String usuarioGenerador;
    
    public Factura(Double total, String mes, String usuarioGenerador) {
        this.total = total;
        this.mes = mes;
        this.usuarioGenerador = usuarioGenerador;
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

}
