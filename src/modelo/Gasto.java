package modelo;

import enums.TipoExpensa;

public class Gasto {

    private Float monto;
    private TipoExpensa tipoExpensa;
    private int mes;
    private String descripcion;

    public Gasto(Float monto, TipoExpensa tipoExpensa, int mes, String descripcion) {
        this.monto = monto;
        this.tipoExpensa = tipoExpensa;
        this.mes = mes;
        this.descripcion = descripcion;
    }
        
    public Float getMonto() {
        return monto;
    };

    public TipoExpensa getTipoExpensa() {
        return tipoExpensa;
    };

    public int getMes() {
        return mes;
    };

    public String getDescripcion() {
        return descripcion;
    };
}
