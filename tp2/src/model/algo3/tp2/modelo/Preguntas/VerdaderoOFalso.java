package algo3.tp2.modelo.Preguntas;

import algo3.tp2.modelo.Comportamientos.Comportamiento;

import java.util.*;

public class VerdaderoOFalso extends Pregunta{

    public VerdaderoOFalso(List<String> respuesta, Comportamiento comportamiento) {
        super(respuesta, comportamiento);
    }

    public Map<String, Integer> determinarPuntaje( Map<String,List<String>> respuestas) {

        var puntajes = new HashMap<String,Integer>();
        var jugadores = respuestas.keySet().stream();

        jugadores.forEach(j->
                puntajes.put
                        (j,
                            esRespuestaCorrecta(respuestas.get(j)) ?
                                comportamiento.calcularPuntaje(1,0) :
                                    comportamiento.calcularPuntaje(0,1))

        );

        return puntajes;
    }

    public boolean esRespuestaCorrecta(List<String> respuesta){

        return respuesta.get(0).toUpperCase().equals(respuestaCorrecta.get(0).toUpperCase());
    }
}
