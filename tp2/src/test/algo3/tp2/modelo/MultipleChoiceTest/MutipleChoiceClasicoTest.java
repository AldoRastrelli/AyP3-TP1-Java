package algo3.tp2.modelo.MultipleChoiceTest;

import algo3.tp2.modelo.FactoryPreguntas.FactoryPreguntas;
import algo3.tp2.modelo.Juego;
import algo3.tp2.modelo.Preguntas.MultipleChoice;
import algo3.tp2.modelo.Preguntas.Pregunta;
import algo3.tp2.modelo.Preguntas.VerdaderoOFalso;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MutipleChoiceClasicoTest {

    @Test
    public void PreguntaMutipleChoiceClasicoPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add("Olas");
        respuestaCorrecta.add("Viento");
        respuestaCorrecta.add("Frio del mar");

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico(respuestaCorrecta);

        assertTrue(((MultipleChoice) pregunta).esRespuestaCorrecta(respuestaCorrecta));
    }

    @Test
    public void PreguntaMultipleClasicoRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Marcos");
        juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico(respuestaCorrecta);

        Map<String,List<String>> respuestas = new HashMap<String,List<String>>(){{
            put("Marcos",respuestaIncorrecta);
            put("Evelyn",respuestaCorrecta);
        }};

        Map<String,Integer> puntajeEsperado = new HashMap<String,Integer>(){{
            put("Marcos",0);
            put("Evelyn",1);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertEquals(puntajeEsperado, puntajeObtenido);

    }

}
