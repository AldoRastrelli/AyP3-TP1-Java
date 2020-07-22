package algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    List<Jugador> jugadores;

    public Juego(){
        jugadores = new ArrayList<>();
    }

    public Jugador crearJugador(String nombre){
        var jugador = new Jugador(nombre);
        jugadores.add(jugador);

        return jugador;
    }

    public void compararRespuestas(List<Respuesta> respuestas, Pregunta pregunta){

        var puntajes = pregunta.compararRespuestaCon(respuestas);

        var size = respuestas.size();
        for (int i= 0 ; i < size; i++){
            var jugador = jugadores.get(i);
            var puntaje = puntajes.get(i);

            jugador.sumarPuntos(puntaje);
        }
    }

}
