package test;

import modelo.Consorcio;
import modelo.Operador;


public class Test {

	public static void main(String[] args) {

		Consorcio consorcio = new Consorcio("0001","Consorcio");
		System.out.println("ID CONSORCIO " + consorcio.getIdConsorcio());

		Operador operador = new Operador("Facundo", "Girardi", "123456789", "facundo.girardi@gmail.com", "fgirardi", "1234");
		System.out.println("USUARIO OPERADOR " + operador.getUsuario());

	}

}
