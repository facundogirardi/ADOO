package strategies;

import java.time.LocalDate;
import java.util.ArrayList;

import adapters.AdapterSaldoCuenta;
import adapters.IAdapterSaldo;
import modelo.Factura;
import modelo.Gasto;
import modelo.GastoNormal;
import modelo.GastoRecurrente;
import modelo.UnidadFuncional;

public abstract class AbstractEstrategiaPago {

    // public Double calculoDeGastos(ArrayList<Gasto> gastos) {
    // Double montoTotal = 0.0;
    // int mes = LocalDate.now().getMonthValue();
    // for (Gasto gasto : gastos) {
    // System.out.println( Gasto.getMes());
    // if (mes == Gasto.getMes()) {
    // montoTotal = montoTotal + gasto.getMonto();
    // }
    // }
    // ;
    // return montoTotal;
    // };

    public Float obtencionSaldo(String cbu, String token, LocalDate fechaConsulta) {
        IAdapterSaldo adapterSaldo = new AdapterSaldoCuenta();
        return adapterSaldo.obtenerSaldo(cbu, token, fechaConsulta);
    };

    public abstract void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales);

    public void loggearExpensa(Factura factura) {
        
        System.out.printf("Se generó una factura de %d para el mes de %s", factura.getTotal(), factura.getMes());
    }
}
