package algo3.tp2.modelo.FactoryPreguntas;

import algo3.tp2.modelo.Comportamientos.ComportamientoClasico;
import algo3.tp2.modelo.Preguntas.VerdaderoOFalso;

import java.util.List;

public class FactoryPreguntas {

    public VerdaderoOFalso VerdaderoOFalsoClasico(List<String> respuestaCorrecta){
        return new VerdaderoOFalso(respuestaCorrecta, new ComportamientoClasico());
    }
}
