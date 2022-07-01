package strategies;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class PagoCompleto extends AbstractEstrategiaPago {

    SimpleDateFormat fechaGeneracion = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Month mes = LocalDate.now().getMonth();
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
        };
    }

}
