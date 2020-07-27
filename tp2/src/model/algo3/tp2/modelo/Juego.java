package algo3.tp2.modelo;

import algo3.tp2.modelo.Boosts.Boost;
import algo3.tp2.modelo.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    List<Jugador> jugadores;
    List<Pregunta> preguntas;
    Jugador jugadorActual;
    Pregunta preguntaActual;
    RondaActual jugadasActuales;
    List<Boost> boosters;

    public Juego(){

        jugadores = new ArrayList<>();
        preguntas = new ArrayList<>();
        jugadasActuales = new RondaActual();
        boosters = new ArrayList<>();
    }

    public void iniciarJuego(){

    }

    public Jugador crearJugador(String nombre){
        var jugador = new Jugador(nombre);
        jugadores.add(jugador);

        return jugador;
    }

    public void calcularPuntaje(RondaActual rondaActual){


    }


}
