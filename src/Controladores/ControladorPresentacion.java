package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Juego;

public class ControladorPresentacion implements EventHandler<ActionEvent> {

    Juego juego;

    public ControladorPresentacion(Juego juego) {

        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
