package controlador;

public class Test {

	PersonaController miCoordinador;

	public static void main(String[] args) {
		Test miPrincipal=new Test();
		miPrincipal.iniciar();
	}

	private void iniciar() {
		miCoordinador= new PersonaController();

	}
}
