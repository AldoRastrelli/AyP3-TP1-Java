package Vistas;

import Controladores.Botones.*;
import Controladores.ControladorDeTurno;
import Controladores.EntradasUsuario.EntradaVerdaderoFalso;
import Vistas.Boton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import model.Jugador;
import model.Preguntas.Pregunta;
import model.RondaActual;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VistaResultados extends VBox{

    static Pane centro;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static Canvas fondo;

    public VistaResultados(String tituloVista,Boton boton,List<Jugador> jugadores) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setFondo();

        Label titulo = new Label(tituloVista);
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setTextFill(Color.web("black"));

        this.getChildren().addAll(titulo);

        Label jugadorPuntaje;

        String color = "black";
        for (Jugador jugador : jugadores){
            color = jugador.getPuntos() > 0 ? "green" : "red";

            jugadorPuntaje = new Label(jugador.getNombre()+": "+jugador.getPuntos());
            jugadorPuntaje.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
            jugadorPuntaje.setTextAlignment(TextAlignment.LEFT);
            jugadorPuntaje.setTextFill(Color.web(color));
            this.getChildren().addAll(jugadorPuntaje);
        }

        this.getChildren().addAll(boton);

    }

    public void setFondo() {
        fondo = new Canvas(800, 800);
        fondo.getGraphicsContext2D().setFill(Color.WHITESMOKE);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
    }

}

