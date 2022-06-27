package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
public class BotRecurrente {

    private ArrayList<GastoRecurrente> gastos;
    private int executionTime = (LocalDate.now().getMonthValue() - 1);

    public BotRecurrente(ArrayList<GastoRecurrente> gastos) {
        this.gastos = gastos;
    }

    public ArrayList<GastoNormal> getGastosRecurrentesFromBot() {
        ArrayList<GastoNormal> resultado = new ArrayList<GastoNormal>();
        for (GastoRecurrente gasto : gastos) {
            if (this.executionTime >= GastoRecurrente.getMesDesde() && this.executionTime >= GastoRecurrente.getMesHasta()) {
                GastoNormal nuevoGasto = new GastoNormal(gasto.getMonto(), gasto.getTipoExpensa(), executionTime, gasto.getDescripcion());
                resultado.add(nuevoGasto);
            }
        }
        return resultado;
    }
}
