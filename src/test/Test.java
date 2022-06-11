package test;

import modelo.Consorcio;
import modelo.Operador;
import strategies.EstrategiaEnvioEmail;
import strategies.EstrategiaEnvioWhatsapp;

public class Test {

	public static void main(String[] args) {

		Consorcio consorcio = new Consorcio("0001", "Consorcio", new EstrategiaEnvioWhatsapp());
		System.out.println("ID CONSORCIO " + consorcio.getIdConsorcio());

		Operador operador = new Operador("Facundo", "Girardi", "123456789", "facundo.girardi@gmail.com", "fgirardi", "1234");
		System.out.println("USUARIO OPERADOR " + operador.getUsuario());
		operador.login("lmitelman", "123");

		consorcio.cambioEstrategiaEnvio(new EstrategiaEnvioEmail());

	}

}
