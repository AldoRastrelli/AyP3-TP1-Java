package algo3.tp2.modelo.Comportamientos;

public class ComportamientoClasico extends Comportamiento{

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas, boolean cantRespuestasUsuarioCoincideConCantCorrectas){
        return cantRespuestasUsuarioCoincideConCantCorrectas ? valorPuntajeCorrecto : valorPuntajeIncorrecto;
    }

}
