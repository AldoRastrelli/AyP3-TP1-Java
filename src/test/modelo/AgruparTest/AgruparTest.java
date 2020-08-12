package test.modelo.AgruparTest;

import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Jugador;
import model.Preguntas.Pregunta;
import model.RondaActual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AgruparTest {

    @Test
    public void PreguntaAgruparPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add("Pan");
        respuestaCorrecta.add("Hamburguesa");
        respuestaCorrecta.add("*");
        respuestaCorrecta.add("Agua");
        respuestaCorrecta.add("Coca-Cola");
        respuestaCorrecta.add("*");

        List<String> opciones = new ArrayList<>(){{
            add("Pan");
            add("Hamburguesa");
            add("Agua");
            add("Coca-Cola");
        }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Agrupar("Bebidas/Comidas",opciones,respuestaCorrecta);

        assertTrue((pregunta).esRespuestaCorrecta(respuestaCorrecta));
    }

    @Test
    public void PreguntaAgruparRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Marcos");
        juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Pan"); add("Hamburguesa"); add("*"); add("Agua"); add("Coca-Cola"); add("*");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Agua"); add("Hamburguesa"); add("*"); add("Pan"); add("Coca-Cola"); add("*"); }};
        List<String> opciones = new ArrayList<>(){{
            add("Pan");
            add("Hamburguesa");
            add("Agua");
            add("Coca-Cola");
        }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Agrupar("Bebidas/Comidas",opciones,respuestaCorrecta);

        Map<String, List<String>> respuestas = new HashMap<String, List<String>>(){{
            put("Marcos",respuestaIncorrecta);
            put("Evelyn",respuestaCorrecta);
        }};

        Map<String, Integer> puntajeEsperado = new HashMap<String, Integer>(){{
            put("Marcos",0);
            put("Evelyn",1);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertTrue(puntajeObtenido.equals(puntajeEsperado));

    }

    @Test
    public void JugadorUsaExclusividadYSeAplicaCorrectamente(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Pan"); add("Hamburguesa"); add("*"); add("Agua"); add("Coca-Cola"); add("*");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Agua"); add("Hamburguesa"); add("*"); add("Pan"); add("Coca-Cola"); add("*"); }};
        List<String> opciones = new ArrayList<>(){{
            add("Pan");
            add("Hamburguesa");
            add("Agua");
            add("Coca-Cola");
        }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Agrupar("Bebidas/Comidas",opciones,respuestaCorrecta);

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

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Pan"); add("Hamburguesa"); add("*"); add("Agua"); add("Coca-Cola"); add("*");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Agua"); add("Hamburguesa"); add("*"); add("Pan"); add("Coca-Cola"); add("*"); }};
        List<String> opciones = new ArrayList<>(){{
            add("Pan");
            add("Hamburguesa");
            add("Agua");
            add("Coca-Cola");
        }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Agrupar("Bebidas/Comidas",opciones,respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(0));
    }

    @Test
    public void JugadorUsaExclusividadSeEquivocaEntoncesSeAplicaAlOtroJugador(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Pan"); add("Hamburguesa"); add("*"); add("Agua"); add("Coca-Cola"); add("*");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Agua"); add("Hamburguesa"); add("*"); add("Pan"); add("Coca-Cola"); add("*"); }};
        List<String> opciones = new ArrayList<>(){{
            add("Pan");
            add("Hamburguesa");
            add("Agua");
            add("Coca-Cola");
        }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Agrupar("Bebidas/Comidas",opciones,respuestaCorrecta);

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

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Pan"); add("Hamburguesa"); add("*"); add("Agua"); add("Coca-Cola"); add("*");}};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Agua"); add("Hamburguesa"); add("*"); add("Pan"); add("Coca-Cola"); add("*"); }};
        List<String> opciones = new ArrayList<>(){{
            add("Pan");
            add("Hamburguesa");
            add("Agua");
            add("Coca-Cola");
        }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.Agrupar("Bebidas/Comidas",opciones,respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(4));
    }
}
