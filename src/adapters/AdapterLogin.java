package adapters;

public class AdapterLogin implements IAdapterLogin {

    public boolean login(String usuario, String contraseña) {
        // Dentro de esta clase, se debería realizar
        // la petición al sistema de Login externo.
        System.out.printf("Logueando al usuario %s", usuario);
        System.out.println("");
        return true;
    }
}
