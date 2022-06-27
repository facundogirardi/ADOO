package modelo;
import enums.TipoExpensa;

public class GastoNormal extends Gasto {

    private int mes;

    public GastoNormal(String idGasto , Float monto, TipoExpensa tipoExpensa, int mes, String descripcion) {
        super(idGasto, monto, tipoExpensa, descripcion);
        this.mes = mes;
    }
 
    public int getMes() {
        return mes;
    }

    
}
