package algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    protected Respuesta respuesta;
    private List<String> opciones;

    public Pregunta(Respuesta respuesta){
        this.respuesta = respuesta;
    }

    public void agregarOpcion(String opcion){
        opciones.add(opcion);
    }

    public boolean compararRespuestaCon(Respuesta respuesta) {

        return this.respuesta.compararRespuesta(respuesta);
    }

    public List<Integer> compararRespuestaCon(List<Respuesta> respuestas) {

        List<Integer> puntajes = new ArrayList<>();

        var size = respuestas.size();
        for (int i= 0 ; i < size; i++){
            var respuesta = respuestas.get(i);
            var puntaje = (this.compararRespuestaCon(respuesta)) ? 1 : 0;

            puntajes.add(i, puntaje);
        }

        return puntajes;
    }

}
