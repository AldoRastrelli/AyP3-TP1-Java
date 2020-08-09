package Vistas.Contenedores;

import Controladores.Botones.*;
import Vistas.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.ArrayList;


public class ContenedorPregunta extends VBox {

    VBox contenedorCentral;
    static Pane centro;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static Canvas fondo;

    public ContenedorPregunta(Pregunta pregunta) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        this.setFondo();

        Label nombre1 = new Label("Nombre Jugador 1");
        nombre1.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        nombre1.setTextAlignment(TextAlignment.CENTER);
        nombre1.setTextFill(Color.web("000000"));

        Label nombre2 = new Label("Nombre Jugador 2");
        nombre2.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        nombre2.setTextAlignment(TextAlignment.CENTER);
        nombre2.setTextFill(Color.web("000000"));


        this.getChildren().addAll(nombre1, nombre2);
    }

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setFondo() {
        fondo = new Canvas(800, 800);
        fondo.getGraphicsContext2D().setFill(Color.WHITESMOKE);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
    }

}

