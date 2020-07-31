package algo3.tp2.modelo.Comportamientos;

public class ComportamientoConPenalidad extends Comportamiento{

    public ComportamientoConPenalidad(){
        valorPuntajeIncorrecto = -1;
    }

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas){
        return respuestasIncorrectas == 0 ? valorPuntajeCorrecto : valorPuntajeIncorrecto;
    }
}
