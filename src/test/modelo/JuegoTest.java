package test.modelo;

import model.Juego;
import model.Jugador;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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