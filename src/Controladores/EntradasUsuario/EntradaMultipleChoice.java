package Controladores.EntradasUsuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import model.Boosts.Boost;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class EntradaMultipleChoice extends EntradaUsuario{
    List<CheckBox> checkBoxes;

    public EntradaMultipleChoice(Pregunta pregunta, List<String> opciones, Jugador jugador) {
        super(pregunta,opciones,jugador);

        checkBoxes = new ArrayList<>();
        for (String opcion : opciones){
            CheckBox checkBox = new CheckBox(opcion);
            checkBoxes.add(checkBox);
        }
        setBoosts(jugador);
    }

    public List<CheckBox> getCheckBoxes(){
        return checkBoxes;
    }

    @Override
    public List<String> getRespuesta() {
        List<CheckBox> opcionesSeleccionadas = checkBoxes.stream().filter(checkBox -> checkBox.isSelected()).collect(Collectors.toList());
        opcionesSeleccionadas.stream().forEach(checkBox -> respuestaUsuario.add(checkBox.getText()));

        return respuestaUsuario;
    }

    @Override
    public void setBoosts(Jugador jugador) {
        List<Boost> boostsJugador = new ArrayList<>();
        String tipoPregunta = pregunta.getTipo();
        if (tipoPregunta.contains("Clásico") | tipoPregunta.contains("Parcial")){
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
