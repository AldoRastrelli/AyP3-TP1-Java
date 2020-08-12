package Controladores.EntradasUsuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;


public abstract class EntradaUsuario {

    protected Pregunta pregunta;
    protected List<String> opciones;
    protected List<String> respuestaUsuario;

    public EntradaUsuario(Pregunta pregunta, List<String> opciones){
        this.pregunta = pregunta;
        this.opciones = opciones;
        respuestaUsuario = new ArrayList<>();
    }

    public abstract List<String> getRespuesta();
}
