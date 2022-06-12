package modelo;
import java.time.LocalDate;

import enums.TipoExpensa;

public class GastoRecurrente extends Gasto {

    private LocalDate recurrenciaDesde;
    private LocalDate recurrenciaHasta;
            
    public GastoRecurrente(Float monto, TipoExpensa tipoExpensa, int mes, String descripcion, LocalDate recurrenciaDesde, LocalDate recurrenciaHasta) {
        super(monto, tipoExpensa, mes, descripcion);
        this.recurrenciaDesde = recurrenciaDesde;
        this.recurrenciaHasta = recurrenciaHasta;
    }

}
