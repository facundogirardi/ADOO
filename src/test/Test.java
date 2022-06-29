package test;

import modelo.GastoNormal;
import modelo.GastoRecurrente;
import modelo.Persona;
import modelo.UnidadFuncional;
import strategies.AbstractEstrategiaPago;
import strategies.PagoFuturaReserva;
import enums.TipoExpensa;
import enums.TipoNotificacion;
import enums.TipoUnidadFuncional;
import controlador.ControladorConsorcio;
import controlador.ControladorGasto;
import controlador.ControladorOperador;
import controlador.ControladorPersona;
import controlador.ControladorUnidadFuncional;

public class Test {

	public static void main(String[] args) {

		// Crear consorcio.
		ControladorConsorcio.getInstancia().crearNuevoConsorcio("0001", "Consorcio ADO Viernes Noche");
		System.out.println("Creo Consorcio : " + ControladorConsorcio.getInstancia().getConsorcio("0001").getNombreConsorcio());

		// Crear y loguear operador.
		ControladorOperador.getInstancia().crearNuevoOperador("Facundo", "Girardi", "123456789", "facundo.girardi@gmail.com", "fgirardi", "1234");
		System.out.print("Creo Operador : " + ControladorOperador.getInstancia().getOperador("fgirardi").getNombre() + " - ");

		String usuario = "fgirardi";
		System.out.println("Logueo Operador : " + usuario);
		ControladorOperador.getInstancia().login("fgirardi", "1234");

		// Crear personas
		ControladorPersona.getInstancia().crearNuevaPersona("37349380", "Matias", "Stricagnoli", "Matias@gmail.com", "111111111", TipoNotificacion.WHATSAPP);
		System.out.println("Creo Persona : " + ControladorPersona.getInstancia().getPersona("37349380").getNombre());
		ControladorPersona.getInstancia().crearNuevaPersona("37349381", "Diego", "Blanco", "Marcela@gmail.com", "111111111", TipoNotificacion.EMAIL);
		System.out.println("Creo Persona : " + ControladorPersona.getInstancia().getPersona("37349381").getNombre());
		ControladorPersona.getInstancia().crearNuevaPersona("37349382", "Lautario", "Mitelman", "Marcela@gmail.com", "111111111", TipoNotificacion.SMS);
		System.out.println("Creo Persona : " + ControladorPersona.getInstancia().getPersona("37349381").getNombre());

		// Crear unidad funcional.
		ControladorUnidadFuncional.getInstancia().crearNuevaUnidadFuncional(TipoUnidadFuncional.DEPARTAMENTO, 20.00, "1234", 20.00, null, null, null);
		System.out.println("Creo Unidad Funcional - Codigo : " + ControladorUnidadFuncional.getInstancia().getFuncional("1234").getCodigo());
		ControladorUnidadFuncional.getInstancia().crearNuevaUnidadFuncional(TipoUnidadFuncional.DEPARTAMENTO, 60.00, "1235", 160.00, null, null, null);
		System.out.println("Creo Unidad Funcional - Codigo : " + ControladorUnidadFuncional.getInstancia().getFuncional("1235").getCodigo());

		// Agrego unidad funcional al consorcio
		UnidadFuncional unidad_1 = ControladorUnidadFuncional.getInstancia().buscarUnidadFuncional("1234");
		ControladorConsorcio.getInstancia().añadirUnidadFuncionalConsorcio("0001", unidad_1);
		UnidadFuncional unidad_2 = ControladorUnidadFuncional.getInstancia().buscarUnidadFuncional("1235");
		ControladorConsorcio.getInstancia().añadirUnidadFuncionalConsorcio("0001", unidad_2);

		// Agrego Dueño
		Persona dueño_1 = ControladorPersona.getInstancia().buscarPersona("37349380");
		ControladorUnidadFuncional.getInstancia().agregarDueño(dueño_1, "1234");
		Persona dueño_2 = ControladorPersona.getInstancia().buscarPersona("37349380");
		ControladorUnidadFuncional.getInstancia().agregarDueño(dueño_2, "1235");
		
		// Agrego Inquilino
		Persona inquilino_1 = ControladorPersona.getInstancia().buscarPersona("37349381");
		ControladorUnidadFuncional.getInstancia().agregarInquilino(inquilino_1, "1234");
		Persona inquilino_2 = ControladorPersona.getInstancia().buscarPersona("37349381");
		ControladorUnidadFuncional.getInstancia().agregarInquilino(inquilino_2, "1234");
		Persona inquilino_3 = ControladorPersona.getInstancia().buscarPersona("37349382");
		ControladorUnidadFuncional.getInstancia().agregarInquilino(inquilino_2, "1234");

		// Agrego Suscriptores
		ControladorConsorcio.getInstancia().suscribirObservador("0001", dueño_1);
		ControladorConsorcio.getInstancia().suscribirObservador("0001",inquilino_2);

        // Quito Suscriptores
        ControladorConsorcio.getInstancia().eliminarObservador("0001",inquilino_3);

		// Generar gastos del consorcio.
		// Gasto normal
	    ControladorGasto.getInstancia().generarGastoNormal("GN01",1500.00f, 6, TipoExpensa.ORDINARIA, "Agua");
		ControladorGasto.getInstancia().generarGastoNormal("GN02",750.50f, 6, TipoExpensa.ORDINARIA, "Gas");
		ControladorGasto.getInstancia().generarGastoNormal("GN03",750.50f, 8, TipoExpensa.ORDINARIA, "Gas"); // Gasto de otro mes
		ControladorGasto.getInstancia().generarGastoNormal("GN04",200.00f, 6, TipoExpensa.EXTRAORDINARIA, "Arreglo de Ascensor");

		// Gasto recurrente
		int mesDesde = 1;
		int mesHasta = 8;
		ControladorGasto.getInstancia().generarGastoRecurrente("GR01",3000.00f, TipoExpensa.ORDINARIA, "ABL", mesDesde, mesHasta);

		// Agrego gastos al consorcio
		GastoNormal gastoNormal_1 = (GastoNormal) ControladorGasto.getInstancia().buscarGasto("GN01");
        ControladorConsorcio.getInstancia().añadirGastoNormalConsorcio("0001", gastoNormal_1);
		GastoNormal gastoNormal_2 = (GastoNormal) ControladorGasto.getInstancia().buscarGasto("GN02");
		ControladorConsorcio.getInstancia().añadirGastoNormalConsorcio("0001", gastoNormal_2);
		GastoNormal gastoNormal_3 = (GastoNormal) ControladorGasto.getInstancia().buscarGasto("GN03");
		ControladorConsorcio.getInstancia().añadirGastoNormalConsorcio("0001", gastoNormal_3);
		GastoNormal gastoNormal_4 = (GastoNormal) ControladorGasto.getInstancia().buscarGasto("GN04");
		ControladorConsorcio.getInstancia().añadirGastoNormalConsorcio("0001", gastoNormal_4);
		GastoRecurrente gastoRecurrente_1 = (GastoRecurrente) ControladorGasto.getInstancia().buscarGasto("GR01");
		ControladorConsorcio.getInstancia().añadirGastoRecurrenteConsorcio("0001", gastoRecurrente_1);

		// Genero gastos recurrentes
		ControladorGasto.getInstancia().generarGastoRecurrenteBot("0001");

	    // Agregar estrategia de pago al consorcio.
		AbstractEstrategiaPago estrategiaPago = new PagoFuturaReserva();
 
		// Generar expensas.
		ControladorConsorcio.getInstancia().generarExpensas("0001", "fgirardi", estrategiaPago);

		// Cliente paga expensa.
		ControladorConsorcio.getInstancia().pagarExpensa("0001", "1234" , "JUNE");

		// TO DO
		// Bot recurrente no da de alta los gastos recurrentes GastoRecurrente.getMesDesde()  trae 0 no accede a la herencia
		// Ver deuda anterior al momento de generar la factura, podriamos sumarle un sumarle un interes
		// Ver el pagoFondo es el total dividido. Es raro porque el total da negativo (Esta bien!, pero capaz la cuenta es distinta)
		// pagoFondo esta bien que pasemos los parametros directamente?
		// Controlador desde controlador para el bot recuerrente, se puede mejorar?
		// Revisar validaciones
		// Revisar diagrama que esten todas los metodos con sus parametros
		// Agregar al diagrama de clases la cardinalidad

	}

}
