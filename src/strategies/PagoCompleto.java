package strategies;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class PagoCompleto extends AbstractEstrategiaPago {

    LocalDate fechaGeneracion = LocalDate.now();
    Month mes = fechaGeneracion.getMonth();
    String criterioElegido = "PagoCompleto";

    @Override
    public void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales,
            String usuarioGenerador) {
        System.out.println("Estrategia pago establecida : Pago Completo");

        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            Double montoAPagar = (gastoTotal * unidadFuncional.getPorcentajeDePago()) / 100;
            Factura nuevaExpensa = new Factura(montoAPagar, mes.toString(), usuarioGenerador, fechaGeneracion, criterioElegido);
            unidadFuncional.agregarExpensa(nuevaExpensa);
            super.loggearExpensa(nuevaExpensa, unidadFuncional.getCodigo());
        }
        ;

    }

}
