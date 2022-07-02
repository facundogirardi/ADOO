package states;

import java.time.LocalDate;

import modelo.Factura;

public class FacturaImpaga extends AbstractEstadoFactura {

    Double interes = 10.00;

    public FacturaImpaga() {}

    @Override
    public void verificarPago(Factura contexto) {
        if (LocalDate.now().isAfter(contexto.getFechaVencimiento())) {
            System.out.println(LocalDate.now() );
            Double interesCalculado = contexto.getTotal() + ((contexto.getTotal() * interes)/100);
            contexto.setTotal(contexto.getTotal() + interesCalculado);
            System.out.println("Factura vencida, total con interes generado : " + interesCalculado);
        }
        contexto.cambiarEstado(new FacturaPaga()); 
        System.out.println("Facura pagada exitosamente");
    }

}
