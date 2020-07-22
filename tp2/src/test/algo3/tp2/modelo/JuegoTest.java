package algo3.tp2.modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JuegoTest {

    @Test
    public void PreguntaVoFClasicoRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();
        var jugador1 = juego.crearJugador("Matías");
        var jugador2 = juego.crearJugador("Andrea");

        Respuesta respuesta = new Respuesta("Olas");
        Pregunta pregunta = new Pregunta(respuesta);

        var respuesta1 = new Respuesta("Viento");
        var respuesta2 = new Respuesta("Olas");


        var respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        juego.compararRespuestas(respuestas,pregunta);

        assertTrue(jugador1.getPuntos().equals(0));
        assertTrue(jugador2.getPuntos().equals(1));

    }
}

