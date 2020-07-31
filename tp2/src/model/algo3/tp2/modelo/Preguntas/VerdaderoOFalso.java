package algo3.tp2.modelo.Preguntas;

import algo3.tp2.modelo.Comportamientos.Comportamiento;

import java.util.*;

public class VerdaderoOFalso extends Pregunta{

    public VerdaderoOFalso(List<String> respuesta, Comportamiento comportamiento) {
        super(respuesta, comportamiento);
    }


    public boolean esRespuestaCorrecta(List<String> respuesta){

        return respuesta.get(0).toUpperCase().equals(respuestaCorrecta.get(0).toUpperCase());
    }
}
