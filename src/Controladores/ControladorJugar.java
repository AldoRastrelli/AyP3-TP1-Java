package Controladores;

import Controladores.EntradaUsuario;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Juego;

import java.util.ArrayList;

public class ControladorJugar implements EventHandler<ActionEvent> {

    ArrayList<EntradaUsuario> entradaJugadores;
    Stage stage;
    Scene proximaEscena;
    Juego juego;

    public ControladorJugar(Stage stage, Scene proximaEscena, ArrayList<EntradaUsuario> entradaJugadores, Juego juego) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.entradaJugadores = entradaJugadores;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        entradaJugadores.stream().forEach(entrada -> juego.crearJugador(entrada.getNombre()));
        stage.setScene(proximaEscena);
    }
}
