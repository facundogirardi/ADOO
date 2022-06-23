package modelo;

import enums.TipoExpensa;

public class Gasto {

    private Float monto;
    private TipoExpensa tipoExpensa;
    private String descripcion;

    public Gasto(Float monto, TipoExpensa tipoExpensa, String descripcion) {
        this.monto = monto;
        this.tipoExpensa = tipoExpensa;
        this.descripcion = descripcion;
    }

    public Float getMonto() {
        return monto;
    };

    public TipoExpensa getTipoExpensa() {
        return tipoExpensa;
    };

    public String getDescripcion() {
        return descripcion;
    }

}
