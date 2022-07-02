package states;

import modelo.Factura;

public abstract class AbstractEstadoFactura {

    AbstractEstadoFactura() {}

    public abstract void verificarPago(Factura contexto);

}