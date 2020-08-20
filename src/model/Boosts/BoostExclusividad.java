package model.Boosts;

public class BoostExclusividad extends Boost{

    public BoostExclusividad(){
        multiplicador = 2;
        nombre = "Exclusividad";
        cantidadDeUsos = 2;
    }

    public boolean esBoostExclusivo() {
        return true;
    }

    public Boost reemplazaBoostSiNoEsExclusivo(){
        return this;
    };
}
