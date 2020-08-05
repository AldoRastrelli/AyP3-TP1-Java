package Vistas;

//import Controladores.Sistema;
//import Modelo.Jugador;
import Controladores.Sistema;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Juego;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        String path = "AyP3-TP1-Java\\src\\Recursos\\Sonidos\\background.mp3";

        var sistema = new Sistema();
        sistema.musicaFondo();

        primaryStage.setTitle("Cursando por un Sueño");
        primaryStage.getIcons().add(new Image("/Recursos/Imagenes/logoFIUBA.png"));

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada();
        Scene escenaBienvenidos = new Scene (contenedorEntrada);
//        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal();
//        Scene escenaJuego = new Scene(contenedorPrincipal);
//
//        contenedorEntrada.setBotonJugar(primaryStage,escenaJuego);
        primaryStage.setScene(escenaBienvenidos);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}