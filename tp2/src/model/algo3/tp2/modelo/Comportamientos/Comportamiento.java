package algo3.tp2.modelo.Comportamientos;

public abstract class Comportamiento {

    Integer valorPuntajeCorrecto = 1;
    Integer valorPuntajeIncorrecto = 0;

    public abstract Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas);
}
