package controlador;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.BotRecurrente;
import modelo.Gasto;
import modelo.GastoNormal;
import modelo.GastoRecurrente;
import enums.TipoExpensa;

public class ControladorGasto {
    private static ArrayList<Gasto> gastos;
    private static ControladorGasto instancia;
    private int mesActual = (LocalDate.now().getMonthValue());

    public ControladorGasto() {
        gastos = new ArrayList<Gasto>();
    }

    public static ControladorGasto getInstancia() {
        if (instancia == null) {
            instancia = new ControladorGasto();
        }
        return instancia;
    }

    public void generarGastoNormal(String idGasto, Float monto, int mes, TipoExpensa tipoExpensa, String descripcion) {
        Gasto newGastoNormal = buscarGasto(idGasto);
        if (newGastoNormal == null && mesActual == mes) {
            newGastoNormal = new GastoNormal(idGasto, monto, tipoExpensa, mes, descripcion);
            gastos.add(newGastoNormal);
        }
    }

    public void generarGastoRecurrente(String idGasto, Float monto, TipoExpensa tipoExpensa, String descripcion,
            int mesDesde, int mesHasta) {
        Gasto newGastoRecurrente = buscarGasto(idGasto);
        if (newGastoRecurrente == null) {
            newGastoRecurrente = new GastoRecurrente(idGasto, monto, tipoExpensa, descripcion, mesDesde, mesHasta);
            gastos.add(newGastoRecurrente);
        }

    }

    public void generarGastoRecurrenteBot() {
        ArrayList<GastoRecurrente> gastosRecurrentes = new ArrayList<GastoRecurrente>();
        for (Gasto gasto : gastos) {
            if (gasto instanceof GastoRecurrente) {
                gastosRecurrentes.add((GastoRecurrente) gasto);
            }
        }
        BotRecurrente botRecurrente = new BotRecurrente(gastosRecurrentes);
        gastos.addAll(botRecurrente.getGastosRecurrentesFromBot());
    }

    public static ArrayList<Gasto> getGastos() {
        return gastos;
    }

    public Gasto buscarGasto(String idGasto) {
        for (int i = 0; i < gastos.size(); i++) {
            Gasto aux = gastos.get(i);
            if (aux.sosElGasto(idGasto))
                return aux;

        }

        return null;
    }

}
