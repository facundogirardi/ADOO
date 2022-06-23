package controlador;

import java.util.ArrayList;

import adapters.AdapterLogin;
import adapters.IAdapterLogin;
import modelo.Operador;

public class ControladorOperador {
	private static ArrayList<Operador> operadores;
	private static ControladorOperador instancia;

	public ControladorOperador() {
		operadores = new ArrayList<Operador>();

	}

	public static ControladorOperador getInstancia() {
		if (instancia == null) {
			instancia = new ControladorOperador();
		}
		return instancia;
	}

	public void crearNuevoOperador(String nombre, String apellido, String telefono, String mail, String usuario,
			String contraseña) {
		Operador newOperador = buscarOperador(usuario);
		if (newOperador == null) {
			newOperador = new Operador(nombre, apellido, telefono, mail, usuario, contraseña);
			operadores.add(newOperador);
		}
	}

	public Operador buscarOperador(String usuario) {
		for (int i = 0; i < operadores.size(); i++) {
			Operador aux = operadores.get(i);
			if (aux.sosElOperador(usuario))
				return aux;

		}

		return null;
	}

	public Operador getOperador(String usuario) {
		for (int i = 0; i < operadores.size(); i++) {
			if (operadores.get(i).getUsuario().equals(usuario)) {
				return operadores.get(i);
			}
		}
		return null;
	}

	public void login(String usuario, String contraseña) {
		IAdapterLogin adapterLogin = new AdapterLogin();
		adapterLogin.login(usuario, contraseña);
	}

}
