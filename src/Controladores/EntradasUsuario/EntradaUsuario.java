package Controladores.EntradasUsuario;

import javafx.scene.control.ComboBox;
import model.Boosts.Boost;
import model.Boosts.BoostSimple;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class EntradaUsuario {

    protected Pregunta pregunta;
    protected List<String> opciones;
    protected List<String> respuestaUsuario;
    protected Map<String,Boost> boosts;
    protected ComboBox boostsMostrados;

    public EntradaUsuario(Pregunta pregunta, List<String> opciones, Jugador jugador){
        this.pregunta = pregunta;
        this.opciones = opciones;
        respuestaUsuario = new ArrayList<>();
        boosts = new HashMap<>();
    }

    public abstract List<String> getRespuesta();

    public abstract void setBoosts(Jugador jugador);

    public ComboBox getBoosts(){
        return boostsMostrados;
    }

    public Boost getBoostUsado(){
        var boostUsado = boostsMostrados.getValue();
        if(boostUsado == null){
            return new BoostSimple();
        }
        return boosts.get(boostUsado);
    }
}
