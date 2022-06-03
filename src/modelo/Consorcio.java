package modelo;

public class Consorcio {

    private String nombreConsorcio;
    private UnidadFuncional[] unidadesFuncionales;
    private Gasto[] gasto;
    private String operador;

    public Consorcio(String nombreConsorcio) {
        this.nombreConsorcio = nombreConsorcio;
    }

    public String getNombreConsorcio() {
        return nombreConsorcio;
    }

}
