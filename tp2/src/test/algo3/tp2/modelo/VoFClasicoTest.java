package algo3.tp2.modelo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class VoFClasicoTest {

    @Test
    public void PreguntaVoFClasicoPuedeCrearseIndicandoRespuestaCorrectaTest(){
        Respuesta respuesta = new Respuesta();

        Pregunta pregunta = new Pregunta(respuesta);

        assertTrue(pregunta.compararRespuestaCon(respuesta));
    }
}
