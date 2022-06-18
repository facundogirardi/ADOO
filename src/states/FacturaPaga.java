package states;

import modelo.Factura;

public class FacturaPaga implements IEstadoFactura {

    @Override
    public void verificarPago(Factura contexto) {
        // TODO Auto-generated method stub
        if (true) {
            contexto.cambiarEstado(new FacturaPaga());
        }
    }
    
}
