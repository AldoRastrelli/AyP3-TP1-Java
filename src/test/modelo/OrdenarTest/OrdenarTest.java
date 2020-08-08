package test.modelo.OrdenarTest;

import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Jugador;
import model.Preguntas.Ordenar;
import model.Preguntas.Pregunta;
import model.RondaActual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrdenarTest {

    @Test
    public void PreguntaOrdenarPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add("1930");
        respuestaCorrecta.add("1940");
        respuestaCorrecta.add("1950");
        respuestaCorrecta.add("1960");

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar("Ordenar de menor a mayor", respuestaCorrecta);

        assertTrue(pregunta.esRespuestaCorrecta(respuestaCorrecta));
    }

    @Test
    public void PreguntaOrdenarRecibeListaRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Victoria");
        juego.crearJugador("Gonzalo");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("1930"); add("1940"); add("1950"); add("1960");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("1940"); add("1930"); add("1960"); add("1950");}};

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar("Ordenar de menor a mayor", respuestaCorrecta);

        Map<String, List<String>> respuestas = new HashMap<String, List<String>>(){{
            put("Victoria",respuestaIncorrecta);
            put("Gonzalo",respuestaCorrecta);
        }};

        Map<String, Integer> puntajeEsperado = new HashMap<String, Integer>(){{
            put("Victoria",0);
            put("Gonzalo",1);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertEquals(puntajeObtenido, puntajeEsperado);
    }

    @Test
    public void JugadorUsaExclusividadYSeAplicaCorrectamente(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("1930"); add("1940"); add("1950"); add("1960");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("1940"); add("1930"); add("1960"); add("1950");}};

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar("Ordenar de menor a mayor", respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(2));
    }

    @Test
    public void JugadorUsaExclusividadNoVerificaCondicionesEntoncesNoSeAplica(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("1930"); add("1940"); add("1950"); add("1960");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("1940"); add("1930"); add("1960"); add("1950");}};

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar("Ordenar de menor a mayor", respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(1));
    }

    @Test
    public void JugadorUsaExclusividadSeEquivocaEntoncesSeAplicaAlOtroJugador(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("1930"); add("1940"); add("1950"); add("1960");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("1940"); add("1930"); add("1960"); add("1950");}};

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar("Ordenar de menor a mayor", respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaIncorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador2.getPuntos().equals(2) && jugador1.getPuntos().equals(0));
    }

    @Test
    public void JugadoresUsanExclusividadSeDuplicaYSeAplicaCorrectamente(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("1930"); add("1940"); add("1950"); add("1960");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("1940"); add("1930"); add("1960"); add("1950");}};

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Ordenar("Ordenar de menor a mayor", respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(4));
    }
}
