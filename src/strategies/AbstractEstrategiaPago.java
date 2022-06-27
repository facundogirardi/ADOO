package strategies;

import java.time.LocalDate;
import java.util.ArrayList;

import adapters.AdapterSaldoCuenta;
import adapters.IAdapterSaldo;
import modelo.Factura;
import modelo.GastoNormal;
import modelo.UnidadFuncional;

public abstract class AbstractEstrategiaPago {

    public Double calculoDeGastos(ArrayList<GastoNormal> gastos) {
        Double montoTotal = 0.0;
        int mes = LocalDate.now().getMonthValue();
        for (GastoNormal gasto : gastos) {
            if (mes == gasto.getMes()) {
                montoTotal = montoTotal + gasto.getMonto();
            }
        };
        return montoTotal;
    };

    public Float obtencionSaldo(String cbu, String token, LocalDate fechaConsulta) {
        IAdapterSaldo adapterSaldo = new AdapterSaldoCuenta();
        return adapterSaldo.obtenerSaldo(cbu, token, fechaConsulta);
    };

    public abstract void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales, String usuarioGenerador);

    public void loggearExpensa(Factura factura) {
        System.out.println("Se generó una factura de : " + factura.getTotal() + " para el mes de : " + factura.getMes());
    }
}
