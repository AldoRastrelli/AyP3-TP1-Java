package algo3.tp2.modelo.Comportamientos;

import java.util.Collections;
import java.util.List;

public class ComportamientoClasico extends Comportamiento{

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas){
        return respuestasIncorrectas == 0 ? valorPuntajeCorrecto : valorPuntajeIncorrecto;
    }

}
