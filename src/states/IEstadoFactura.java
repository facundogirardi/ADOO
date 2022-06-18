package states;

import modelo.Factura;

//TODO actualizar en Diagrama de Clases.
public interface IEstadoFactura {
    void verificarPago(Factura contexto);
}