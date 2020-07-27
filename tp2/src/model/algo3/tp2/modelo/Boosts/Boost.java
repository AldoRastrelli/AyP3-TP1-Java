package algo3.tp2.modelo.Boosts;

public class Boost {

    Integer multiplicador;

    public Integer usarBoost(Integer puntaje){
        return puntaje * multiplicador;
    }
}
