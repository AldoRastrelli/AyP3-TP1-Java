package algo3.tp2.modelo;

import algo3.tp2.modelo.Boosts.BoostDuplicador;
import algo3.tp2.modelo.Boosts.BoostExclusividad;
import algo3.tp2.modelo.Exceptions.NoTieneBoostDisponibleException;
import algo3.tp2.modelo.FactoryPreguntas.FactoryPreguntas;
import algo3.tp2.modelo.Preguntas.Pregunta;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
