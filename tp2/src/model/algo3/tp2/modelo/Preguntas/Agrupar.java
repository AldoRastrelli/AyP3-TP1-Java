package algo3.tp2.modelo.Preguntas;

import algo3.tp2.modelo.Comportamientos.Comportamiento;

import java.util.ArrayList;
import java.util.List;

public class Agrupar extends Pregunta{
    public Agrupar(List<String> respuesta, Comportamiento comportamiento) {
        super(respuesta, comportamiento);
    }

    @Override
    public List<Integer> determinarPuntaje(List<List<String>> respuestas) {
        return null;
    }

}
