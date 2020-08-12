package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Vistas.Main;
import Vistas.VistaResultados;
import Vistas.VistaResultados;
import Vistas.VistasPreguntas.VistaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Juego;
import model.Preguntas.Pregunta;

public class BotonVolverAJugar implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {

        Main main = new Main();
        main.start(Sistema.getPrimaryStage());
    }
}
