package Controladores;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static javafx.scene.input.KeyCode.R;

public class Sistema {

    static boolean mudo = false;
    static MediaPlayer musicaFondo;

    public Sistema() {
    }

    public static void musicaFondo() {
        String path = "AyP3-TP1-Java\\src\\Recursos\\Sonidos\\background.mp3";
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
        if (mudo == true) mudo=false;
        else if (mudo == false) mudo=true;
    }

}
