package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import model.Juego;
import model.Preguntas.Pregunta;

public class BotonComenzar implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {

        Juego juego = Sistema.juego();
        ControladorDeTurno controladorDeTurno = new ControladorDeTurno(juego, juego.getJugadores());

        Pregunta preguntaActual = juego.getPreguntas().remove(0);

        juego.guardarPreguntaActual(preguntaActual);
        VBox vista = Sistema.getVista(preguntaActual, controladorDeTurno);
        Scene scene = new Scene(vista);
        Sistema.setPrimaryStage(scene);
    }
}
