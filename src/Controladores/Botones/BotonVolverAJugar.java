package Controladores.Botones;

import Controladores.Sistema;
import Vistas.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVolverAJugar implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {

        Main main = new Main();
        main.start(Sistema.getPrimaryStage());


    }
}
