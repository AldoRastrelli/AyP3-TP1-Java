package algo3.tp2.modelo.Boosts;

import algo3.tp2.modelo.Exceptions.NoTieneBoostDisponibleException;

public abstract class Boost {

    Integer multiplicador;
    String nombre;
    Integer cantidadDeUsos;

    public Integer usarBoost(Integer puntaje){
        if (!puedeUsarse()){
            throw new NoTieneBoostDisponibleException();
        }
        restarUso();
        return puntaje * multiplicador;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean puedeUsarse(){
        return cantidadDeUsos > 0;
    }

    public boolean esBoostExclusivo(){
        return nombre.equals("Exclusividad");
    }

    public void restarUso(){
        cantidadDeUsos -= 1;
    }
}
