package Controladores.Botones;

import Controladores.ControladorPregunta;
import Controladores.EntradaUsuario;

import Vistas.Contenedores.ContenedorEntrada;
import Vistas.Contenedores.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Juego;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.ArrayList;

public class BotonComenzar implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    Juego juego;

    public BotonComenzar(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        for (Pregunta pregunta : juego.getPreguntas()){

            for (Jugador jugador : juego.getJugadores()){
                ContenedorPregunta contenedorPregunta = new ContenedorPregunta(pregunta);
                Scene escenaPregunta = new Scene(contenedorPregunta);

                this.stage = new Stage();
                stage.setResizable(false);
                stage.setScene(escenaPregunta);
                stage.show();
            }
        }
    }
}
