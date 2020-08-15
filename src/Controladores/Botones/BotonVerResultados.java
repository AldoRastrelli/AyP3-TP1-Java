package Controladores.Botones;

import Controladores.ControladorDeTurno;

import Controladores.EntradasUsuario.EntradaUsuario;
import Controladores.Sistema;
import Vistas.Boton;
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

        BotonComenzar botonComenzar = new BotonComenzar();
        Boton botonSiguiente = new Boton("FINALIZAR", botonComenzar);

        if(!juego.getCantPreguntas().equals(1))
            botonSiguiente = new Boton("SIGUIENTE PREGUNTA", botonComenzar);
        String titulo = "Total";
        VistaResultados vistaResultados = new VistaResultados(titulo, botonSiguiente, juego.getJugadores());
        Scene escenaResultados = new Scene(vistaResultados);
        Sistema.setPrimaryStage(escenaResultados);
        juego.descontarPregunta();
    }
}
