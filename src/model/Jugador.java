package model;

import model.Boosts.*;

import java.util.HashMap;
import java.util.Map;

public class Jugador {

    private String nombre;
    private Integer puntos;
    private Map<String,Boost> boosts;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
        boosts = new HashMap<String, Boost>();
        boosts.put("Duplicador",new BoostDuplicador());
        boosts.put("Triplicador",new BoostTriplicador());
        boosts.put("Exclusividad",new BoostExclusividad());
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void actualizarPuntaje(Integer puntosNuevos) {

        this.puntos += puntosNuevos;
    }

/*    public void usarBoost(Boost boost){
        if(!boost.puedeUsarse()){
            throw new NoTieneBoostDisponibleException();
        }
        boost.restarUso();
    }*/

    public String getNombre(){
        return nombre;
    }

    public Boost elegirBoostDuplicador(){
        return boosts.get("Duplicador");
    }

    public Boost elegirBoostTriplicador(){
        return boosts.get("Triplicador");
    }

    public Boost elegirBoostExclusivo(){
        return boosts.get("Exclusivo");
    }

    public Boost noUsarBoost(){
        return new BoostSimple();
    }


}
