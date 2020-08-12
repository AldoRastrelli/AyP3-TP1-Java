package Controladores.EntradasUsuario;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class EntradaNombre {
    HBox hb;
    TextField tx;

    public EntradaNombre(String textoHover) {
        TextField texto = new TextField();
        texto.setPromptText(textoHover);
        texto.setPrefColumnCount(30);
        HBox hbox = new HBox(texto);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        hb = hbox;
        tx = texto;
    }

    public HBox getHb() {
        return hb;
    }

    public String getNombre() {
        return tx.getText();
    }
}
