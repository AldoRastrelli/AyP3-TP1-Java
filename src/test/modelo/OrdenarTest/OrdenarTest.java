package test.modelo.OrdenarTest;

import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Preguntas.Ordenar;
import model.Preguntas.Pregunta;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrdenarTest {

    @Test
    public void PreguntaOrdenarPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add("1930");
        respuestaCorrecta.add("1940");
        respuestaCorrecta.add("1950");
        respuestaCorrecta.add("1960");

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar(respuestaCorrecta);

        assertTrue(pregunta.esRespuestaCorrecta(respuestaCorrecta));
    }

    @Test
    public void PreguntaOrdenarRecibeListaRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Victoria");
        juego.crearJugador("Gonzalo");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("1930"); add("1940"); add("1950"); add("1960");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("1940"); add("1930"); add("1960"); add("1950");}};

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar(respuestaCorrecta);

        Map<String, List<String>> respuestas = new HashMap<String, List<String>>(){{
            put("Victoria",respuestaIncorrecta);
            put("Gonzalo",respuestaCorrecta);
        }};

        Map<String, Integer> puntajeEsperado = new HashMap<String, Integer>(){{
            put("Victoria",0);
            put("Gonzalo",1);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertEquals(puntajeObtenido, puntajeEsperado);
    }

}
