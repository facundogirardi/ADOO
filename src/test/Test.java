package test;

import modelo.BotRecurrente;
import modelo.Consorcio;
import modelo.Operador;
import strategies.AbstractEstrategiaPago;
import strategies.EnvioEmail;
import strategies.EnvioWhatsapp;
import strategies.PagoCompleto;
import strategies.EnvioSMS;
import java.time.LocalDate;

import enums.TipoExpensa;

public class Test {

	public static void main(String[] args) {

		// Crear consorcio.
		Consorcio consorcio = new Consorcio("0001", "Consorcio", new EnvioEmail());
		System.out.println("Consorcio " + consorcio.getIdConsorcio() + " Creado");

		// Agregar estrategia de pago al consorcio.
		AbstractEstrategiaPago estrategiaPago = new PagoCompleto();
		consorcio.cambioEstrategiaPago(estrategiaPago);

		// Crear y loguear operador.
		Operador operador = new Operador("Facundo", "Girardi", "123456789", "facundo.girardi@gmail.com", "fgirardi", "1234");
		System.out.println("Operador " + operador.getUsuario() + " Creado");
		operador.login("fgirardi", "1234");

		// Generar gastos del consorcio.
		consorcio.generarGasto(33f, TipoExpensa.ORDINARIA, 6, "Agua");
		LocalDate recurrenciaDesde = LocalDate.now();
		LocalDate recurrenciaHasta = LocalDate.of(2022, 8, 10);
		consorcio.generarGastoRecurrente(33f, TipoExpensa.ORDINARIA, 6, "Luz", recurrenciaDesde, recurrenciaHasta);

		// Generar expensas.
		consorcio.generarExpensas();
		
	}

}
