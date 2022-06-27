package strategies;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class PagoFuturaReserva extends AbstractEstrategiaPago {

    LocalDate currentDate = LocalDate.now();
    Month mes = currentDate.getMonth();

    @Override
    public void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales, String usuarioGenerador) {
        System.out.println("Estrategia pago establecida : Futura Reserva");
        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            Double montoAPagar = (gastoTotal * unidadFuncional.getPorcentajeDePago()) / 100;
            Factura nuevaExpensa = new Factura(montoAPagar + ((montoAPagar * 10) / 100), mes.toString(), usuarioGenerador);
            unidadFuncional.agregarExpensa(nuevaExpensa);
            super.loggearExpensa(nuevaExpensa);
        };
    }

}
