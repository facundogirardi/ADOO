package strategies;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import modelo.Factura;
import modelo.UnidadFuncional;

public class PagoFondoReserva extends AbstractEstrategiaPago {

	LocalDate fechaGeneracion = LocalDate.now();
	Month mes = fechaGeneracion.getMonth();
    String criterioElegido = "PagoFondoReserva";

    @Override
    public void divisionExpensas(Double gastoTotal, ArrayList<UnidadFuncional> unidadesFuncionales, String usuarioGenerador) {
        System.out.println("Estrategia pago establecida : Fondo Reserva");
        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            Float saldoObtenido = super.obtencionSaldo("CBU", "token", LocalDate.now());
            Double montoAPagar = (gastoTotal * unidadFuncional.getPorcentajeDePago()) / 100 - saldoObtenido;
            Factura nuevaExpensa = new Factura(montoAPagar,  mes.toString(), usuarioGenerador, fechaGeneracion, criterioElegido);
            unidadFuncional.agregarExpensa(nuevaExpensa);
            super.loggearExpensa(nuevaExpensa, unidadFuncional.getCodigo());
        };
    }

}
