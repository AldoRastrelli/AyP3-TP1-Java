package algo3.tp2.modelo.Comportamientos;

import java.util.HashMap;

public abstract class Comportamiento {

    Integer valorPuntajeCorrecto = 1;
    Integer valorPuntajeIncorrecto = 0;

    public abstract Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas, boolean cantRespuestasUsuarioCoincideConCantCorrectas);
}
