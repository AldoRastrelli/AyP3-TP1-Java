package model.FactoryPreguntas;


import model.Comportamientos.ComportamientoClasico;
import model.Comportamientos.ComportamientoConPenalidad;
import model.Comportamientos.ComportamientoPuntajeParcial;
import model.Preguntas.*;

import java.util.List;

public class FactoryPreguntas {

    public Pregunta crear(String tipo, String comportamiento, String titulo, List<String> opciones, List<String> respuestaCorrecta){

        switch(tipo) {
            case "VerdaderoFalso":
                switch(comportamiento) {
                    case "clasico":
                        return VerdaderoOFalsoClasico(titulo, opciones,respuestaCorrecta);
                    case "conPenalidad":
                        return VerdaderoOFalsoConPenalidad(titulo, opciones,respuestaCorrecta);
                }
            case "MultipleChoice":
                switch(comportamiento) {
                    case "clasico":
                        return MultipleChoiceClasico(titulo, opciones,respuestaCorrecta);
                    case "conPenalidad":
                        return MultipleChoiceConPenalidad(titulo, opciones,respuestaCorrecta);
                    case "puntajeParcial":
                        return MultipleChoicePuntajeParcial(titulo, opciones,respuestaCorrecta);
                }
            case "Ordenar":
                return Ordenar(titulo, opciones,respuestaCorrecta);
            case "Agrupar":
                return Agrupar(titulo, opciones,respuestaCorrecta);
        }

        return null;
    }

    public VerdaderoOFalso VerdaderoOFalsoClasico(String titulo, List<String> opciones, List<String> respuestaCorrecta){
        return new VerdaderoOFalso(titulo, opciones, respuestaCorrecta, new ComportamientoClasico());
    }

    public VerdaderoOFalso VerdaderoOFalsoConPenalidad(String titulo, List<String> opciones,List<String> respuestaCorrecta){
        return new VerdaderoOFalso(titulo, opciones, respuestaCorrecta, new ComportamientoConPenalidad());
    }

    public MultipleChoice MultipleChoiceClasico(String titulo, List<String> opciones,List<String> respuestaCorrecta){
        return new MultipleChoice(titulo, opciones, respuestaCorrecta, new ComportamientoClasico());
    }

    public MultipleChoice MultipleChoiceConPenalidad(String titulo, List<String> opciones,List<String> respuestaCorrecta){
        return new MultipleChoice(titulo, opciones,respuestaCorrecta, new ComportamientoConPenalidad());
    }

    public MultipleChoice MultipleChoicePuntajeParcial(String titulo, List<String> opciones,List<String> respuestaCorrecta){
        return new MultipleChoice(titulo, opciones,respuestaCorrecta, new ComportamientoPuntajeParcial());
    }

    public Ordenar Ordenar(String titulo, List<String> opciones,List<String> respuestaCorrecta){
        return new Ordenar(titulo, opciones,respuestaCorrecta, new ComportamientoClasico());
    }

    public Agrupar Agrupar(String titulo, List<String> opciones,List<String> respuestaCorrecta){
        return new Agrupar(titulo, opciones,respuestaCorrecta, new ComportamientoClasico());
    }



}
