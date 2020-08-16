package Controladores.EntradasUsuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import model.Boosts.Boost;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class EntradaOrdenar extends EntradaUsuario{
    List<ComboBox> comboBoxes;

    public EntradaOrdenar(Pregunta pregunta, List<String> opciones, Jugador jugador) {
        super(pregunta,opciones,jugador);

        comboBoxes = new ArrayList<>();
        Collections.shuffle(opciones);
        for(String opcion : opciones){
            ObservableList<String> options =
                    FXCollections.observableArrayList();
            options.addAll(opciones);
            comboBoxes.add(new ComboBox(options));
        }
        setBoosts(jugador);
    }

    public List<ComboBox> getComboBoxes(){
        return comboBoxes;
    }

    @Override
    public List<String> getRespuesta() {

        comboBoxes.stream().forEach(comboBox -> respuestaUsuario.add((String)comboBox.getValue()));

        return respuestaUsuario;
    }

    @Override
    public void setBoosts(Jugador jugador) {
        List<Boost> boostsJugador = new ArrayList<>();
        boostsJugador.add(jugador.elegirBoostExclusivo());
        boostsJugador.add(jugador.noUsarBoost());

        List<Boost> boostDisponibles = boostsJugador.stream().filter(b -> b.puedeUsarse()).collect(Collectors.toList());
        boostDisponibles.stream().forEach(b-> boosts.put(b.getNombre(),b));

        ObservableList<String> options = FXCollections.observableArrayList();
        boosts.keySet().stream().forEach(boostName->options.addAll(boostName));
        boostsMostrados = new ComboBox(options);
    }

}
