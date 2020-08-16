package Vistas;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class Boton extends Button {

    public Boton (String texto, javafx.event.EventHandler<ActionEvent> controlador){
        setTexto(texto);
        setControlador(controlador);
    }

    public Boton (String texto, ImageView imagen, javafx.event.EventHandler<ActionEvent> controlador){
        setTexto(texto);
        setControlador(controlador);
        setImagen(imagen);
    }
    public void textoAlPasarMouse(String texto){
        setTooltip(new Tooltip(texto));
    }

    public void setTexto(String texto){
        setText(texto);
    }
    public void setControlador(javafx.event.EventHandler<ActionEvent> controlador) {
        setOnAction(controlador);
    }
    public void setImagen(ImageView imagen) {setGraphic(imagen);}
    
}
