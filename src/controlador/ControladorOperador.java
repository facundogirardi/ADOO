package controlador;
import java.util.ArrayList;
import modelo.Operador;

public class ControladorOperador {
	private ArrayList<Operador> operadores;

	public ControladorOperador() {
		super();
		operadores = new ArrayList<Operador>();
	}

	// Metodos del negocio
	// Crear Operador

	public void crearNuevoOperador(String nombre, String apellido, String telefono, String mail, String usuario,
			String contraseña) {
		Operador newOperador = buscarOperador(usuario);
		if (newOperador == null) {
			newOperador = new Operador(nombre, apellido, telefono, mail, usuario, contraseña);
			operadores.add(newOperador);

		}
	}
	// Buscar Operador

	public Operador buscarOperador(String usuario) {
		for (int i = 0; i < operadores.size(); i++) {
			Operador aux = operadores.get(i);
			if (aux.sosElOperador(usuario))
				return aux;

		}

		return null;
	}

}
