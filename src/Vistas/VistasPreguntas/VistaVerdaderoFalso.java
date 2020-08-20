package Vistas.VistasPreguntas;

import Controladores.Botones.BotonGuardarRespuesta;
import Controladores.ControladorDeTurno;
import Controladores.EntradasUsuario.EntradaUsuario;
import Controladores.EntradasUsuario.EntradaVerdaderoFalso;
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
import java.util.List;


public class VistaVerdaderoFalso extends VistaPregunta{

    public VistaVerdaderoFalso(Pregunta pregunta, ControladorDeTurno controladorDeTurno) {
        super(pregunta,controladorDeTurno);

        Jugador jugador = controladorDeTurno.getactual();

        List<String> opciones  = pregunta.getOpciones();
        EntradaVerdaderoFalso entradaUsuario = new EntradaVerdaderoFalso(pregunta, opciones,jugador);
        final ComboBox comboBox = entradaUsuario.getComboBox();

        Label textoElegirBoost = new Label("Elija un Boost");
        textoElegirBoost.setFont(Font.font("Tahoma", 10));
        textoElegirBoost.setTextFill(Color.web("black"));
        final ComboBox comboBoxBoost = entradaUsuario.getBoosts();

        // timer
        Timer timer = new Timer();
        Label timerLabel = timer.getLabel();
        timerLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        timerLabel.setTextAlignment(TextAlignment.LEFT);
        timerLabel.setTextFill(Color.web("red"));
        List<ComboBox> elementosHabilitados = new ArrayList<>() {{ add(comboBox);}};
        controladorDeTurno.setTimerComboBox(timer,15,elementosHabilitados);

        this.getChildren().add(0,timerLabel);
        Boton botonGuardarRespuesta  = new Boton("Guardar Respuesta", new BotonGuardarRespuesta(controladorDeTurno,entradaUsuario));
        this.getChildren().addAll(comboBox, textoElegirBoost, comboBoxBoost, botonGuardarRespuesta);

        Boton botonMute = Sistema.getBotonMute();
        this.getChildren().addAll(botonMute);
    }


}

