package algo3.tp2.modelo;

public class Jugador {

    private String nombre;
    private Integer puntos;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void sumarPuntos(Integer puntosNuevos) {

        this.puntos += puntosNuevos;
    }



}
