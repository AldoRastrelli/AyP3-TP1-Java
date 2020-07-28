package algo3.tp2.modelo.Preguntas;

import algo3.tp2.modelo.Comportamientos.Comportamiento;

import java.util.List;
import java.util.Map;

public abstract class Pregunta {

    protected List<String> opciones;
    protected List<String> respuestaCorrecta;
    protected Integer puntajeObtenido;
    protected Comportamiento comportamiento;

    public Pregunta(List<String> respuesta, Comportamiento comportamiento){
        respuestaCorrecta = respuesta;
        this.comportamiento = comportamiento;
    }

    private void agregarOpcion(String opcion){
        opciones.add(opcion);
    }

    public abstract Map<String,Integer> determinarPuntaje(Map<String, List<String>> preguntas);

    public abstract boolean esRespuestaCorrecta(List<String> respuesta);
}
