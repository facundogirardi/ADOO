package strategies;

import java.time.LocalDate;
import java.util.ArrayList;

import adapters.AdapterSaldoCuenta;
import adapters.IAdapterSaldo;
import modelo.Factura;
import modelo.Gasto;
import modelo.UnidadFuncional;

public abstract class AbstractEstrategiaPago {

    public Double calculoDeGastos(ArrayList<Gasto> gastos) {
        Double montoTotal = 0.0;
        for (Gasto gasto : gastos) {
            montoTotal = montoTotal + gasto.getMonto();
        };
        return montoTotal;
    };

    public Float obtencionSaldo(String cbu, String token, LocalDate fechaConsulta) {
        IAdapterSaldo adapterSaldo = new AdapterSaldoCuenta();
        return adapterSaldo.obtenerSaldo(cbu, token, fechaConsulta);
    };

    public abstract void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales);

    public void loggearExpensa(Factura factura) {
        System.out.printf("Se generó una factura de %d", factura.getTotal());
    }
}
