package model.Comportamientos;

public class ComportamientoPuntajeParcial extends Comportamiento{

    Integer valorPuntajeCorrecto = 1;

    public ComportamientoPuntajeParcial(){
        tipo = "Puntaje Parcial";
    }

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas, boolean cantRespuestasUsuarioCoincideConCantCorrectas){
        return valorPuntajeCorrecto * respuestasCorrectas + valorPuntajeIncorrecto * respuestasIncorrectas;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
