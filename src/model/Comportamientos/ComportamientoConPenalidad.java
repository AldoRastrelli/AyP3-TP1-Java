package model.Comportamientos;

public class ComportamientoConPenalidad extends Comportamiento{

    public ComportamientoConPenalidad(){
        valorPuntajeIncorrecto = -1;
        tipo = "Con Penalidad";
    }

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas, boolean cantRespuestasUsuarioCoincideConCantCorrectas){
        return (valorPuntajeCorrecto * respuestasCorrectas) + (valorPuntajeIncorrecto * respuestasIncorrectas);
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
