package test;

import modelo.BotRecurrente;
import modelo.Consorcio;
import modelo.Operador;
import modelo.Persona;
import modelo.UnidadFuncional;
import strategies.AbstractEstrategiaPago;
import strategies.EnvioEmail;
import strategies.EnvioWhatsapp;
import strategies.PagoFuturaReserva;
import strategies.PagoCompleto;
import strategies.PagoFondoReserva;
import strategies.EnvioSMS;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import enums.TipoExpensa;
import enums.TipoNotificacion;
import enums.TipoUnidadFuncional;

public class Test {

	public static void main(String[] args) {

		// Crear consorcio.
		Consorcio consorcio = new Consorcio("0001", "Consorcio", new EnvioEmail());
		System.out.println("Creo Consorcio : " + consorcio.getIdConsorcio());

		// Crear y loguear operador.
		Operador operador = new Operador("Facundo", "Girardi", "123456789", "facundo.girardi@gmail.com", "fgirardi", "1234");
		System.out.println("Creo Operador : " + operador.getUsuario());
		String usuario = "fgirardi";
		System.out.print("Logueo Usuario : " + usuario + " - ");
		operador.login("fgirardi", "1234");

		// Crear personas
		Persona persona = new Persona("37349380", "Matias", "Stricagnoli", "Matias@gmail.com", "111111111", TipoNotificacion.WHATSAPP);
		System.out.println("Creo Persona : " + persona.getNombre());

		// Crear unidad funcional.
		//UnidadFuncional unidadFuncional = new UnidadFuncional(TipoUnidadFuncional.DEPARTAMENTO, 20.00, 40,);
		//System.out.println("Unidad Funcional - Propietario " + unidadFuncional.getPropietario() + " Creada");

		// Generar gastos del consorcio.
		// Gasto normal
		consorcio.generarGasto(1500.00f, TipoExpensa.ORDINARIA, 6, "Agua");
		consorcio.generarGasto(750.50f, TipoExpensa.ORDINARIA, 6, "Gas");
		consorcio.generarGasto(750.50f, TipoExpensa.ORDINARIA, 8, "Gas"); // Gasto de otro mes
		consorcio.generarGasto(200.00f, TipoExpensa.EXTRAORDINARIA, 6, "Arreglo de Ascensor");
		// Gasto recurrente
		LocalDate recurrenciaDesde = LocalDate.now();
		LocalDate recurrenciaHasta = LocalDate.of(2022, 8, 10);
		consorcio.generarGastoRecurrente(3000.00f, TipoExpensa.ORDINARIA, 6, "ABL", recurrenciaDesde, recurrenciaHasta);
		
		// Agregar estrategia de pago al consorcio.
		AbstractEstrategiaPago estrategiaPago = new PagoFuturaReserva();
		consorcio.cambioEstrategiaPago(estrategiaPago);
		// Generar expensas.
		int mes = 6;
		consorcio.generarExpensas(mes);
		
	}

}
