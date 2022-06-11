package adapters;

import java.time.LocalDate;

public class AdapterSaldoCuenta implements IAdapterSaldo {

    public void obtenerSaldo(String cbu, String token, LocalDate fechaConsulta) {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de consulta externo.
        System.out.printf("Consultando saldo del CBU : %s", cbu);
        System.out.println("");
         
    }
}
