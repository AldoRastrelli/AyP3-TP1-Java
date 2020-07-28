package algo3.tp2.modelo.Comportamientos;

public class ComportamientoPuntajeParcial extends Comportamiento{

    Integer valorPuntajeCorrecto = 1;

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas){
        return respuestasCorrectas * valorPuntajeCorrecto;
    }
}
