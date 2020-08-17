package model.Preguntas;

import model.Comportamientos.Comportamiento;

import java.util.List;

public class VerdaderoOFalso extends Pregunta{

    public VerdaderoOFalso(String titulo, List<String> opciones, List<String> respuesta, Comportamiento comportamiento) {
        super(titulo, opciones, respuesta, comportamiento);
        tipo = "Verdadero o Falso";
    }


    public boolean esRespuestaCorrecta(List<String> respuesta){

        return respuesta.equals(respuestaCorrecta);
    }
}
