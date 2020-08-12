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

        String path = "/home/rochi/Desktop/AyP3-TP1-Java/src/Recursos/Sonidos/background.mp3";

        var juego = new Juego();

        var sistema = new Sistema(primaryStage,juego);
        //sistema.musicaFondo();


        primaryStage.setTitle("Cursando por un Sueño");
        primaryStage.getIcons().add(new Image("Recursos/Imagenes/logoFIUBA.png"));

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada(juego);
        Scene escenaBienvenidos = new Scene (contenedorEntrada);
        ContenedorPresentacionJugadores contenedorPresentacion = new ContenedorPresentacionJugadores();
        Scene escenaPresentacion = new Scene (contenedorPresentacion);

        contenedorPresentacion.setBotonVolver(primaryStage, escenaBienvenidos);
        contenedorEntrada.setBotonJugar(primaryStage, escenaPresentacion);
        primaryStage.setScene(escenaBienvenidos);

        //primaryStage.setWidth(700);
       // primaryStage.setHeight(700);
       // primaryStage.setResizable(false);
       primaryStage.sizeToScene();
        primaryStage.show();




    }

}