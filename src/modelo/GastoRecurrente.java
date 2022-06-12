package modelo;
import java.time.LocalDate;

public abstract class GastoRecurrente extends Gasto {

    private LocalDate recurrenciaDesde;
    private LocalDate recurrenciaHasta;
            
    public GastoRecurrente() {

    }

}
