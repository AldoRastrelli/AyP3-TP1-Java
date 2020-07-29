package algo3.tp2.modelo;

import algo3.tp2.modelo.FactoryPreguntas.FactoryPreguntas;
import algo3.tp2.modelo.Preguntas.Pregunta;
import algo3.tp2.modelo.Preguntas.VerdaderoOFalso;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultipleChoiceAsignaPuntaje {

    @Test
    public void PreguntaMultipleChoicePuntajeParcialRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Marcos");
        juego.crearJugador("Evelyn");

        List<String> respuestaCompleta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncompleta = new ArrayList<String>(){{ add("Olas"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoicePuntajeParcial(respuestaCompleta);

        Map<String,List<String>> respuestas = new HashMap<String,List<String>>(){{
            put("Marcos",respuestaIncompleta);
            put("Evelyn",respuestaCompleta);
        }};

        Map<String,Integer> puntajeEsperado = new HashMap<String,Integer>(){{
            put("Marcos",1);
            put("Evelyn",2);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertTrue((puntajeEsperado.get("Marcos")).equals(puntajeObtenido.get("Marcos")) &&
                (puntajeEsperado.get("Evelyn")).equals(puntajeObtenido.get("Evelyn")));

    }

}