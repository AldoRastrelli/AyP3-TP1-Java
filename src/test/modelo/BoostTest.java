package test.modelo;

import model.Exceptions.NoTieneBoostDisponibleException;
import model.FactoryPreguntas.FactoryPreguntas;
import model.Juego;
import model.Jugador;
import model.Preguntas.Pregunta;
import model.RondaActual;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BoostTest {

    Juego juego = new Juego();
    Jugador jugador1 = juego.crearJugador("Marcos");
    Jugador jugador2 = juego.crearJugador("Evelyn");
    RondaActual rondaActual = juego.crearRondaActual();

    List<String> respuestaCorrectaVoF = new ArrayList<String>() {{
        add("Verdadero");
    }};

    List<String> opcionesVoF = new ArrayList<>() {{
        add("Verdadero");
        add("Falso");
    }};
    FactoryPreguntas factory = new FactoryPreguntas();
    Pregunta preguntaVoFClasico = factory.VerdaderoOFalsoClasico("", opcionesVoF, respuestaCorrectaVoF);

    List<String> respuestaCorrectaMultipleChoiceClasico = new ArrayList<String>() {{
        add("Olas");
        add("Viento");
    }};

    List<String> opcionesMultipleChoiceClasico = new ArrayList<>() {{
        add("Olas");
        add("Viento");
        add("Frío");
        add("Mar");
    }};
    Pregunta preguntaMultipleChoiceClasico = factory.MultipleChoiceClasico("Las ___ y el ___", opcionesMultipleChoiceClasico, respuestaCorrectaMultipleChoiceClasico);

    List<String> respuestaCorrectaopcionesMultipleChoiceConPenalidad = new ArrayList<String>() {{
        add("Olas");
        add("Viento");
    }};
    List<String> opcionesMultipleChoiceConPenalidad = new ArrayList<>() {{
        add("Olas");
        add("Viento");
        add("Frío");
        add("Mar");
    }};
    Pregunta preguntaMultipleChoiceConPenalidad = factory.MultipleChoiceConPenalidad("Las ___ y el ___", opcionesMultipleChoiceConPenalidad, respuestaCorrectaopcionesMultipleChoiceConPenalidad);

    List<String> respuestaIncorrectaVoF = new ArrayList<String>() {{add("Falso");}};

    List<String> respuestaIncorrectaMultipleChoiceClasico = new ArrayList<String>() {{
        add("Olas");
        add("Mar");
        add("Frío");
    }};

    @Test
    public void SeUsaExclusividadYSeRestanConrrectamente() {

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrectaVoF, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(preguntaVoFClasico);

        juego.calcularPuntaje();

        //assertEquals(2, (int) jugador1.elegirBoostTriplicador().cantidadDeUsos);
        assertEquals(1, (int) jugador2.elegirBoostTriplicador().cantidadDeUsos);

    }

    @Test
    public void SeUsaTriplicadorYSeRestanConrrectamente() {

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        juego.calcularPuntaje();

        assertEquals(0, (int) jugador1.elegirBoostTriplicador().cantidadDeUsos);
        assertEquals(1, (int) jugador2.elegirBoostTriplicador().cantidadDeUsos);

    }

    @Test
    public void SeUsaDuplicadorYSeRestanConrrectamente() {

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        juego.calcularPuntaje();

        assertEquals(0, (int) jugador1.elegirBoostDuplicador().cantidadDeUsos);
        assertEquals(1, (int) jugador2.elegirBoostDuplicador().cantidadDeUsos);

    }

    @Test
    public void SeUsaTriplicadorCon0UsosYDaException() {

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        juego.calcularPuntaje();

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        Assertions.assertThrows(NoTieneBoostDisponibleException.class, () -> {
            juego.calcularPuntaje();;
        });

    }

    @Test
    public void SeUsaDuplicadorCon0UsosYDaException() {

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        juego.calcularPuntaje();

        /*
        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        juego.calcularPuntaje();

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostDuplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        Assertions.assertThrows(NoTieneBoostDisponibleException.class, () -> {
            juego.calcularPuntaje();;
        });
         */

    }

    @Test
    public void SeUsaExclusividadCon0UsosYDaException() {

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        juego.calcularPuntaje();

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        Assertions.assertThrows(NoTieneBoostDisponibleException.class, () -> {
            juego.calcularPuntaje();;
        });

    }

    @Test
    public void SeUsaExclusividadEnPrimerYSegundaPreguntaYCalculaBienPuntajes() {

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrectaVoF, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(preguntaVoFClasico);

        juego.calcularPuntaje();

        assertEquals(2, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaIncorrectaMultipleChoiceClasico, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceClasico.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceClasico);

        juego.calcularPuntaje();

        assertEquals(2, (int) jugador1.getPuntos());
        assertEquals(2, (int) jugador2.getPuntos());

        System.out.print(jugador2.elegirBoostExclusivo().cantidadDeUsos);

    }

    @Test
    public void SeUsaExclusividadDuplicadoEnPrimerPreguntaYSinDuplicarEnSegundaPreguntaYCalculaBienPuntajes() {

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrectaVoF, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(preguntaVoFClasico);

        juego.calcularPuntaje();

        assertEquals(4, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaIncorrectaMultipleChoiceClasico, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceClasico.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceClasico);

        juego.calcularPuntaje();

        assertEquals(4, (int) jugador1.getPuntos());
        assertEquals(2, (int) jugador2.getPuntos());
    }

    @Test
    public void SeUsaExclusividadDuplicadoEnPrimerPreguntaYEnLaSiguienteUnBoostDuplicadorYTriplicadorYCalculaBienPuntajes(){

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrectaVoF, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(preguntaVoFClasico);

        juego.calcularPuntaje();

        assertEquals(4, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.elegirBoostDuplicador());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        juego.calcularPuntaje();

        assertEquals(10, (int) jugador1.getPuntos());
        assertEquals(4, (int) jugador2.getPuntos());
    }

    @Test
    public void SeUsaExclusividadDuplicadoSinCumplirCondicionesEnPrimerPreguntaYEnLaSiguienteUnBoostDuplicadorYCalculaBien(){

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(preguntaVoFClasico);

        juego.calcularPuntaje();

        assertEquals(0, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador1.elegirBoostTriplicador());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceConPenalidad.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceConPenalidad);

        juego.calcularPuntaje();

        assertEquals(6, (int) jugador1.getPuntos());
        assertEquals(2, (int) jugador2.getPuntos());
    }

    @Test
    public void SeUsaExclusividadEnPrimerPreguntaEnLaSiguienteExclusividadYCalculaBien(){
        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaVoFClasico);

        juego.calcularPuntaje();

        assertEquals(0, (int) jugador1.getPuntos());
        assertEquals(0, (int) jugador2.getPuntos());

        rondaActual.guardarRespuesta(jugador1.getNombre(), respuestaIncorrectaMultipleChoiceClasico, jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), preguntaMultipleChoiceClasico.getRespuestaCorrecta(), jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaMultipleChoiceClasico);

        juego.calcularPuntaje();

        assertEquals(0, (int) jugador1.getPuntos());
        assertEquals(2, (int) jugador2.getPuntos());
    }

    @Test
    public void Jug1UsaExclusividadEnPrimeraPreguntaYLeQuedaUnUsoDisponibleYAJug2DosUsosDisponibles(){
        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrectaVoF, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaVoFClasico);

        juego.calcularPuntaje();

        assertEquals(1, (int) jugador1.elegirBoostExclusivo().getCantidadDeUsos());
        assertEquals(2, (int) jugador2.elegirBoostExclusivo().getCantidadDeUsos());
    }

    @Test
    public void Jug1UsaExclusividadEnPrimeraPreguntaJug2UsaExclusividadEnSegundaPreguntaYTodaviaTienenCadaUnoUnUsoDisponible(){
        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaVoFClasico.getRespuestaCorrecta(), jugador1.elegirBoostExclusivo());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrectaVoF, jugador2.noUsarBoost());

        juego.guardarPreguntaActual(preguntaVoFClasico);

        juego.calcularPuntaje();

        rondaActual.guardarRespuesta(jugador1.getNombre(), preguntaMultipleChoiceClasico.getRespuestaCorrecta(), jugador1.noUsarBoost());
        rondaActual.guardarRespuesta(jugador2.getNombre(), respuestaIncorrectaMultipleChoiceClasico, jugador2.elegirBoostExclusivo());

        juego.guardarPreguntaActual(preguntaMultipleChoiceClasico);

        juego.calcularPuntaje();

        assertEquals(1, (int) jugador1.elegirBoostExclusivo().getCantidadDeUsos());
        assertEquals(1, (int) jugador2.elegirBoostExclusivo().getCantidadDeUsos());
    }

}