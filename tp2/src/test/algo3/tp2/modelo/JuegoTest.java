package algo3.tp2.modelo;

import algo3.tp2.modelo.FactoryPreguntas.FactoryPreguntas;
import algo3.tp2.modelo.Preguntas.Pregunta;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JuegoTest {

    @Test
    public void PreguntaVoFClasicoRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        List<String> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add("Verdadero");

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.VerdaderoOFalsoClasico(respuestaCorrecta);

        List<List<String>> respuestas = new ArrayList<>();

        for (int i = 0; i < 4; i++){
            List<String> respuestaIndividual = new ArrayList<>();

            if (i%2 == 0){
                respuestaIndividual.add("verdadero");
            }
            else{
                respuestaIndividual.add("falso");
            }
            respuestas.add(respuestaIndividual);
        }

        List<Integer> puntajesEsperados = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(0);
        }};

        List<Integer> puntajesObtenidos = pregunta.determinarPuntaje(respuestas);

        assertEquals(puntajesEsperados,puntajesObtenidos);

    }
}

