package Controladores.EntradasUsuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Preguntas.Pregunta;

import java.util.List;


public class EntradaVerdaderoFalso extends EntradaUsuario{
    ComboBox comboBox;

    public EntradaVerdaderoFalso(Pregunta pregunta, List<String> opciones) {
        super(pregunta,opciones);

        ObservableList<String> options =
                FXCollections.observableArrayList();
        options.addAll(opciones);
        comboBox = new ComboBox(options);
    }

    public ComboBox getComboBox(){
        return comboBox;
    }

    @Override
    public List<String> getRespuesta() {
        respuestaUsuario.add((String) comboBox.getValue());
        return respuestaUsuario;
    }

}
