package Controladores.EntradasUsuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import model.Boosts.Boost;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class EntradaVerdaderoFalso extends EntradaUsuario{
    ComboBox comboBox;

    public EntradaVerdaderoFalso(Pregunta pregunta, List<String> opciones, Jugador jugador) {
        super(pregunta,opciones,jugador);

        ObservableList<String> options =
                FXCollections.observableArrayList();
        options.addAll(opciones);
        comboBox = new ComboBox(options);
        setBoosts(jugador);
    }

    public ComboBox getComboBox(){
        return comboBox;
    }

    @Override
    public List<String> getRespuesta() {
        var respuesta = (String) comboBox.getValue() == null ? "" : (String) comboBox.getValue();
        respuestaUsuario.add(respuesta);
        return respuestaUsuario;
    }

    @Override
    public void setBoosts(Jugador jugador) {
        List<Boost> boostsJugador = new ArrayList<>();
        String tipoPregunta = pregunta.getTipo();
        if (tipoPregunta.contains("Clásico")){
            boostsJugador.add(jugador.elegirBoostExclusivo());
        }
        else if (tipoPregunta.contains("Penalidad")){
            boostsJugador.add(jugador.elegirBoostDuplicador());
            boostsJugador.add(jugador.elegirBoostTriplicador());
        }

        boostsJugador.add(jugador.noUsarBoost());

        List<Boost> boostDisponibles = boostsJugador.stream().filter(b -> b.puedeUsarse()).collect(Collectors.toList());
        boostDisponibles.stream().forEach(b-> boosts.put(b.getNombre(),b));

        ObservableList<String> options = FXCollections.observableArrayList();
        boosts.keySet().stream().forEach(boostName->options.addAll(boostName));
        boostsMostrados = new ComboBox(options);
    }

}
