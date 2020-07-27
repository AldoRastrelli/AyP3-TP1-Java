package algo3.tp2.modelo.Preguntas;

import algo3.tp2.modelo.Comportamientos.Comportamiento;

import java.util.ArrayList;
import java.util.List;

public abstract class Pregunta {

    protected List<String> opciones;
    protected List<String> respuestaCorrecta;
    private Integer puntajeObtenido;
    private Comportamiento comportamiento;

    public Pregunta(List<String> respuesta, Comportamiento comportamiento){
        respuestaCorrecta = respuesta;
        this.comportamiento = comportamiento;
    }

    private void agregarOpcion(String opcion){
        opciones.add(opcion);
    }

    public abstract List<Integer> determinarPuntaje(List<List<String>> respuestas);
}
