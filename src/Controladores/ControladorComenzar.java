package Controladores;

import Controladores.EntradaUsuario;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorComenzar implements EventHandler<ActionEvent> {

    ArrayList<EntradaUsuario> entradaJugadores;
    Stage stage;
    Scene proximaEscena;

    public ControladorComenzar(Stage stage, Scene proximaEscena, ArrayList<EntradaUsuario> entradaJugadores) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.entradaJugadores = entradaJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
    }
}
