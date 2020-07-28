package algo3.tp2.modelo.FactoryPreguntas;

import algo3.tp2.modelo.Comportamientos.ComportamientoClasico;
import algo3.tp2.modelo.Comportamientos.ComportamientoConPenalizacion;
import algo3.tp2.modelo.Comportamientos.ComportamientoPuntajeParcial;
import algo3.tp2.modelo.Preguntas.MultipleChoice;
import algo3.tp2.modelo.Preguntas.VerdaderoOFalso;

import java.util.List;

public class FactoryPreguntas {

    public VerdaderoOFalso VerdaderoOFalsoClasico(List<String> respuestaCorrecta){
        return new VerdaderoOFalso(respuestaCorrecta, new ComportamientoClasico());
    }

    public VerdaderoOFalso VerdaderoOFalsoConPenalidad(List<String> respuestaCorrecta){
        return new VerdaderoOFalso(respuestaCorrecta, new ComportamientoConPenalizacion());
    }

    public MultipleChoice MultipleChoiceClasico(List<String> respuestaCorrecta){
        return new MultipleChoice(respuestaCorrecta, new ComportamientoClasico());
    }

    public MultipleChoice MultipleChoicePuntajeParcial(List<String> respuestaCorrecta){
        return new MultipleChoice(respuestaCorrecta, new ComportamientoPuntajeParcial());
    }

}
