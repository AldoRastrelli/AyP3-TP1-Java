package model.Preguntas;

import model.Comportamientos.Comportamiento;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleChoice extends Pregunta{

    Integer valorPuntajeCorrecto = 1;

    public MultipleChoice(String titulo, List<String> opciones, List<String> respuesta, Comportamiento comportamiento) {
        super(titulo, opciones, respuesta, comportamiento);
    }

    @Override
    public Map<String, Integer> determinarPuntaje(Map<String, List<String>> respuestas) {

        var puntajes = new HashMap<String, Integer>();
        var jugadores = respuestas.keySet().stream();

        jugadores.forEach(
                j ->
                        puntajes.put(j, obtenerPuntaje(respuestas.get(j)))
        );

        return puntajes;
    }

    public Integer obtenerPuntaje(List<String> respuesta){

        if(esRespuestaCorrecta(respuesta)){return comportamiento.calcularPuntaje(respuesta.size(),0, true);}

        // calcula la cant de respuestas correctas e incorrectas para calcular su puntaje final

        Integer cantCorrectasPregunta = Math.toIntExact(respuestaCorrecta.stream().count());
        Integer cantRespuestasJugador = Math.toIntExact(respuesta.size());

        Integer respuestasCorrectasUsuario = Math.toIntExact(respuestaCorrecta.stream().filter(respuesta::contains).count());
        Integer respuestasIncorrectasUsuario = cantRespuestasJugador - respuestasCorrectasUsuario;

        return comportamiento.calcularPuntaje(respuestasCorrectasUsuario, respuestasIncorrectasUsuario, respuestasCorrectasUsuario.equals(cantCorrectasPregunta));
    }

    @Override
    // Verifica si es exactamente igual a la respuesta correcta
    public boolean esRespuestaCorrecta(List<String> respuesta) {
        Collections.sort(respuestaCorrecta);
        Collections.sort(respuesta);
        return respuesta.equals(respuestaCorrecta);
    }
}
