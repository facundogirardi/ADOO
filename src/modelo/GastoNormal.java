package modelo;

import enums.TipoExpensa;

public class GastoNormal extends Gasto {

    private Float monto;
    private String tipoDeExpensa;
    private String mes;
    private String descripcion;

    public GastoNormal(Float monto, TipoExpensa tipoDeExpensa, String mes, String descripcion) {
        super();
    }
    
}
