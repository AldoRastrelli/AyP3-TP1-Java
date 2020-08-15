package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Vistas.Boton;
import Vistas.VistaResultados;
import Vistas.VistaResultados;
import Vistas.VistasPreguntas.VistaAgrupar;
import Vistas.VistasPreguntas.VistaMultipleChoice;
import Vistas.VistasPreguntas.VistaOrdenar;
import Vistas.VistasPreguntas.VistaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Juego;
import model.Preguntas.Pregunta;

public class BotonComenzar implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {

        Juego juego = Sistema.juego();
        ControladorDeTurno controladorDeTurno = new ControladorDeTurno(juego, juego.getJugadores());

        Pregunta preguntaActual = juego.getPreguntaActual();

        try {
            preguntaActual = juego.getPreguntas().remove(0);
        }
        catch (Exception exception){
            var jugadores = juego.getJugadores();
            BotonVolverAJugar volverAJugar = new BotonVolverAJugar();
            Boton botonVolverAJugar = new Boton("Volver a jugar",volverAJugar);
            VistaResultados vistaResultados = new VistaResultados("FIN DEL JUEGO",botonVolverAJugar,jugadores);
        }

        juego.guardarPreguntaActual(preguntaActual);
        //VBox vista = preguntaActual.getVista(preguntaActual, controladorDeTurno);
        VBox vista = new VBox();

        switch (preguntaActual.getTipoGenerico()) {
            case "Agrupar":
                vista = new VistaAgrupar(preguntaActual, controladorDeTurno);
                break;
            case "Multiple Choice":
                vista = new VistaMultipleChoice(preguntaActual, controladorDeTurno);
                break;
            case "Ordenar":
                vista = new VistaOrdenar(preguntaActual, controladorDeTurno);
                break;
            case "Verdadero o Falso":
                vista = new VistaVerdaderoFalso(preguntaActual, controladorDeTurno);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + preguntaActual.getTipoGenerico());
        }
        Scene scene = new Scene(vista);
        Sistema.setPrimaryStage(scene);
    }
}
