package model.Boosts;

public class BoostExclusividad extends Boost{

    public BoostExclusividad(){
        multiplicador = 2;
        nombre = "Exclusividad";
        cantidadDeUsos = 2;
    }

    public void duplicarExclusivo(){
        multiplicador *= 2;
    }
}
