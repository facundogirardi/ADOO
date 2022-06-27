package modelo;

import enums.TipoExpensa;

public class GastoRecurrente extends Gasto {

    private static int mesDesde;
    private static int mesHasta;
            
    public GastoRecurrente(String idGasto, Float monto, TipoExpensa tipoExpensa, String descripcion, int mesDesde, int mesHasta) {
        super(idGasto, monto, tipoExpensa, descripcion);
    }
    
    public static int getMesDesde() {
        return mesDesde;
    };

    public static int getMesHasta() {
        return mesHasta;
    };


}
