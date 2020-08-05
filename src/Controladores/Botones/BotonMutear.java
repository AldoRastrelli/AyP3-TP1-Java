package Controladores.Botones;

import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMutear implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        Sistema.frenarSonidos();
        Sistema.mutear();
    }


}


