package Controladores.Botones;

import Controladores.Sistema;
import Vistas.Boton;
import Vistas.VistaFinal;
import Vistas.VistaResultados;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class BotonVerResultados implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {

        var juego = Sistema.juego();


        Boton botonSiguiente;
        Scene escenaResultados;

        if(juego.tienePreguntasDisponibles()){
            BotonComenzar botonComenzar = new BotonComenzar();
            botonSiguiente = new Boton("SIGUIENTE PREGUNTA", botonComenzar);
            VistaResultados vistaResultados = new VistaResultados("Total", botonSiguiente, juego.getJugadores());
            escenaResultados = new Scene(vistaResultados);
        }
        else {
            BotonVolverAJugar botonVolverAJugar = new BotonVolverAJugar();
            botonSiguiente = new Boton("VOLVER A JUGAR", botonVolverAJugar);
            Sistema.cortarMusica();
            VistaFinal vistaFinal = new VistaFinal("¡FIN DEL JUEGO!", botonSiguiente, juego.getJugadores());
            escenaResultados = new Scene(vistaFinal);
        }

        Sistema.setPrimaryStage(escenaResultados);
    }
}
