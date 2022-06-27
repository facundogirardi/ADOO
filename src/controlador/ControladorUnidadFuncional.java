package controlador;

import java.util.ArrayList;
import enums.TipoUnidadFuncional;
import modelo.Factura;
import modelo.Persona;
import modelo.UnidadFuncional;

public class ControladorUnidadFuncional {
	private static ArrayList<UnidadFuncional> unidadesFuncionales;
	private static ControladorUnidadFuncional instancia;

	public ControladorUnidadFuncional() {
		unidadesFuncionales = new ArrayList<UnidadFuncional>();
	}

	public static ControladorUnidadFuncional getInstancia() {
		if (instancia == null) {
			instancia = new ControladorUnidadFuncional();
		}
		return instancia;
	}

	public void crearNuevaUnidadFuncional(TipoUnidadFuncional tipoDeUnidad, Double porcentajeDePago,
			String codigo, Double metrosCuadrados, ArrayList<Persona> propietarios,
			ArrayList<Persona> inquilinos, ArrayList<Factura> expensas) {
		UnidadFuncional newUnidadFuncional = buscarUnidadFuncional(codigo);
		if (newUnidadFuncional == null) {
			newUnidadFuncional = new UnidadFuncional(tipoDeUnidad, porcentajeDePago, codigo, metrosCuadrados,
					propietarios, inquilinos, expensas);
			unidadesFuncionales.add(newUnidadFuncional);

		}

	}

	public UnidadFuncional buscarUnidadFuncional(String codigo) {
		for (int i = 0; i < unidadesFuncionales.size(); i++) {
			UnidadFuncional aux = unidadesFuncionales.get(i);
			if (aux.sosLaUnidadFuncional(codigo))
				return aux;
		}
		return null;
	}

	public UnidadFuncional getFuncional(String codigo) {
		for (int i = 0; i < unidadesFuncionales.size(); i++) {
			if (unidadesFuncionales.get(i).getCodigo().equals(codigo)) {
				return unidadesFuncionales.get(i);

			}
		}
		return null;
	}

	public void agregarDueño(Persona persona, String codigo) {
		UnidadFuncional newUnidadFuncional = this.buscarUnidadFuncional(codigo);
		if (newUnidadFuncional != null) {
			newUnidadFuncional.agregarDueño(persona);
		}
	}

	public void agregarInquilino(Persona persona, String codigo) {
		UnidadFuncional newUnidadFuncional = this.buscarUnidadFuncional(codigo);
		if (newUnidadFuncional != null) {
			newUnidadFuncional.agregarInquilino(persona);
		}
	}

}
