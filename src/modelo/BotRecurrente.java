package modelo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import modelo.Gasto;
import modelo.GastoRecurrente;

public class BotRecurrente {

    private int executionTime;
    private LocalDate lastExecution;

    LocalDate hoy = LocalDate.now();

    public BotRecurrente(ArrayList<GastoRecurrente> gastos) {
        executionTime = (hoy.getMonthValue() - 1);
        System.out.println("entro");
        Double montoTotal = 0.00;
        for (GastoRecurrente gasto : gastos) {
            if (executionTime >= GastoRecurrente.getMesDesde() && executionTime >= GastoRecurrente.getMesHasta()) {
                montoTotal = montoTotal + gasto.getMonto();
                System.out.println(montoTotal);
            }
        }
    }

}
