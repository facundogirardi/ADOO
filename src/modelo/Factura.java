package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import states.AbstractEstadoFactura;
import states.FacturaImpaga;

public class Factura {

    private Double total;
    private AbstractEstadoFactura estado;
    private String mes; 
    private SimpleDateFormat fechaGeneracion;
    private String usuarioGenerador;
    private String criterioElegido;
    private LocalDate fechaDeVencimiento;
    
    public Factura(Double total, String mes, String usuarioGenerador, SimpleDateFormat fechaGeneracion, String criterioElegido, LocalDate fechaDeVencimiento) {
        this.total = total;
        this.mes = mes;
        this.usuarioGenerador = usuarioGenerador;
        this.fechaGeneracion = fechaGeneracion;
        this.criterioElegido = criterioElegido;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.estado = new FacturaImpaga();
    }

    public void pagar() {
        this.estado.verificarPago(this);;
    }

    public void cambiarEstado(AbstractEstadoFactura nuevoEstado) {
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

    public void setTotal(Double nuevoTotal) {
        this.total = nuevoTotal;
    }

    public String getUsuarioGenerador() {
        return this.usuarioGenerador;
    }

    public SimpleDateFormat getFechaGeneracion() {
        return this.fechaGeneracion;
    }

    public LocalDate getFechaVencimiento() {
        return this.fechaDeVencimiento;
    }

    public AbstractEstadoFactura getEstado() {
        return estado;
    }

}
