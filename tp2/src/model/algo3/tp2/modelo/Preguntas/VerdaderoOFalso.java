package algo3.tp2.modelo.Preguntas;

import algo3.tp2.modelo.Boosts.Boost;
import algo3.tp2.modelo.Comportamientos.Comportamiento;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VerdaderoOFalso extends Pregunta{

    Integer puntajeCorrecto = 1;

    public VerdaderoOFalso(List<String> respuesta, Comportamiento comportamiento) {
        super(respuesta, comportamiento);
    }

    public List<Integer> determinarPuntaje(List<List<String>> respuestas) {

        List<Integer> puntajes = new ArrayList<>();
        var itRespuestas = respuestas.iterator();

        while (itRespuestas.hasNext()) {

            var respuesta = itRespuestas.next();

            puntajes.add(esRespuestaCorrecta(respuesta) ? puntajeCorrecto : 0);
        }
        return puntajes;
    }

    public boolean esRespuestaCorrecta(List<String> respuesta){

        return respuesta.get(0).toUpperCase().equals(respuestaCorrecta.get(0).toUpperCase());
    }
}
