package modelo;

import states.IEstadoFactura;

//TODO actualizar en Diagrama de Clases.
public class Factura {

    private Double valorExtraordinario;
    private Double valorOrdinario;
    private Double total;
    private IEstadoFactura estado;
    private String mes; 
    
    public Factura(Double total, String mes) {
        this.total = total;
        this.mes = mes;
    }

    public void verificarPago() {
        this.estado.verificarPago(this);
    }

    public void cambiarEstado(IEstadoFactura nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String getMes() {
        return mes;
    }

    public Double getTotal() {
        return total;
    }

}
