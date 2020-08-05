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
        ContenedorPresentacionJugadores contenedorPresentaciones = new ContenedorPresentacionJugadores();
        Scene escenaPresentacion = new Scene(contenedorPresentaciones);

        contenedorEntrada.setBotonJugar(primaryStage,escenaPresentacion);
        contenedorPresentaciones.setBotonVolver(primaryStage, escenaBienvenidos);
        primaryStage.setScene(escenaBienvenidos);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}