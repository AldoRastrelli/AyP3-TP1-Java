package Vistas;

//import Controladores.Sistema;
//import Modelo.Jugador;
import Controladores.Sistema;
import Vistas.Contenedores.ContenedorEntrada;
import Vistas.Contenedores.ContenedorPresentacionJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Juego;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        String path = "AyP3-TP1-Java\\src\\Recursos\\Sonidos\\background.mp3";

        var sistema = new Sistema();
        sistema.musicaFondo();
        var juego = new Juego();
        // TODO juego.inicializarPreguntas();

        primaryStage.setTitle("Cursando por un Sueño");
        primaryStage.getIcons().add(new Image("/Recursos/Imagenes/logoFIUBA.png"));

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada(juego);
        Scene escenaBienvenidos = new Scene (contenedorEntrada);
        contenedorEntrada.setBotonJugar(primaryStage);

        primaryStage.setScene(escenaBienvenidos);

        primaryStage.setResizable(false);
        primaryStage.show();




    }

}