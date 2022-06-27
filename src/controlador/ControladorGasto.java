package controlador;

import java.util.ArrayList;

import modelo.BotRecurrente;
import modelo.Gasto;
import modelo.GastoNormal;
import modelo.GastoRecurrente;
import enums.TipoExpensa;

public class ControladorGasto {
    private static ArrayList<Gasto> gastos;
    private static ControladorGasto instancia;

    public ControladorGasto() {
        gastos = new ArrayList<Gasto>();
    }

    public static ControladorGasto getInstancia() {
        if (instancia == null) {
            instancia = new ControladorGasto();
        }
        return instancia;
    }

    public void generarGastoNormal(Float monto, int mes, TipoExpensa tipoExpensa, String descripcion) {
        Gasto newGastoNormal = new GastoNormal(monto, tipoExpensa, mes, descripcion);
        gastos.add(newGastoNormal);
    }

    public void generarGastoRecurrente(Float monto, TipoExpensa tipoExpensa, String descripcion, int mesDesde,
            int mesHasta) {
        Gasto newGastoRecurrente = new GastoRecurrente(monto, tipoExpensa, descripcion, mesDesde, mesHasta);
        gastos.add(newGastoRecurrente);

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

}
