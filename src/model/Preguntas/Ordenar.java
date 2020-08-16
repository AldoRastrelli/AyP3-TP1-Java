package model.Preguntas;

import model.Comportamientos.Comportamiento;

import java.util.List;

public class Ordenar extends Pregunta {
    public Ordenar(String titulo, List<String> opciones, List<String> respuesta, Comportamiento comportamiento) {
        super(titulo, opciones, respuesta, comportamiento);
        tipo = "Ordenar";
    }

    @Override
    public boolean esRespuestaCorrecta(List<String> respuesta) {
        return respuesta.equals(this.respuestaCorrecta);
    }

}
