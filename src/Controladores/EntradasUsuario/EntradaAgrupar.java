package Controladores.EntradasUsuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Preguntas.Pregunta;

import java.util.*;


public class EntradaAgrupar extends EntradaUsuario{
    Map<String, ComboBox> opcionesAgrupar;
    String tituloGrupoA;
    String tituloGrupoB;

    public EntradaAgrupar(Pregunta pregunta, List<String> opciones) {
        super(pregunta,opciones);
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

}
