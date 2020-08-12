package test.modelo.MultipleChoiceTest;

import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Jugador;
import model.Preguntas.MultipleChoice;
import model.Preguntas.Pregunta;
import model.RondaActual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MutipleChoicePuntajeParcialTest {

    @Test
    public void PreguntaMutipleChoicePuntajeParcialPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad("Las ___ y el ___",opciones, respuestaCorrecta);

        assertTrue(((MultipleChoice) pregunta).esRespuestaCorrecta(respuestaCorrecta));
    }

    @Test
    public void PreguntaMultipleChoicePuntajeParcialRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Marcos");
        juego.crearJugador("Evelyn");

        List<String> respuestaCompleta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncompleta = new ArrayList<String>(){{ add("Olas"); }};

        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");}};

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoicePuntajeParcial("Las ___ y el ___", opciones, respuestaCompleta);

        Map<String, List<String>> respuestas = new HashMap<String, List<String>>(){{
            put("Marcos",respuestaIncompleta);
            put("Evelyn",respuestaCompleta);
        }};

        Map<String, Integer> puntajeEsperado = new HashMap<String, Integer>(){{
            put("Marcos",1);
            put("Evelyn",2);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertEquals(puntajeEsperado, puntajeObtenido);

    }
    @Test
    public void JugadorUsaExclusividadYSeAplicaCorrectamente(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCompleta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncompleta = new ArrayList<String>(){{ add(""); }};

        List<String> opciones = respuestaCompleta;
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar("Ordenar de menor a mayor", opciones,respuestaCompleta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCompleta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncompleta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(2));
        assertTrue(jugador2.getPuntos().equals(0));
    }
}
