package Controladores.Botones;

import Controladores.ControladorDeTurno;

import Controladores.EntradasUsuario.EntradaUsuario;
import Controladores.Sistema;
import Vistas.VistaResultados;
import Vistas.VistasPreguntas.VistaPuntajes;
import Vistas.VistasPreguntas.VistaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import model.Boosts.BoostSimple;
import model.Jugador;
import model.Preguntas.Pregunta;
import model.RondaActual;

import java.util.List;
import java.util.Map;

public class BotonGuardarRespuesta implements EventHandler<ActionEvent> {

    ControladorDeTurno controladorDeTurno;
    EntradaUsuario entradaUsuario;

    public BotonGuardarRespuesta(ControladorDeTurno controladorDeTurno, EntradaUsuario entradaUsuario) {
        this.controladorDeTurno = controladorDeTurno;
        this.entradaUsuario = entradaUsuario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        var juego = Sistema.juego();
        var respuestaUsuario = entradaUsuario.getRespuesta();

        controladorDeTurno.guardarRespuesta(respuestaUsuario);
        controladorDeTurno.cambiarTurno();

        boolean finRonda = controladorDeTurno.finRonda();
        if (finRonda){

            for (Map.Entry<Jugador,List<String>> entry : controladorDeTurno.getRespuestas().entrySet()){
                juego.guardarRespuesta(entry.getKey(),entry.getValue(),entry.getKey().noUsarBoost());
            }
            juego.calcularPuntaje();
            VistaPuntajes vistaPuntajes = new VistaPuntajes(juego.getRondaActual(), controladorDeTurno);
            Scene scene = new Scene(vistaPuntajes);
            Sistema.setPrimaryStage(scene);
        }
        else{
            VBox vista = juego.getPreguntaActual().getVista(juego.getPreguntaActual(), controladorDeTurno);
            Scene scene = new Scene(vista);
            Sistema.setPrimaryStage(scene);
        }

    }
}
