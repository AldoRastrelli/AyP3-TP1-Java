package algo3.tp2.modelo.Boosts;

public abstract class Boost {

    Integer multiplicador;
    String nombre;

    public Integer usarBoost(Integer puntaje){
        return puntaje * multiplicador;
    }

    public String getNombre(){
        return nombre;
    }
}
