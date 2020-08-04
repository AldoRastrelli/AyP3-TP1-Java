package test.modelo;

import model.Exceptions.NoTieneBoostDisponibleException;
import model.FactoryPreguntas.FactoryPreguntas;
import model.Jugador;
import model.Preguntas.Pregunta;
import model.RondaActual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JugadorTest {

    @Test(expected = NoTieneBoostDisponibleException.class)
    public void JugadorUsaBoostYSeDescuentaUnUsoTest(){

        var jugador1 = new Jugador("Martina");
        var jugador2 = new Jugador("Lautaro");

        Map<String,Jugador> jugadores = new HashMap<>(){{
            put("Martina",jugador1);
            put("Lautaro",jugador2);
        }};

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Verdadero"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Falso"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.VerdaderoOFalsoConPenalidad(respuestaCorrecta);

        var rondaActual = new RondaActual();

        rondaActual.guardarRespuesta(jugador1.getNombre(),respuestaCorrecta,jugador1.elegirBoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(),respuestaCorrecta,jugador2.noUsarBoost());
        rondaActual.determinarPuntaje(pregunta,jugadores);

        rondaActual.guardarRespuesta(jugador1.getNombre(),respuestaCorrecta,jugador1.elegirBoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(),respuestaCorrecta,jugador2.noUsarBoost());
        rondaActual.determinarPuntaje(pregunta,jugadores);

    }
}
