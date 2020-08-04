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

    public VerdaderoOFalso VerdaderoOFalsoClasico(List<String> respuestaCorrecta){
        return new VerdaderoOFalso(respuestaCorrecta, new ComportamientoClasico());
    }

    public VerdaderoOFalso VerdaderoOFalsoConPenalidad(List<String> respuestaCorrecta){
        return new VerdaderoOFalso(respuestaCorrecta, new ComportamientoConPenalidad());
    }

    public MultipleChoice MultipleChoiceClasico(List<String> respuestaCorrecta){
        return new MultipleChoice(respuestaCorrecta, new ComportamientoClasico());
    }

    public MultipleChoice MultipleChoiceConPenalidad(List<String> respuestaCorrecta){
        return new MultipleChoice(respuestaCorrecta, new ComportamientoConPenalidad());
    }

    public MultipleChoice MultipleChoicePuntajeParcial(List<String> respuestaCorrecta){
        return new MultipleChoice(respuestaCorrecta, new ComportamientoPuntajeParcial());
    }

    public Ordenar Ordenar(List<String> respuestaCorrecta){
        return new Ordenar(respuestaCorrecta, new ComportamientoClasico());
    }

    public Agrupar Agrupar(List<String> respuestaCorrecta){
        return new Agrupar(respuestaCorrecta, new ComportamientoClasico());
    }



}
