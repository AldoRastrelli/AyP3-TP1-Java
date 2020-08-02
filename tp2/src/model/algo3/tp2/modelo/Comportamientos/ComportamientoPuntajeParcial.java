package algo3.tp2.modelo.Comportamientos;

public class ComportamientoPuntajeParcial extends Comportamiento{

    Integer valorPuntajeCorrecto = 1;

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas, boolean cantRespuestasUsuarioCoincideConCantCorrectas){
        return respuestasIncorrectas == 0 ? valorPuntajeCorrecto * respuestasCorrectas : valorPuntajeIncorrecto;
    }
}
