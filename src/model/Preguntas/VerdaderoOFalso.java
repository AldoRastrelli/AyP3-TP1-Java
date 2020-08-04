package model.Preguntas;

import model.Comportamientos.Comportamiento;

import java.util.List;

public class VerdaderoOFalso extends Pregunta{

    public VerdaderoOFalso(List<String> respuesta, Comportamiento comportamiento) {
        super(respuesta, comportamiento);
    }


    public boolean esRespuestaCorrecta(List<String> respuesta){

        return respuesta.get(0).toUpperCase().equals(respuestaCorrecta.get(0).toUpperCase());
    }
}
