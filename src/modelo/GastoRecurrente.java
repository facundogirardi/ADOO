package modelo;

import enums.TipoExpensa;

public class GastoRecurrente extends Gasto {

    private int mesDesde;
    private int mesHasta;
            
    public GastoRecurrente(String idGasto, Float monto, TipoExpensa tipoExpensa, String descripcion, int mesDesde, int mesHasta) {
        super(idGasto, monto, tipoExpensa, descripcion);
        this.mesDesde = mesDesde;
        this.mesHasta = mesHasta;
    }
    
    public int getMesDesde() {
        return mesDesde;
    };

    public int getMesHasta() {
        return mesHasta;
    };


}
