package Controladores.Botones;

import Controladores.EntradasUsuario.EntradaNombre;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Juego;

import java.util.ArrayList;

public class BotonJugar implements EventHandler<ActionEvent> {

    ArrayList<EntradaNombre> entradaJugadores;
    Stage stage;
    Scene proximaEscena;
    Juego juego;

    public BotonJugar(Stage stage, Scene proximaEscena, ArrayList<EntradaNombre> entradaJugadores, Juego juego) {
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
