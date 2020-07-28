package algo3.tp2.modelo.Comportamientos;

public class ComportamientoConPenalizacion extends Comportamiento{

    public ComportamientoConPenalizacion(){
        valorPuntajeIncorrecto = -1;
    }

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas){
        return respuestasIncorrectas == 0 ? valorPuntajeCorrecto : valorPuntajeIncorrecto;
    }
}
