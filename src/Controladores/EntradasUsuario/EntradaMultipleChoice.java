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
import java.util.List;
import java.util.stream.Collectors;


public class EntradaMultipleChoice extends EntradaUsuario{
    List<CheckBox> checkBoxes;

    public EntradaMultipleChoice(Pregunta pregunta, List<String> opciones) {
        super(pregunta,opciones);

        checkBoxes = new ArrayList<>();
        for (String opcion : opciones){
            CheckBox checkBox = new CheckBox(opcion);
            checkBoxes.add(checkBox);
        }

    }

    public List<CheckBox> getCheckBoxes(){
        return checkBoxes;
    }

    @Override
    public List<String> getRespuesta() {
        List<CheckBox> opcionesSeleccionadas = checkBoxes.stream().filter(checkBox -> checkBox.isSelected()).collect(Collectors.toList());
        opcionesSeleccionadas.stream().forEach(checkBox -> respuestaUsuario.add(checkBox.getText()));

        return respuestaUsuario;
    }

}
