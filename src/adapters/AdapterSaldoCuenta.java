package adapters;

import java.time.LocalDate;

public class AdapterSaldoCuenta implements IAdapterSaldo {

    public Float obtenerSaldo(String cbu, String token, LocalDate fechaConsulta) {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de consulta externo.
        return (float) 30000000;
    }
}
