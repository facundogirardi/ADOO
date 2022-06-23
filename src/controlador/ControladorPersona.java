package controlador;

import java.util.ArrayList;
import modelo.Persona;
import enums.TipoNotificacion;

public class ControladorPersona {
	private static ArrayList<Persona> personas;
	private static ControladorPersona instancia;

	public ControladorPersona() {
		personas = new ArrayList<Persona>();
	}

	public static ControladorPersona getInstancia() {
		if (instancia == null) {
			instancia = new ControladorPersona();
		}
		return instancia;
	}

	public void crearNuevaPersona(String dni, String nombre, String apellido, String email, String telefono,
			TipoNotificacion tipoNotificacion) {
		Persona newPersona = buscarPersona(dni);
		if (newPersona == null) {
			newPersona = new Persona(dni, nombre, apellido, email, telefono, tipoNotificacion);
			personas.add(newPersona);
		}
	}

	public Persona buscarPersona(String dni) {
		for (int i = 0; i < personas.size(); i++) {
			Persona aux = personas.get(i);
			if (aux.sosLaPersona(dni))
				return aux;

		}

		return null;
	}

	public Persona getPersona(String dni) {
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getDni().equals(dni)) {
				return personas.get(i);

			}
		}
		return null;
	}
}
