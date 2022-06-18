package strategies;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class PagoFuturaReserva extends AbstractEstrategiaPago {

    @Override
    public void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales) {
        System.out.println("Estrategia pago: Futura Reserva");
        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            Double montoAPagar = (gastoTotal * unidadFuncional.getPorcentajeDePago()) / 100;
            Factura nuevaExpensa = new Factura(montoAPagar + ((montoAPagar * 10) / 100), "Julio");
            unidadFuncional.agregarExpensa(nuevaExpensa);
            super.loggearExpensa(nuevaExpensa);
        };
    }

}
