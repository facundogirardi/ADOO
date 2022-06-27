package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
public class BotRecurrente {

    private ArrayList<GastoRecurrente> gastos;
    private int executionTime = (LocalDate.now().getMonthValue());

    public BotRecurrente(ArrayList<GastoRecurrente> gastos) {
        this.gastos = gastos;
    }

    public ArrayList<GastoNormal> getGastosRecurrentesFromBot() {
        ArrayList<GastoNormal> resultado = new ArrayList<GastoNormal>();
        for (GastoRecurrente gasto : gastos) {

            if ( GastoRecurrente.getMesDesde() <= this.executionTime && GastoRecurrente.getMesHasta() >= this.executionTime) {
                GastoNormal nuevoGasto = new GastoNormal(gasto.getIdGasto(), gasto.getMonto(), gasto.getTipoExpensa(), executionTime, gasto.getDescripcion());
                resultado.add(nuevoGasto);
            }
        }
        return resultado;
    }
}