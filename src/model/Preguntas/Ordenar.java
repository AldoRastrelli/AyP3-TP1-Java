package model.Preguntas;

import model.Comportamientos.Comportamiento;

import java.util.List;

public class Ordenar extends Pregunta {
    public Ordenar(String titulo, List<String> respuesta, Comportamiento comportamiento) {
        super(titulo, respuesta, comportamiento);
    }

    @Override
    public boolean esRespuestaCorrecta(List<String> respuesta) {
        return respuesta.equals(this.respuestaCorrecta);
    }

}
