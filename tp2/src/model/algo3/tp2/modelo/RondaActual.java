package algo3.tp2.modelo;

import algo3.tp2.modelo.Boosts.Boost;
import algo3.tp2.modelo.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RondaActual {

    List<Jugador> jugadores;
    List<List<String>> respuestas;
    List<Integer> puntajes;
    List<Boost> boosts;
    boolean boostExclusividad;

    public RondaActual(){
        jugadores = new ArrayList<>();
        respuestas = new ArrayList<>();
        puntajes = new ArrayList<>();
        boosts = new ArrayList<>();
        boostExclusividad = false;
    }

    public void determinarPuntajePara(Pregunta preguntaActual){

        puntajes = preguntaActual.determinarPuntaje(respuestas);

        if (boostExclusividad & !verificaBoostExclusivo(puntajes,boosts)) {
            pasarPuntajesAJugadores();
            return;
        }
            usarBoosts(puntajes,boosts);

        pasarPuntajesAJugadores();

    }

    private boolean verificaBoostExclusivo(List<Integer> puntajes, List<Boost> boosts){

        var streamPuntajes = puntajes.stream();
        streamPuntajes.filter(p -> p>=1); // filtra a los jugadores que no hayan acertado

        return (streamPuntajes.count() == 1);

    }

    private List<Integer> usarBoosts(List<Integer> puntajes, List<Boost> boosts){

        List<Integer> nuevosPuntajes = new ArrayList<>();

        Iterator<Integer> itPuntajes = puntajes.iterator();
        Iterator<Boost> itBoosts = boosts.iterator();

        while (itPuntajes.hasNext() && itBoosts.hasNext()) {

            var boost = itBoosts.next();
            var puntaje = itPuntajes.next();

            nuevosPuntajes.add(boost.usarBoost(puntaje));
        }

        return nuevosPuntajes;
    }

    private void pasarPuntajesAJugadores(){

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).actualizarPuntaje(puntajes.get(i));
        }
    }

}
