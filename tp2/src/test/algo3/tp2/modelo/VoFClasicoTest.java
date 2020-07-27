package algo3.tp2.modelo;

import algo3.tp2.modelo.FactoryPreguntas.FactoryPreguntas;
import algo3.tp2.modelo.Preguntas.Pregunta;
import algo3.tp2.modelo.Preguntas.VerdaderoOFalso;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class VoFClasicoTest {

    @Test
    public void PreguntaVoFClasicoPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add("Verdadero");

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.VerdaderoOFalsoClasico(respuestaCorrecta);

        assertTrue(((VerdaderoOFalso) pregunta).esRespuestaCorrecta(respuestaCorrecta));
    }
}
