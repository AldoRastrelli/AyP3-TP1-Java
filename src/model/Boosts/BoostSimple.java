package model.Boosts;

public class BoostSimple extends Boost{

    public BoostSimple(){
        multiplicador = 1;
        nombre = "No Usar Boost";
        cantidadDeUsos = Integer.MAX_VALUE;
    }

    public boolean esBoostExclusivo() {
        return false;
    }

    public Boost reemplazaBoostSiNoEsExclusivo(){
        return new BoostExclusividad();
    };
}
