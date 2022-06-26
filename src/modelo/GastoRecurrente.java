package modelo;

import enums.TipoExpensa;

public class GastoRecurrente extends Gasto {

    private static int mesDesde;
    private static int mesHasta;
            
    public GastoRecurrente(Float monto, TipoExpensa tipoExpensa, String descripcion, int mesDesde, int mesHasta) {
        super(monto, tipoExpensa, descripcion);
        this.mesDesde = mesDesde;
        this.mesHasta = mesHasta;
    }
    
    public static int getMesDesde() {
        return mesDesde;
    };

    public static int getMesHasta() {
        return mesHasta;
    };


}
