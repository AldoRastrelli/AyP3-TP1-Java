package model.Boosts;

public class BoostDuplicador extends Boost {

    public BoostDuplicador(){
        multiplicador = 2;
        nombre = "Duplicador";
        cantidadDeUsos = 1;
    }

    public boolean esBoostExclusivo() {
        return false;
    }

    public Boost reemplazaBoostSiNoEsExclusivo(){
        return new BoostExclusividad();
    };
}
