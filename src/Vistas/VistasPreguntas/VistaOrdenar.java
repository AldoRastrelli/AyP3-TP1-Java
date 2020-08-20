package Vistas.VistasPreguntas;

import Controladores.Botones.BotonGuardarRespuesta;
import Controladores.ControladorDeTurno;
import Controladores.EntradasUsuario.EntradaOrdenar;
import Controladores.EntradasUsuario.EntradaUsuario;
import Controladores.Sistema;
import Controladores.Timer;
import Vistas.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VistaOrdenar extends VistaPregunta{

    public VistaOrdenar(Pregunta pregunta, ControladorDeTurno controladorDeTurno) {
        super(pregunta,controladorDeTurno);

        Jugador jugador = controladorDeTurno.getactual();

        List<String> opcionesDesordenadas = pregunta.getOpciones();
        Collections.shuffle(opcionesDesordenadas);
        Label opciones = new Label(opcionesDesordenadas.toString());
        opciones.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        opciones.setTextAlignment(TextAlignment.CENTER);
        opciones.setTextFill(Color.web("black"));

        List<String> opcionesPregunta = pregunta.getOpciones();
        EntradaOrdenar entradaUsuario = new EntradaOrdenar(pregunta,opcionesPregunta,jugador);

        List<ComboBox> elementosHabilitados = new ArrayList<>();

        List<ComboBox> opcionesComboBox = entradaUsuario.getComboBoxes();
        for (ComboBox opcion : opcionesComboBox){
            final ComboBox cbx = opcion;
            elementosHabilitados.add(cbx);
        }

        // timer
        Timer timer = new Timer();
        Label timerLabel = timer.getLabel();
        timerLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        timerLabel.setTextAlignment(TextAlignment.LEFT);
        timerLabel.setTextFill(Color.web("red"));
        controladorDeTurno.setTimerComboBox(timer,25,elementosHabilitados);

        this.getChildren().add(0,timerLabel);
        this.getChildren().addAll(opciones);
        this.getChildren().addAll(elementosHabilitados);

        Label textoElegirBoost = new Label("Elija un Boost");
        textoElegirBoost.setFont(Font.font("Tahoma", 10));
        textoElegirBoost.setTextFill(Color.web("black"));
        final ComboBox comboBoxBoost = entradaUsuario.getBoosts();

        Boton botonGuardarRespuesta  = new Boton("Guardar Respuesta", new BotonGuardarRespuesta(controladorDeTurno,entradaUsuario));

        this.getChildren().addAll(textoElegirBoost, comboBoxBoost, botonGuardarRespuesta);

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

