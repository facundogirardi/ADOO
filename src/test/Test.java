package test;

import modelo.Consorcio;
import modelo.Operador;
import strategies.EstrategiaEnvioEmail;
import strategies.EstrategiaEnvioWhatsapp;
import strategies.EstrategiaEnvioSMS;
import java.time.LocalDate;


public class Test {

	public static void main(String[] args) {

		Consorcio consorcio = new Consorcio("0001", "Consorcio", new EstrategiaEnvioEmail());
		System.out.print("Consorcio : " + consorcio.getIdConsorcio() + " Creado - ");

		Operador operador = new Operador("Facundo", "Girardi", "123456789", "facundo.girardi@gmail.com", "fgirardi", "1234");
		System.out.println("Operador : " + operador.getUsuario() + " Creado");
		operador.login("fgirardi", "1234");

		consorcio.obtenerSaldo( "123456789", "abcd" , LocalDate.now());
		consorcio.cambioEstrategiaEnvio(new EstrategiaEnvioWhatsapp());

	}

}
