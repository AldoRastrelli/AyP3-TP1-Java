package Vistas.Contenedores;

import Controladores.Botones.*;
import Controladores.Botones.BotonMenuPrincipal;
import Vistas.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Juego;
import model.Jugador;

import java.util.ArrayList;


public class ContenedorPresentacionJugadores extends VBox {

    VBox contenedorCentral;
    static Pane centro;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static Canvas fondo;
    BotonMenuPrincipal controladorBotonMenuPrincipal;
    BotonComenzar controladorBotonComenzar;
    Juego juego;

    public ContenedorPresentacionJugadores() {
        super();
        this.juego = juego;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        this.setFondo();
        Image decano = new Image(".\\Recursos\\Imagenes\\martinez.jpg",400,400,true,true);
        final ImageView decanoVista = new ImageView(decano);

        Label discurso = new Label("'Bienvenidos y bienvenidas.\nEl día de hoy, estos jóvenes estudiantes se disputarán el título de Ingeniero/a en Informática.\nQuiero agradecer al Departamento de Alumnos: sin su arduo trabajo, no podríamos estar aquí.\nLos recibimos entonces con un aplauso, y comenzamos con el evento.'");
        discurso.setFont(Font.font("Tahoma", 12));
        discurso.setTextAlignment(TextAlignment.CENTER);
        discurso.setTextFill(Color.web("000000"));

        controladorBotonComenzar = new BotonComenzar(juego);
        Boton botonComenzar = new Boton("COMENZAR", controladorBotonComenzar);

        Image imagenMute = new Image("/Recursos/Imagenes/speaker.png",20,20,true,true);
        final ImageView imagenMuteVista = new ImageView(imagenMute);
        Boton botonMute = new Boton("",imagenMuteVista,new BotonMutear());

        this.getChildren().addAll(decanoVista, discurso, botonComenzar, botonMute);
    }

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setFondo() {
        fondo = new Canvas(800,800);
        fondo.getGraphicsContext2D().setFill(Color.WHITESMOKE);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
    }

    public void setBotonVolver(Stage stage, Scene escenaAnterior){
        controladorBotonMenuPrincipal = new BotonMenuPrincipal(stage, escenaAnterior);

        Image imagenMute = new Image("/Recursos/Imagenes/house.png",20,20,true,true);
        final ImageView imagenMuteVista = new ImageView(imagenMute);

        Boton botonVolver = new Boton("MENÚ PRINCIPAL",imagenMuteVista, controladorBotonMenuPrincipal);
        this.getChildren().add(3, botonVolver);
    }

/*    public void setBotonComenzar(Stage stage, Scene escenaProxima){
        controladorBotonComenzar = new BotonComenzar();

        Boton botonComenzar = new Boton("COMENZAR", controladorBotonComenzar);
        this.getChildren().add(2, botonVolver);
    }*/

//    private void setLayout(){
//
//
//    }


/*    private void setContenedor() {
        contenedorCentral = new VBox(centro);
        contenedorCentral.setPadding(new Insets(25));
        contenedorCentral.setAlignment(Pos.CENTER);
        this.setCenter(contenedorCentral);

    }*/

    /*public static void setJugadores() {
        int y = 0;
        int x = 680;
        for (Map.Entry<String, Color> entrada : Sistema.dicColores.entrySet()) {
            Jugador jugador = new Jugador(entrada.getKey());
            jugador.asignarCasillero(Tablero.getInstancia().salida());
            jugadores.add(jugador);
            vistaJugadores.add(new VistaJugador(jugador, entrada.getValue(), centro, x, 355 + y));
            y += 20;
        }
        for (VistaJugador vj : vistaJugadores) {
            vj.dibujar();
        }
        ControladorDeTurno.getInstance();
        VistaJugador vjActual = VistaJugador.getPorNombre(ControladorDeTurno.getInstance().getJugadorActual().getNombre());
        visorActual = new Visor(vjActual, centro);

    }*/

/*    public static void actualizar() {
        visorActual.reset();
        VistaJugador vjActual = VistaJugador.getPorNombre(ControladorDeTurno.getInstance().getJugadorActual().getNombre());
        visorActual = new Visor(vjActual, centro);
    }*/
}
