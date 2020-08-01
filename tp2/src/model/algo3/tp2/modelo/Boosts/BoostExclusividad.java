package algo3.tp2.modelo.Boosts;

public class BoostExclusividad extends Boost{

    public BoostExclusividad(){
        multiplicador = 2;
        nombre = "Exclusividad";
    }

    public void duplicarExclusivo(){
        multiplicador *= 2;
    }
}
