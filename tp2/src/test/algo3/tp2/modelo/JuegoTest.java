package algo3.tp2.modelo;

import algo3.tp2.modelo.FactoryPreguntas.FactoryPreguntas;
import algo3.tp2.modelo.Preguntas.Pregunta;
import algo3.tp2.modelo.Preguntas.VerdaderoOFalso;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JuegoTest {

    @Test
    public void JuegoCreaJugador1Correctamente(){
        var juego = new Juego();

        juego.crearJugador("Martina");
        Jugador jugador = juego.verJugador(1);

        assertEquals(jugador.getNombre(),"Martina");
    }

    @Test
    public void JuegoCreaJugador2Correctamente(){
        var juego = new Juego();

        juego.crearJugador("Martina");
        juego.crearJugador("Juan");
        Jugador jugador = juego.verJugador(2);

        assertEquals(jugador.getNombre(),"Juan");
    }
}