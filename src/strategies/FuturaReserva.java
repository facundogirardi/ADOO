package strategies;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class FuturaReserva extends AbstractEstrategiaPago {

    @Override
    public void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales) {
        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            Double montoAPagar = (gastoTotal * unidadFuncional.getPorcentajeDePago()) / 100;
            Factura nuevaExpensa = new Factura(montoAPagar + ((montoAPagar * 10) / 100));
            unidadFuncional.agregarExpensa(nuevaExpensa);
        };
    }

}
