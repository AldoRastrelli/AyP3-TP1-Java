package Vistas.Contenedores;

import Controladores.Botones.BotonComenzar;
import Controladores.Botones.BotonMenuPrincipal;
import Controladores.Sistema;
import Vistas.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.Jugador;

import java.util.ArrayList;


public class ContenedorPresentacionJugadores extends VBox {

    VBox contenedorCentral;
    static Pane centro;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static Canvas fondo;
    BotonMenuPrincipal controladorBotonMenuPrincipal;
    BotonComenzar controladorBotonComenzar;

    public ContenedorPresentacionJugadores() {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        this.setFondo();
        Image decano = new Image("/Recursos/Imagenes/martinez.jpg", 400, 400, true, true);
        final ImageView decanoVista = new ImageView(decano);

        Label discurso = new Label("'Bienvenidos y bienvenidas.\nEl día de hoy, estos jóvenes estudiantes se disputarán el título de Ingeniero/a en Informática.\nQuiero agradecer al Departamento de Alumnos: sin su arduo trabajo, no podríamos estar aquí.\nLos recibimos entonces con un aplauso, y comenzamos con el evento.'");
        discurso.setFont(Font.font("Tahoma", 14));
        discurso.setTextAlignment(TextAlignment.CENTER);
        discurso.setTextFill(Color.web("000000"));

        controladorBotonComenzar = new BotonComenzar();
        Boton botonComenzar = new Boton("COMENZAR", controladorBotonComenzar);

        this.getChildren().addAll(decanoVista, discurso, botonComenzar);

        Boton botonMute = Sistema.getBotonMute();
        this.getChildren().addAll(botonMute);
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