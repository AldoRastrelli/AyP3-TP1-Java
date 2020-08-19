package test.modelo;

import model.Exceptions.NoTieneBoostDisponibleException;
import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Jugador;
import model.Preguntas.MultipleChoice;
import model.Preguntas.Pregunta;
import model.RondaActual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegracionTest {

    @Test
    public void JugadoresUsanBoostsEnPreguntasDeTodosLosTiposYSeAsignanLosPuntajesCorrectos(){

        var juego = new Juego();

        Jugador jugador1 = juego.crearJugador("Fernando");
        Jugador jugador2 = juego.crearJugador("Rosa");
        RondaActual rondaActual = juego.crearRondaActual();

        List<String> respuestaCorrecta = new ArrayList<String>(){{ add("Olas"); add("Viento"); }};
        List<String> respuestaIncorrecta = new ArrayList<String>(){{ add("Olas"); add("Mar"); add ("Frío"); }};
        List<String> opciones = new ArrayList<>(){{add("Olas");add("Viento");add("Frío");add("Mar");}};
        FactoryPreguntas factory = new FactoryPreguntas();
        Pregunta pregunta = factory.MultipleChoiceConPenalidad("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(2, (int) jugador1.getPuntos());
        assertEquals(-1, (int) jugador2.getPuntos());

        pregunta = factory.MultipleChoiceConPenalidad("Las ___ y el ___",opciones, respuestaCorrecta);

        juego.guardarPreguntaActual(pregunta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.calcularPuntaje();

        Integer puntajeIncorrecto = -2;
        assertTrue( jugador1.getPuntos().equals((Integer) 6) && jugador2.getPuntos().equals(puntajeIncorrecto));

        pregunta = factory.MultipleChoiceConPenalidad("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.elegirBoostDuplicador());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue( jugador1.getPuntos().equals((Integer) (8)));
        assertTrue( jugador2.getPuntos().equals((Integer) (-4)));

        pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador1.getPuntos().equals(8) && jugador2.getPuntos().equals(-4));

        pregunta = factory.MultipleChoiceClasico("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaIncorrecta, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaCorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertTrue(jugador2.getPuntos().equals(-2) && jugador1.getPuntos().equals(8));

        pregunta = factory.MultipleChoicePuntajeParcial("Las ___ y el ___",opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(10, (int) jugador1.getPuntos());
        assertEquals(-2, (int) jugador2.getPuntos());

        pregunta = factory.Ordenar("Ordenar de menor a mayor", opciones, respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(11, (int) jugador1.getPuntos());
        assertEquals(-2, (int) jugador2.getPuntos());


        List<String> opc = new ArrayList<>() {{
            add("Pan");
            add("Hamburguesa");
            add("Agua");
            add("Coca-Cola");
        }};
        List<String> rtaCorrecta = new ArrayList<String>() {{
            add("Pan");
            add("Hamburguesa");
            add("*");
            add("Agua");
            add("Coca-Cola");
            add("*");
        }};
        List<String> rtaIncorrecta = new ArrayList<String>(){{add("*");add("*");}};
        pregunta = factory.Agrupar("Bebidas/Comidas", opc, rtaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), rtaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), rtaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(12, (int) jugador1.getPuntos());
        assertEquals(-2, (int) jugador2.getPuntos());

        pregunta = factory.VerdaderoOFalsoConPenalidad("",opciones,respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.elegirBoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        puntajeIncorrecto = -3;
        assertTrue( jugador1.getPuntos().equals((Integer) 15) && jugador2.getPuntos().equals(puntajeIncorrecto));

        respuestaCorrecta = new ArrayList<String>(){{ add("Verdadero"); }};
        respuestaIncorrecta = new ArrayList<String>(){{ add("Falso"); }};
        opciones = new ArrayList<>(){{add("Verdadero");add("Falso");}};

        pregunta = factory.VerdaderoOFalsoConPenalidad("",opciones,respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        puntajeIncorrecto = -4;
        assertTrue( jugador1.getPuntos().equals((Integer) 16) && jugador2.getPuntos().equals(puntajeIncorrecto));

        pregunta = factory.VerdaderoOFalsoClasico("",opciones,respuestaCorrecta);

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaCorrecta, jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrecta, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(pregunta);

        juego.calcularPuntaje();

        assertEquals(17, (int) jugador1.getPuntos());
        assertEquals(-4, (int) jugador2.getPuntos());
    }
}
