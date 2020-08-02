package algo3.tp2.modelo.MultipleChoiceTest;

import algo3.tp2.modelo.FactoryPreguntas.FactoryPreguntas;
import algo3.tp2.modelo.Juego;
import algo3.tp2.modelo.Preguntas.MultipleChoice;
import algo3.tp2.modelo.Preguntas.Pregunta;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultipleChoiceConPenalidadTest {

    @Test
    public void PreguntaMutipleChoiceClasicoPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add("AM II");
        respuestaCorrecta.add("Álgebra II");
        respuestaCorrecta.add("Física I");

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        assertTrue(((MultipleChoice) pregunta).esRespuestaCorrecta(respuestaCorrecta));
    }

    @Test
    public void PreguntaMultipleConPenalidadRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Fernando");
        juego.crearJugador("Rosa");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        Map<String,List<String>> respuestas = new HashMap<String,List<String>>(){{
            put("Fernando",respuestaIncorrecta);
            put("Rosa",respuestaCorrecta);
        }};

        Map<String,Integer> puntajeEsperado = new HashMap<String,Integer>(){{
            put("Fernando",-1);
            put("Rosa",2);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertEquals(puntajeEsperado, puntajeObtenido);

    }
}
