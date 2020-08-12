package Vistas.VistasPreguntas;

import Controladores.Botones.*;
import Controladores.ControladorDeTurno;
import Controladores.EntradasUsuario.EntradaMultipleChoice;
import Controladores.EntradasUsuario.EntradaUsuario;
import Controladores.EntradasUsuario.EntradaVerdaderoFalso;
import Controladores.Sistema;
import Vistas.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VistaMultipleChoice extends VBox{

    static Pane centro;
    static Canvas fondo;

    public VistaMultipleChoice(Pregunta pregunta, ControladorDeTurno controladorDeTurno) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setFondo();

        Label nombreJugador = new Label("Turno: "+controladorDeTurno.getactual().getNombre());
        nombreJugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        nombreJugador.setTextAlignment(TextAlignment.CENTER);
        nombreJugador.setTextFill(Color.web("blue"));
        nombreJugador.setStyle("-fx-border-color: blue;");
        nombreJugador.setPadding(new Insets(5));

        Label tipo = new Label(pregunta.getTipo());
        tipo.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        tipo.setTextAlignment(TextAlignment.CENTER);
        tipo.setTextFill(Color.web("grey"));

        Label titulo = new Label(pregunta.getPregunta());
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setTextFill(Color.web("black"));

        this.getChildren().addAll(nombreJugador,tipo,titulo);

        List<String> opcionesPregunta = pregunta.getOpciones();
        EntradaMultipleChoice entradaUsuario = new EntradaMultipleChoice(pregunta,opcionesPregunta);

        List<CheckBox> opcionesCheckBox = entradaUsuario.getCheckBoxes();
        Collections.shuffle(opcionesCheckBox);
        for (CheckBox checkBox : opcionesCheckBox){
            final CheckBox cbx = checkBox;
            this.getChildren().addAll(cbx);
        }

        Boton botonGuardarRespuesta  = new Boton("Guardar Respuesta", new BotonGuardarRespuesta(controladorDeTurno,entradaUsuario));

        this.getChildren().addAll(botonGuardarRespuesta);

        Boton botonMute = Sistema.getBotonMute();
        this.getChildren().addAll(botonMute);
    }

    public void setFondo() {
        fondo = new Canvas(800, 800);
        fondo.getGraphicsContext2D().setFill(Color.WHITESMOKE);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
    }

    public void setBotonGuardarRespuesta(ControladorDeTurno controladorDeTurno, EntradaUsuario entradaUsuario){

        Boton botonGuardarRespuesta  = new Boton("Guardar Respuesta", new BotonGuardarRespuesta(controladorDeTurno,entradaUsuario));
        this.getChildren().add(4, botonGuardarRespuesta);
    }

}

