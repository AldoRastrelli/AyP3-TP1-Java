package algo3.tp2.modelo;

import algo3.tp2.modelo.Boosts.Boost;
import algo3.tp2.modelo.Boosts.BoostExclusividad;
import algo3.tp2.modelo.Preguntas.Pregunta;

import java.util.*;

public class RondaActual {

    Map<String, List<String>> respuestas;
    Map<String,Integer> puntajes;
    Map<String,Boost> boosts;
    boolean boostExclusividad;

    public RondaActual(){
        respuestas = new HashMap<String, List<String>>();
        puntajes = new HashMap<String,Integer>();
        boosts = new HashMap<String,Boost>();
        /*boostExclusividad = false;*/
    }

    public void determinarPuntaje(Pregunta preguntaActual, Map<String,Jugador> jugadores){

        puntajes = preguntaActual.determinarPuntaje(respuestas);

        if (seUsaBoostExclusividad(boosts) & !verificaBoostExclusivo(puntajes)) {
            pasarPuntajes(jugadores);
            return;
        }
        usarBoosts(puntajes,boosts);

        pasarPuntajes(jugadores);
        return;
    }

    private boolean seUsaBoostExclusividad(Map<String,Boost> boosts){

        return boosts.containsValue(new BoostExclusividad());
    }

    private boolean verificaBoostExclusivo( Map<String,Integer> puntajes){

        var cantPuntajesNoNulos = puntajes.entrySet().stream().filter(p-> p.getValue() != 0).count();

        return (cantPuntajesNoNulos == 1);

    }

    private void usarBoosts(Map<String,Integer> puntajes, Map<String,Boost> boosts){

        var jugadores = puntajes.keySet().stream();

        jugadores.forEach( j->
                puntajes.put
                    ( j , boosts.get(j).usarBoost(puntajes.get(j) )
                )
        );

    }

    private void pasarPuntajes(Map<String,Jugador> jugadores){

        var puntajes = this.puntajes.keySet().stream();

        puntajes.forEach(jugador ->
                jugadores.get(jugador).actualizarPuntaje( this.puntajes.get(jugador) )
                );
    }
}
