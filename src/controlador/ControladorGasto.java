package controlador;

import java.util.ArrayList;

import modelo.BotRecurrente;
import modelo.Gasto;
import modelo.GastoNormal;
import modelo.GastoRecurrente;
import enums.TipoExpensa;

public class ControladorGasto {
    private static ArrayList<Gasto> Gastos;
    private static ControladorGasto instancia;

    public ControladorGasto() {
        Gastos = new ArrayList<Gasto>();
    }

    public static ControladorGasto getInstancia() {
        if (instancia == null) {
            instancia = new ControladorGasto();
        }
        return instancia;
    }

    public void generarGastoNormal(Float monto, int mes, TipoExpensa tipoExpensa, String descripcion) {
        Gasto newGastoNormal = new GastoNormal(monto, tipoExpensa, mes, descripcion);
        Gastos.add(newGastoNormal);
    }

    public void generarGastoRecurrente(Float monto, TipoExpensa tipoExpensa, String descripcion, int mesDesde,
            int mesHasta) {
        Gasto newGastoRecurrente = new GastoRecurrente(monto, tipoExpensa, descripcion, mesDesde, mesHasta);
        Gastos.add(newGastoRecurrente);

    }

    public void generarGastoRecurrenteBot() {
        BotRecurrente newGastoRecurrenteBot = new BotRecurrente(null);
        Gastos.add(newGastoRecurrenteBot);

    }

}
