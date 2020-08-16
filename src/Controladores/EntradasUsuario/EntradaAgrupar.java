package Controladores.EntradasUsuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import model.Boosts.Boost;
import model.Jugador;
import model.Preguntas.Pregunta;

import java.util.*;
import java.util.stream.Collectors;


public class EntradaAgrupar extends EntradaUsuario{
    Map<String, ComboBox> opcionesAgrupar;
    String tituloGrupoA;
    String tituloGrupoB;

    public EntradaAgrupar(Pregunta pregunta, List<String> opciones, Jugador jugador) {
        super(pregunta,opciones,jugador);
        Collections.shuffle(this.opciones);

        List<String> opcionesComboBox = Arrays.asList(pregunta.getPregunta().split(","));
        tituloGrupoA = opcionesComboBox.get(0);
        tituloGrupoB = opcionesComboBox.get(1);

        opcionesAgrupar = new HashMap<>();
        for(String opcion : opciones){
            ObservableList<String> options = FXCollections.observableArrayList();
            options.addAll(opcionesComboBox);
            ComboBox comboBox = new ComboBox(options);
            opcionesAgrupar.put(opcion,comboBox);
        }
        setBoosts(jugador);
    }

    public Map<String,ComboBox> getOpciones(){
            return opcionesAgrupar;
    }

    @Override
    public List<String> getRespuesta() {

        List<String> grupoA = new ArrayList<>();
        List<String> grupoB = new ArrayList<>();

        for(Map.Entry<String, ComboBox> elemento : opcionesAgrupar.entrySet()){
            var comboBox = elemento.getValue();
            if(comboBox.getValue() == null) { comboBox.setValue("");}
            String opcionElegida = (String) comboBox.getValue();
            List<String> grupo = opcionElegida.equals(tituloGrupoA) ? grupoA : grupoB;
            grupo.add(elemento.getKey());
        }

        grupoA.add("*");
        grupoB.add("*");
        grupoA.stream().forEach(r -> respuestaUsuario.add(r));
        grupoB.stream().forEach(r -> respuestaUsuario.add(r));

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
