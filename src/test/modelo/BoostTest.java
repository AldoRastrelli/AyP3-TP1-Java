package test.modelo;

import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Jugador;
import model.Preguntas.Pregunta;
import model.RondaActual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoostTest {

    @Test
    public void SeDuplicaExclusividadEnPrimerPreguntaYEnSegundaElMultiplicadorEsDos() {

        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>() {{
            add("Verdadero");
        }};
        List<String> respuestaIncorrecta = new ArrayList<String>() {{
            add("Falso");
        }};
        List<String> opciones = new ArrayList<>() {{
            add("Verdadero");
            add("Falso");
        }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.VerdaderoOFalsoClasico("", opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(4, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());

        List<String> respuestaCorrecta2 = new ArrayList<String>() {{
            add("Olas");
            add("Viento");
        }};
        List<String> respuestaIncorrecta2 = new ArrayList<String>() {{
            add("Olas");
            add("Mar");
            add("Frío");
        }};
        List<String> opciones2 = new ArrayList<>() {{
            add("Olas");
            add("Viento");
            add("Frío");
            add("Mar");
        }};
        FactoryPreguntas factory2 = new FactoryPreguntas();
        Pregunta pregunta2 = factory.MultipleChoiceClasico("Las ___ y el ___", opciones2, respuestaCorrecta2);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaIncorrecta2, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta2, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta2);

        juego.calcularPuntaje();

        assertEquals(4, (int) jugador1.getPuntos());
        assertEquals(2, (int) jugador2.getPuntos());
    }
}