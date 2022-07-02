package states;

import java.time.LocalDate;

import modelo.Factura;

public class FacturaImpaga extends AbstractEstadoFactura {

    Double interes = 0.10;

    public FacturaImpaga() {}

    @Override
    public void verificarPago(Factura contexto) {
        if (contexto.getFechaVencimiento().isAfter(LocalDate.now())) {
            Double interesCalculado = contexto.getTotal() + (contexto.getTotal() * interes);
            contexto.setTotal(contexto.getTotal() + interesCalculado);
        }
        contexto.cambiarEstado(new FacturaPaga()); 
    }

}
