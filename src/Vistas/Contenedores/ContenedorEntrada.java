package Vistas.Contenedores;

import Controladores.Botones.BotonMutear;
import Controladores.ControladorComenzar;
import Controladores.EntradaUsuario;
import Vistas.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorEntrada extends VBox {

    ArrayList<EntradaUsuario> jugadores = new ArrayList<>();
    ControladorComenzar cc;

    public ContenedorEntrada() {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        EntradaUsuario entrada1 = new EntradaUsuario("Jugador/Estudiante 1");
        EntradaUsuario entrada2 = new EntradaUsuario("Jugador/Estudiante 2");
        jugadores.add(entrada1);
        jugadores.add(entrada2);

        VBox vb = new VBox(entrada1.getHb(), entrada2.getHb());
        vb.setSpacing(30);

        Label titulo = new Label("CURSANDO POR UN SUEÑO");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setTextFill(Color.web("000000"));
        Label subtitulo = new Label("¿Podrás llegar al título?");
        subtitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        subtitulo.setTextAlignment(TextAlignment.CENTER);
        subtitulo.setTextFill(Color.web("000000"));

        Image imagen = new Image("/Recursos/Imagenes/logoFIUBA.png",250,250,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        Label story = new Label("Luego de muchos años de esfuerzo, están en el último cuatrimestre de Ingeniería en Informática. ¿Pero qué pasó?\nEl Departamento de Alumnos se equivocó y les dió el mismo padrón, ¡y ahora sólo uno puede recibirse!\nEl Decano decide entonces organizar un evento. Aquel que gane, se llevará el título de Ingeniero...");
        story.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        story.setTextAlignment(TextAlignment.CENTER);
        story.setTextFill(Color.web("000000"));

        Label label = new Label("Nombres de los jugadores:");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setTextFill(Color.web("blue"));

        Label disclaimer = new Label("Los personajes y hechos retratados en este juego son ligeramente ficticios.\nCualquier parecido con personas verdaderas o instituciones reales es puramente intencional.");
        disclaimer.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        disclaimer.setTextAlignment(TextAlignment.CENTER);
        disclaimer.setTextFill(Color.web("grey"));

//        Boton botonEntrar = new Boton("JUGAR", cc);

        Boton botonMutear = new Boton("Mutear", new BotonMutear());

        this.getChildren().addAll(titulo,subtitulo, imagenVista, story, label, vb, disclaimer, botonMutear);
    }

    public void setBotonJugar(Stage stage, Scene proximaEscena){
        cc = new ControladorComenzar(stage,proximaEscena, jugadores);
        Boton botonEntrar = new Boton("JUGAR", cc);
        this.getChildren().add(6, botonEntrar);
    }

}
