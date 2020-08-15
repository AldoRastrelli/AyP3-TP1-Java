package Controladores.Botones;

import Controladores.ControladorDeTurno;

import Controladores.EntradasUsuario.EntradaUsuario;
import Controladores.Sistema;
import Vistas.Boton;
import Vistas.VistaFinal;
import Vistas.VistaResultados;
import Vistas.VistasPreguntas.VistaPuntajes;
import Vistas.VistasPreguntas.VistaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import model.Preguntas.Pregunta;
import model.RondaActual;

public class BotonVerResultados implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {

        var juego = Sistema.juego();

        BotonVolverAJugar botonVolverAJugar = new BotonVolverAJugar();
        Boton botonSiguiente = new Boton("FINALIZAR", botonVolverAJugar);
        VistaFinal vistaFinal = new VistaFinal("Final del Juego", botonSiguiente, juego.getJugadores());
        Scene escenaResultados = new Scene(vistaFinal);
        if(!juego.getCantPreguntas().equals(1)){
            BotonComenzar botonComenzar = new BotonComenzar();
            botonSiguiente = new Boton("SIGUIENTE PREGUNTA", botonComenzar);
            VistaResultados vistaResultados = new VistaResultados("Total", botonSiguiente, juego.getJugadores());
            escenaResultados = new Scene(vistaResultados);
        }

        Sistema.setPrimaryStage(escenaResultados);
        juego.descontarPregunta();
    }
}
