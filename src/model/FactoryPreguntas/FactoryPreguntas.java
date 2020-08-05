package model.FactoryPreguntas;


import model.Comportamientos.ComportamientoClasico;
import model.Comportamientos.ComportamientoConPenalidad;
import model.Comportamientos.ComportamientoPuntajeParcial;
import model.Preguntas.Agrupar;
import model.Preguntas.MultipleChoice;
import model.Preguntas.Ordenar;
import model.Preguntas.VerdaderoOFalso;

import java.util.List;

public class FactoryPreguntas {

    public VerdaderoOFalso VerdaderoOFalsoClasico(String titulo, List<String> respuestaCorrecta){
        return new VerdaderoOFalso(titulo, respuestaCorrecta, new ComportamientoClasico());
    }

    public VerdaderoOFalso VerdaderoOFalsoConPenalidad(String titulo, List<String> respuestaCorrecta){
        return new VerdaderoOFalso(titulo, respuestaCorrecta, new ComportamientoConPenalidad());
    }

    public MultipleChoice MultipleChoiceClasico(String titulo, List<String> respuestaCorrecta){
        return new MultipleChoice(titulo, respuestaCorrecta, new ComportamientoClasico());
    }

    public MultipleChoice MultipleChoiceConPenalidad(String titulo, List<String> respuestaCorrecta){
        return new MultipleChoice(titulo, respuestaCorrecta, new ComportamientoConPenalidad());
    }

    public MultipleChoice MultipleChoicePuntajeParcial(String titulo, List<String> respuestaCorrecta){
        return new MultipleChoice(titulo, respuestaCorrecta, new ComportamientoPuntajeParcial());
    }

    public Ordenar Ordenar(String titulo, List<String> respuestaCorrecta){
        return new Ordenar(titulo, respuestaCorrecta, new ComportamientoClasico());
    }

    public Agrupar Agrupar(String titulo, List<String> respuestaCorrecta){
        return new Agrupar(titulo, respuestaCorrecta, new ComportamientoClasico());
    }



}
