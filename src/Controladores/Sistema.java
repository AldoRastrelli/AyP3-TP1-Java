package Controladores;

import Controladores.Botones.BotonMutear;
import Vistas.Boton;
import Vistas.VistasPreguntas.VistaAgrupar;
import Vistas.VistasPreguntas.VistaMultipleChoice;
import Vistas.VistasPreguntas.VistaOrdenar;
import Vistas.VistasPreguntas.VistaVerdaderoFalso;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Juego;
import model.Preguntas.Pregunta;

import java.io.File;

public class Sistema {

    static boolean mudo = false;
    static MediaPlayer musicaFondo;
    static Stage primaryStage;
    static Juego juego;

    public Sistema(Stage primaryStage, Juego juego) {
        this.primaryStage = primaryStage;
        this.juego = juego;
    }

    public static void musicaFondo() {
        String path = "C:\\Users\\Usuario\\IdeaProjects\\TP2\\AyP3-TP1-Java\\src\\Recursos\\Sonidos\\background.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.setAutoPlay(true);
        musicaFondo = mediaPlayer;
    }

    public static void musicaAplausos() {
        String path = "C:\\Users\\Usuario\\IdeaProjects\\TP2\\AyP3-TP1-Java\\src\\Recursos\\Sonidos\\applause.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.setAutoPlay(true);
        musicaFondo = mediaPlayer;
    }


    public static void frenarSonidos() {
        if(musicaFondo.getStatus().equals(MediaPlayer.Status.PLAYING)) musicaFondo.pause();
        else musicaFondo.play();
    }

    public static void mutear(){
        if (mudo) mudo = false;
        else mudo = true;
    }

    public static Boton getBotonMute(){
        javafx.scene.image.Image imagenMute = new Image("/Recursos/Imagenes/speaker.png", 20, 20, true, true);
        final ImageView imagenMuteVista = new ImageView(imagenMute);
        Boton botonMute = new Boton("", imagenMuteVista, new BotonMutear());
        return botonMute;
    }
    public static void setPrimaryStage(Scene scene) {
        Sistema.primaryStage.setScene(scene);
    }

    public static Juego juego(){
        return juego;
    }
    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    public static VBox getVista(Pregunta preguntaActual, ControladorDeTurno controladorDeTurno) {
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
        return vista;
    }

    public static void cortarMusica(){
        // fade out de la música
        Timeline timeline = new Timeline(
          new KeyFrame(Duration.seconds(3),
                  new KeyValue(musicaFondo.volumeProperty(),0))
        );
        timeline.play();
        timeline.setOnFinished(event -> frenarSonidos());

        mutear();
    }

}
