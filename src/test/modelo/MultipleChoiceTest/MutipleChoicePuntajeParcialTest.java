package test.modelo.MultipleChoiceTest;

import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Preguntas.MultipleChoice;
import model.Preguntas.Pregunta;
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
        Pregunta pregunta = factory.MultipleChoicePuntajeParcial("Ordenar de menor a mayor", opciones, respuestaCompleta);

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
}
