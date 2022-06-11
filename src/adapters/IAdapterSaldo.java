package adapters;

import java.time.LocalDate;

public interface IAdapterSaldo {
    void obtenerSaldo(String cbu, String token, LocalDate fechaConsulta);
}
