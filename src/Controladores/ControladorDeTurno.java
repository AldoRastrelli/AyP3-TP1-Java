package Controladores;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import model.Boosts.Boost;
import model.Juego;
import model.Jugador;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ControladorDeTurno {

    private static ControladorDeTurno controlador;
    private Jugador actual;
    private static Juego juego;
    private List<Jugador> jugadores;
    private Map<Jugador,List<String>> respuestas;
    private Map<String, Boost> boostUsado;

    public ControladorDeTurno(Juego juego, List<Jugador> unosJugadores){

        jugadores = unosJugadores;
        actual = elegirPrimerJugador();
        respuestas = new HashMap<>();
        this.juego = juego;
        boostUsado = new HashMap<>();

    }

    public void guardarRespuesta(List<String> respuesta, Boost boost){
        respuestas.put(actual,respuesta);
        boostUsado.put(actual.getNombre(),boost);
    }


    private Jugador elegirPrimerJugador() {

        return jugadores.get(0);
    }

    public Jugador getactual(){
        return actual;
    }

    public Map<Jugador,List<String>> getRespuestas(){
        return respuestas;
    }

    public void cambiarTurno(){
        this.actual = siguienteJugador(this.actual);
    }

    private Jugador siguienteJugador(Jugador actual) {
        if (jugadores.indexOf(actual) == jugadores.size()-1){
            return elegirPrimerJugador();
        }
        return jugadores.get(jugadores.indexOf(this.actual)+1);
    }

//    public void terminarTurno(){
//        controlador.cambiarTurno();
//    }

    public Juego getJuego(){
        return this.juego;
    }

    public boolean finRonda(){
        return actual == jugadores.get(0);
    }

    public Boost getBoostUsado(String nombreJugador){
        return boostUsado.get(nombreJugador);
    }

    public Timeline setTimer(Timer timer, int duracion){

        var label = timer.getLabel();
        label.setText(String.valueOf(duracion));

        Timeline timeline = new Timeline();
        for(int i = duracion; i >=0 ; i--){
            int finalI = i;
            timeline.getKeyFrames().addAll(new KeyFrame(Duration.seconds(duracion-finalI), event -> {
                label.setText(String.valueOf(finalI));
            }));
        }

        return timeline;
    }

    public void setTimerComboBox(Timer timer, int duracion, List<ComboBox> elementosHabilitados){
        var timeline = setTimer(timer,duracion);
        timeline.play();
        timeline.setOnFinished(evento -> deshabilitarComboBox(elementosHabilitados));
    }

    public void deshabilitarComboBox(List<ComboBox> elementos){
        elementos.stream().forEach(e -> e.setDisable(true));
    }

    public void setTimerGrid(Timer timer, int duracion, List<GridPane> elementosHabilitados){

        var timeline = setTimer(timer,duracion);
        timeline.play();
        timeline.setOnFinished(evento -> deshabilitarGrid(elementosHabilitados));
    }

    public void deshabilitarGrid(List<GridPane> elementos){
        elementos.stream().forEach(e -> e.setDisable(true));
    }

    public void setTimerCheckbox(Timer timer, int duracion, List<CheckBox> elementosHabilitados){

        var timeline = setTimer(timer,duracion);
        timeline.play();
        timeline.setOnFinished(evento -> deshabilitarCheckbox(elementosHabilitados));
    }

    public void deshabilitarCheckbox(List<CheckBox> elementos){
        elementos.stream().forEach(e -> e.setDisable(true));
    }



}