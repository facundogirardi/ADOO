package modelo;

import java.time.LocalDate;

import enums.TipoExpensa;

public class GastoNormal extends Gasto {

    private int mes;

    public GastoNormal(Float monto, TipoExpensa tipoExpensa, int mes, String descripcion) {
        super(monto, tipoExpensa, descripcion);
        this.mes = mes;
    }
 
    public int getMes() {
        return mes;
    }
    
}
