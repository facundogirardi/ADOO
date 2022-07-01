package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class BotRecurrente {

    private ArrayList<GastoRecurrente> gastos;
    private int executionTime = (LocalDate.now().getMonthValue());
    private int recurrencia;

    public BotRecurrente(ArrayList<GastoRecurrente> gastos) {
        this.gastos = gastos;
    }

    public ArrayList<GastoNormal> getGastosRecurrentesFromBot() {
        ArrayList<GastoNormal> resultado = new ArrayList<GastoNormal>();
        for (GastoRecurrente gasto : gastos) {
            if (gasto.getMesDesde() <= this.executionTime && gasto.getMesHasta() >= this.executionTime) {
                recurrencia = recurrencia + 1;
                String idGastoRecurrenteNuevo = gasto.getIdGasto() + recurrencia;
                GastoNormal nuevoGasto = new GastoNormal(idGastoRecurrenteNuevo, gasto.getMonto(), gasto.getTipoExpensa(),
                        executionTime, gasto.getDescripcion());
                resultado.add(nuevoGasto);
            }
        }
        return resultado;
    }
}