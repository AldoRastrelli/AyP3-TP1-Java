package Controladores;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.scene.control.Label;

public class Timer {

    Label label;
    private Integer contador;

    public Timer(){
        contador = 0;
        label = new Label(String.valueOf(contador.toString()));
    }

    public Integer getContador(){
        return contador;
    }

    public Label getLabel(){
        return label;
    }
}
