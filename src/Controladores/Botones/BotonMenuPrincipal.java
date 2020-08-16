package Controladores.Botones;

import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMenuPrincipal implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonMenuPrincipal(Stage stage, Scene escenaAnterior) {
        this.stage = stage;
        this.proximaEscena = escenaAnterior;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
    }
}
