package states;
import modelo.Factura;

public interface IEstadoFactura {
    void verificarPago(Factura contexto);
}