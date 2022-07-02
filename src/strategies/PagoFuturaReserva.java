package strategies;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class PagoFuturaReserva extends AbstractEstrategiaPago {

    SimpleDateFormat fechaGeneracion = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Month mes = LocalDate.now().getMonth();
    String criterioElegido = "PagoFuturaReserva";
    Double interes = 10.00;

    @Override
    public void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales, String usuarioGenerador) {
        System.out.println("Estrategia pago establecida : Futura Reserva");
        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            Double montoAPagar = (gastoTotal * unidadFuncional.getPorcentajeDePago()) / 100;
            LocalDate fechaVencimiento = LocalDate.now().plusDays(10);
            Factura nuevaExpensa = new Factura(montoAPagar + ((montoAPagar * interes) / 100), mes.toString(), usuarioGenerador, fechaGeneracion, criterioElegido, fechaVencimiento);
            unidadFuncional.agregarExpensa(nuevaExpensa);
            super.loggearExpensa(nuevaExpensa, unidadFuncional.getCodigo());
        };
    }

}
