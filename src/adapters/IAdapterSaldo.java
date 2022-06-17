package adapters;

import java.time.LocalDate;

public interface IAdapterSaldo {
    Float obtenerSaldo(String cbu, String token, LocalDate fechaConsulta);
}
