package strategies;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class PagoCompleto extends AbstractEstrategiaPago {

    @Override
    public void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales) {
        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            Double montoAPagar = (gastoTotal * unidadFuncional.getPorcentajeDePago()) / 100;
            Factura nuevaExpensa = new Factura(montoAPagar);
            unidadFuncional.agregarExpensa(nuevaExpensa);
        };
    }

}
