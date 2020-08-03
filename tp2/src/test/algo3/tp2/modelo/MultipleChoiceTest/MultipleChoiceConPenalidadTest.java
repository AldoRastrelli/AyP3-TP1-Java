package algo3.tp2.modelo.MultipleChoiceTest;

import algo3.tp2.modelo.Boosts.BoostDuplicador;
import algo3.tp2.modelo.Boosts.BoostSimple;
import algo3.tp2.modelo.Boosts.BoostTriplicador;
import algo3.tp2.modelo.Exceptions.NoTieneBoostDisponibleException;
import algo3.tp2.modelo.FactoryPreguntas.FactoryPreguntas;
import algo3.tp2.modelo.Juego;
import algo3.tp2.modelo.Jugador;
import algo3.tp2.modelo.Preguntas.MultipleChoice;
import algo3.tp2.modelo.Preguntas.Pregunta;
import algo3.tp2.modelo.RondaActual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultipleChoiceConPenalidadTest {

    @Test
    public void PreguntaMutipleChoiceClasicoPuedeCrearseIndicandoRespuestaCorrectaTest() {

        List<String> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add("AM II");
        respuestaCorrecta.add("Álgebra II");
        respuestaCorrecta.add("Física I");

        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        assertTrue(((MultipleChoice) pregunta).esRespuestaCorrecta(respuestaCorrecta));
    }

    @Test
    public void PreguntaMultipleConPenalidadRecibeListRtasYAsignaCorrectamentePuntosAJugadoresTest(){

        var juego = new Juego();

        juego.crearJugador("Fernando");
        juego.crearJugador("Rosa");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        Map<String,List<String>> respuestas = new HashMap<String,List<String>>(){{
            put("Fernando",respuestaIncorrecta);
            put("Rosa",respuestaCorrecta);
        }};

        Map<String,Integer> puntajeEsperado = new HashMap<String,Integer>(){{
            put("Fernando",-1);
            put("Rosa",2);
        }};

        Map<String, Integer> puntajeObtenido = pregunta.determinarPuntaje(respuestas);

        assertEquals(puntajeEsperado, puntajeObtenido);

    }

    @Test
    public void PreguntaChoiceConPenalidadYJugadorUsaMultiplicadorPorDosDevuelvePuntajeDuplicado(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        RondaActual rondaActual = new RondaActual();
        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, new BoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, new BoostSimple());

        juego.guardarPreguntaActual(pregunta);
        juego.calcularPuntaje(rondaActual);

        Integer puntajeIncorrecto = -1;
        assertTrue( jugador1.getPuntos().equals((Integer) 4) && jugador2.getPuntos().equals(puntajeIncorrecto));

    }

    @Test(expected = NoTieneBoostDisponibleException.class)
    public void JugadorNoPuedeUsarMultiplicadorPorDosMasDeUnaVez(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        BoostDuplicador duplicador = new BoostDuplicador();
        BoostSimple simple = new BoostSimple();

        jugador1.usarBoost(duplicador.getNombre());

        RondaActual rondaActual = new RondaActual();
        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, duplicador);
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, simple);

        juego.guardarPreguntaActual(pregunta);
        juego.calcularPuntaje(rondaActual);

        jugador1.usarBoost(duplicador.getNombre());
    }

    @Test
    public void PreguntaChoiceConPenalidadYJugadorUsaMultiplicadorPorTresDevuelvePuntajeTriplicado(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        RondaActual rondaActual = new RondaActual();
        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, new BoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, new BoostSimple());

        juego.guardarPreguntaActual(pregunta);
        juego.calcularPuntaje(rondaActual);

        Integer puntajeIncorrecto = -1;
        assertTrue( jugador1.getPuntos().equals((Integer) 6) && jugador2.getPuntos().equals(puntajeIncorrecto));

    }

    @Test(expected = NoTieneBoostDisponibleException.class)
    public void JugadorNoPuedeUsarMultiplicadorPorTresMasDeUnaVez(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        BoostTriplicador triplicador = new BoostTriplicador();
        BoostSimple simple = new BoostSimple();

        jugador1.usarBoost(triplicador.getNombre());

        RondaActual rondaActual = new RondaActual();
        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, triplicador);
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, simple);

        juego.guardarPreguntaActual(pregunta);
        juego.calcularPuntaje(rondaActual);

        jugador1.usarBoost(triplicador.getNombre());
    }

    @Test
    public void DosJugadoresConRespuestasDistintasUsanBoostMultiplicadorYDevuelvePuntajeMultiplicado(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        RondaActual rondaActual = new RondaActual();
        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, new BoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, new BoostDuplicador());

        juego.guardarPreguntaActual(pregunta);
        juego.calcularPuntaje(rondaActual);

        assertTrue( jugador1.getPuntos().equals((Integer) 6) && jugador2.getPuntos().equals((Integer) (-2)));
    }

    @Test
    public void JugadorUsaMultiplicadorx2PeroRespuestaIncorrectaEntoncesPierde2Puntos(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        RondaActual rondaActual = new RondaActual();
        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaIncorrecta, new BoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, new BoostSimple());

        juego.guardarPreguntaActual(pregunta);
        juego.calcularPuntaje(rondaActual);

        assertTrue( jugador1.getPuntos().equals((Integer) (-2)));
    }

    @Test
    public void JugadorUsaMultiplicadorx3PeroRespuestaIncorrectaEntoncesPierde3Puntos(){
        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Marcos");
        Jugador jugador2 = juego.crearJugador("Evelyn");

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad(respuestaCorrecta);

        RondaActual rondaActual = new RondaActual();
        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaIncorrecta, new BoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, new BoostSimple());

        juego.guardarPreguntaActual(pregunta);
        juego.calcularPuntaje(rondaActual);

        assertTrue( jugador1.getPuntos().equals((Integer) (-3)));
    }
}
