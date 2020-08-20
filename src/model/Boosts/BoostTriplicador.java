package model.Boosts;

public class BoostTriplicador extends Boost {

    public BoostTriplicador(){
        multiplicador = 3;
        nombre = "Triplicador";
        cantidadDeUsos = 1;
    }

    public boolean esBoostExclusivo() {
        return false;
    }

    public Boost reemplazaBoostSiNoEsExclusivo(){
        return new BoostExclusividad();
    };
}
