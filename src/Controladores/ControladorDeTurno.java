package Controladores;

import javafx.scene.Scene;
import model.Juego;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class ControladorDeTurno {

    private static ControladorDeTurno controlador;
    private Jugador actual;
    private static Juego juego;
    private List<Jugador> jugadores;
    private Map<Jugador,List<String>> respuestas;

    public ControladorDeTurno(Juego juego, List<Jugador> unosJugadores){

        jugadores = unosJugadores;
        actual = elegirPrimerJugador();
        respuestas = new HashMap<>();
        this.juego = juego;

    }

    public void guardarRespuesta(List<String> respuesta){
        respuestas.put(actual,respuesta);
    }


    private Jugador elegirPrimerJugador() {

        return jugadores.get(0);
    }

    public Jugador getactual(){
        return actual;
    }

    public Map<Jugador,List<String>> getRespuestas(){
        return respuestas;
    }

    public void cambiarTurno(){
        this.actual = siguienteJugador(this.actual);
    }

    private Jugador siguienteJugador(Jugador actual) {
        if (jugadores.indexOf(actual) == jugadores.size()-1){
            return elegirPrimerJugador();
        }
        return jugadores.get(jugadores.indexOf(this.actual)+1);
    }

    public void terminarTurno(){
        controlador.cambiarTurno();
    }

    public Juego getJuego(){
        return this.juego;
    }

    public boolean finRonda(){
        return actual == jugadores.get(0);
    }
}