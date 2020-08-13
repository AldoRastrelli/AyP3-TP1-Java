package test.modelo.MultipleChoiceTest;

import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Jugador;
import model.Preguntas.MultipleChoice;
import model.Preguntas.Pregunta;
import model.RondaActual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MutipleChoiceClasicoTest {

    @Test
    public void PreguntaMutipleChoiceClasicoPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);


        assertTrue(((MultipleChoice) pregunta).esRespuestaCorrecta(respuestaCorrecta));
    }

    @Test
    public void PreguntaMultipleClasicoRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Marcos");
        juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);


        Map<String, List<String>> respuestas = new HashMap<String, List<String>>(){{
            put("Marcos",respuestaIncorrecta);
            put("Evelyn",respuestaCorrecta);
        }};

        Map<String, Integer> puntajeEsperado = new HashMap<String, Integer>(){{
            put("Marcos",0);
            put("Evelyn",1);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertEquals(puntajeEsperado, puntajeObtenido);

    }

    @Test
    public void JugadorEligeRespuestasDeMasYNoLeAsignaPuntos(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); add ("Frío"); add ("Mar"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(1, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());
    }

    @Test
    public void JugadorEligeRespuestasIncompletaYNoLeAsignaPuntos(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas");add("Viento");}};
        List<String> respuestaIncompleta = new ArrayList<String>(){{ add("Olas");}};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncompleta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(1, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());
    }

    @Test
    public void JugadorEligeRespuestasVaciaYNoLeAsignaPuntos(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas");add("Viento");}};
        List<String> respuestaIncompleta = new ArrayList<String>(){};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncompleta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(1, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());
    }

    @Test
    public void JugadorUsaExclusividadYSeAplicaCorrectamente(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(2, (int) jugador1.getPuntos());
    }

    @Test
    public void JugadorUsaExclusividadNoVerificaCondicionesEntoncesNoSeAplica(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador2.getPuntos().equals(0) && jugador1.getPuntos().equals(0));
    }

    @Test
    public void JugadorUsaExclusividadSeEquivocaEntoncesSeAplicaAlOtroJugador(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

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

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(4) && jugador2.getPuntos().equals(0));
    }

    @Test
    public void JugadoresUsanExclusividadSeDuplicaYNoVerificaCondiciones(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(0) && jugador2.getPuntos().equals(0));
    }

}
