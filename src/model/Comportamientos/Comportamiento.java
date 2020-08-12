package model.Comportamientos;

public abstract class Comportamiento {

    Integer valorPuntajeCorrecto = 1;
    Integer valorPuntajeIncorrecto = 0;
    public String tipo;

    public abstract Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas, boolean cantRespuestasUsuarioCoincideConCantCorrectas);
    public abstract String getTipo();
}
