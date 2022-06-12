package test;

import modelo.Consorcio;
import modelo.Operador;
import strategies.EnvioEmail;
import strategies.EnvioWhatsapp;
import strategies.EnvioSMS;
import java.time.LocalDate;


public class Test {

	public static void main(String[] args) {

		Consorcio consorcio = new Consorcio("0001", "Consorcio", new EnvioEmail());
		System.out.print("Consorcio : " + consorcio.getIdConsorcio() + " Creado - ");

		Operador operador = new Operador("Facundo", "Girardi", "123456789", "facundo.girardi@gmail.com", "fgirardi", "1234");
		System.out.println("Operador : " + operador.getUsuario() + " Creado");
		operador.login("fgirardi", "1234");

		consorcio.obtenerSaldo( "123456789", "abcd" , LocalDate.now());
		consorcio.cambioEstrategiaEnvio(new EnvioWhatsapp());

	}

}
