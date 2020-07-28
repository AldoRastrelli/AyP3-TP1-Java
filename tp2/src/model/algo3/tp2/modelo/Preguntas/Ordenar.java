package algo3.tp2.modelo.Preguntas;

import algo3.tp2.modelo.Comportamientos.Comportamiento;

import java.util.List;
import java.util.Map;

public class Ordenar extends Pregunta {
    public Ordenar(List<String> respuesta, Comportamiento comportamiento) {
        super(respuesta, comportamiento);
    }

    @Override
    public Map<String, Integer> determinarPuntaje(Map<String, List<String>> preguntas) {
        return null;
    }

    @Override
    public boolean esRespuestaCorrecta(List<String> respuesta) {
        return false;
    }

}
