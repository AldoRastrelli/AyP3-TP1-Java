package Vistas.VistasPreguntas;

import Controladores.Botones.BotonVerResultados;
import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Vistas.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import model.Jugador;
import model.RondaActual;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VistaPuntajes extends VBox{

    static Pane centro;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static Canvas fondo;

    public VistaPuntajes(RondaActual rondaActual, ControladorDeTurno controladorDeTurno) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setFondo();

        Label titulo = new Label("PUNTAJES");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setTextFill(Color.web("black"));

        this.getChildren().addAll(titulo);

        Label jugadorPuntaje;

        String color = "black";
        List<Label>jugadores = new ArrayList<>();
        for (Map.Entry<String, Integer > entry : rondaActual.getPuntajes().entrySet()){
            color = entry.getValue() > 0 ? "green" : "red";

            jugadorPuntaje = new Label(entry.getKey()+ ": " + String.valueOf(entry.getValue()));
            jugadorPuntaje.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
            jugadorPuntaje.setTextAlignment(TextAlignment.LEFT);
            jugadorPuntaje.setTextFill(Color.web(color));
            jugadores.add(jugadorPuntaje);
        }
        jugadores.stream().forEach(j -> this.getChildren().addAll(j));

        BotonVerResultados verResultados = new BotonVerResultados();
        Boton botonVerResultados = new Boton("CONTINUAR", verResultados);

        this.getChildren().addAll(botonVerResultados);

        Boton botonMute = Sistema.getBotonMute();
        this.getChildren().addAll(botonMute);

    }

    public void setFondo() {
        fondo = new Canvas(800, 800);
        fondo.getGraphicsContext2D().setFill(Color.WHITESMOKE);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
    }

}

