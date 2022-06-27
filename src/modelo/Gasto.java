package modelo;

import enums.TipoExpensa;

public class Gasto {

    private String idGasto;
    private Float monto;
    private TipoExpensa tipoExpensa;
    private String descripcion;

    public Gasto(String idGasto, Float monto, TipoExpensa tipoExpensa, String descripcion) {
        this.idGasto = idGasto;
        this.monto = monto;
        this.tipoExpensa = tipoExpensa;
        this.descripcion = descripcion;
    }

    public Float getMonto() {
        return monto;
    };

    public String getIdGasto() {
        return idGasto;
    };

    public TipoExpensa getTipoExpensa() {
        return tipoExpensa;
    };

    public String getDescripcion() {
        return descripcion;
    }

    public boolean sosElGasto(String idGastoBuscado) {
        if (idGasto.equalsIgnoreCase(idGastoBuscado)) {
            return true;
        } else {
            return false;
        }
    }

}
