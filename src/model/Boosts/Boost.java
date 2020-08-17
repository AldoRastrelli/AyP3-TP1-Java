package model.Boosts;

import model.Exceptions.NoTieneBoostDisponibleException;

public abstract class Boost {

    Integer multiplicador;
    String nombre;
    Integer cantidadDeUsos;

    public Integer usarBoost(Integer puntaje){
        if (!puedeUsarse()){
            throw new NoTieneBoostDisponibleException();
        }
        restarUso();
        Integer puntos = puntaje * multiplicador;
        if (esBoostExclusivo()){reiniciarMultiplicidad();}

        return puntos;
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

    private void reiniciarMultiplicidad() {multiplicador = 2;}

    public void duplicarExclusivo(Integer veces){
        if(!this.esBoostExclusivo()){
            return;
        }
        multiplicador *= (2 * (veces-1));
    }
}
