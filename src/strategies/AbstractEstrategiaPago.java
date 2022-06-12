package strategies;

import java.util.ArrayList;

import modelo.Gasto;
import modelo.UnidadFuncional;

public abstract class AbstractEstrategiaPago {

    public Double calculoDeGastos(ArrayList<Gasto> gastos) {
       return 333.44;
    };

    public Double obtencionSaldo() {

    };

    public abstract Double divisionExpensa();
}
