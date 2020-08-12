package Controladores.EntradasUsuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class EntradaOrdenar extends EntradaUsuario{
    List<ComboBox> comboBoxes;

    public EntradaOrdenar(Pregunta pregunta, List<String> opciones) {
        super(pregunta,opciones);

        comboBoxes = new ArrayList<>();
        Collections.shuffle(opciones);
        for(String opcion : opciones){
            ObservableList<String> options =
                    FXCollections.observableArrayList();
            options.addAll(opciones);
            comboBoxes.add(new ComboBox(options));
        }
    }

    public List<ComboBox> getComboBoxes(){
        return comboBoxes;
    }

    @Override
    public List<String> getRespuesta() {

        comboBoxes.stream().forEach(comboBox -> respuestaUsuario.add((String)comboBox.getValue()));

        return respuestaUsuario;
    }

}
