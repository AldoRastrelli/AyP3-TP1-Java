package algo3.tp2.modelo;

import algo3.tp2.modelo.Boosts.Boost;
import algo3.tp2.modelo.Boosts.BoostDuplicador;
import algo3.tp2.modelo.Boosts.BoostExclusividad;
import algo3.tp2.modelo.Boosts.BoostTriplicador;
import algo3.tp2.modelo.Exceptions.NoTieneBoostDisponibleException;

import java.util.HashMap;
import java.util.Map;

public class Jugador {

    private String nombre;
    private Integer puntos;
    private Map<String,Integer> boosts;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
        boosts = new HashMap<String, Integer>();
        boosts.put("Duplicador",(Integer)1);
        boosts.put("Triplicador",(Integer)1);
        boosts.put("Exclusividad",(Integer)2);
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void actualizarPuntaje(Integer puntosNuevos) {

        this.puntos += puntosNuevos;
    }

    public void usarBoost(String boost){
        if(boosts.get(boost) < 1){
            throw new NoTieneBoostDisponibleException();
        }
        boosts.put(boost, boosts.get(boost) -1);
    }

    public String getNombre(){
        return nombre;
    }




}
