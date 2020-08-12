package model.Comportamientos;

import model.Comportamientos.Comportamiento;

public class ComportamientoClasico extends Comportamiento {

    public ComportamientoClasico(){
        tipo = "Clásico";
    }
    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas, boolean laRespuestaEsCorrectaEnSuTotalidad){
        return laRespuestaEsCorrectaEnSuTotalidad ? valorPuntajeCorrecto : valorPuntajeIncorrecto;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

}
