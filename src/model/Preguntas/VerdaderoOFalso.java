package model.Preguntas;

import Controladores.ControladorDeTurno;
import Vistas.VistasPreguntas.VistaVerdaderoFalso;
import javafx.scene.layout.VBox;
import model.Comportamientos.Comportamiento;

import java.util.List;

public class VerdaderoOFalso extends Pregunta{

    public VerdaderoOFalso(String titulo, List<String> opciones, List<String> respuesta, Comportamiento comportamiento) {
        super(titulo, opciones, respuesta, comportamiento);
        tipo = "Verdadero o Falso";
    }


    public boolean esRespuestaCorrecta(List<String> respuesta){

        return respuesta.get(0).toUpperCase().equals(respuestaCorrecta.get(0).toUpperCase());
    }


    @Override
    public VBox getVista(Pregunta pregunta, ControladorDeTurno controladorDeTurno) {
        return new VistaVerdaderoFalso(pregunta, controladorDeTurno);
    }
}
