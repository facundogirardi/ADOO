package strategies;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class PagoCompleto extends AbstractEstrategiaPago {

    @Override
    public void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales) {
        System.out.println("Estrategia pago: Pago Completo");
        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            Double montoAPagar = (gastoTotal * unidadFuncional.getPorcentajeDePago()) / 100;
            Factura nuevaExpensa = new Factura(montoAPagar, "Julio");
            unidadFuncional.agregarExpensa(nuevaExpensa);
            super.loggearExpensa(nuevaExpensa);
        };
    }

}
