package model;

import model.Boosts.Boost;
import model.Preguntas.Pregunta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RondaActual {

    Map<String, List<String>> respuestas;
    Map<String, Integer> puntajes;
    Map<String,Boost> boosts;
    boolean boostExclusividad;

    public RondaActual(){
        respuestas = new HashMap<String, List<String>>();
        puntajes = new HashMap<String, Integer>();
        boosts = new HashMap<String,Boost>();
        /*boostExclusividad = false;*/
    }

    public void guardarRespuesta(String nombreJugador, List<String> respuesta, Boost boost){
        respuestas.put(nombreJugador,respuesta);
        boosts.put(nombreJugador,boost);
        puntajes.put(nombreJugador,0);
        if(boost.esBoostExclusivo()){
            boostExclusividad = true;
        }
    }

    public void determinarPuntaje(Pregunta preguntaActual, Map<String,Jugador> jugadores){

        puntajes = preguntaActual.determinarPuntaje(respuestas);

        if (seUsaBoostExclusividad() & !verificaBoostExclusivo()) {
            pasarPuntajes(jugadores);
            return;
        }
        usarBoosts();

        pasarPuntajes(jugadores);
        return;
    }

    private boolean seUsaBoostExclusividad(){

        return boostExclusividad;
    }

    private boolean verificaBoostExclusivo(){

        var cantPuntajesNoNulos = puntajes.entrySet().stream().filter(p-> p.getValue() != 0).count();

        return (cantPuntajesNoNulos == 1);

    }

    private void usarBoosts(){

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
