package modelo;

public class Factura {

    private Float valorExtraordinario;
    private Float valorOrdinario;
    private Double total;
    private boolean pagada;
    private String mes; 
    
    public Factura(Double total) {
        this.total = total;
    }

}
