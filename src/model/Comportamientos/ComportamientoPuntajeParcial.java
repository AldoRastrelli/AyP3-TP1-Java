package model.Comportamientos;

public class ComportamientoPuntajeParcial extends Comportamiento{

    Integer valorPuntajeCorrecto = 1;

    public ComportamientoPuntajeParcial(){
        tipo = "Puntaje Parcial";
    }

    public Integer calcularPuntaje(Integer respuestasCorrectas, Integer respuestasIncorrectas, boolean cantRespuestasUsuarioCoincideConCantCorrectas){
        if (respuestasIncorrectas>0){ return 0;}
        return valorPuntajeCorrecto * respuestasCorrectas;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
