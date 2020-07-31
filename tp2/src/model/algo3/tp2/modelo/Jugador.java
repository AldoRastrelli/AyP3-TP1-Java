package algo3.tp2.modelo;

import algo3.tp2.modelo.Boosts.Boost;

import java.util.Map;

public class Jugador {

    private String nombre;
    private Integer puntos;
    private Map<Boost,Integer> boosts;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void actualizarPuntaje(Integer puntosNuevos) {

        this.puntos += puntosNuevos;
    }

    public void usarBoost(){ }

    public String getNombre(){
        return nombre;
    }




}
