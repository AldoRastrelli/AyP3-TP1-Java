package Controladores;

import Controladores.EntradaUsuario;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Juego;

import java.util.ArrayList;

public class ControladorPresentacion implements EventHandler<ActionEvent> {

    Juego juego;

    public ControladorPresentacion(Juego juego) {

        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
