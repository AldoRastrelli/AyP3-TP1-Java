package model;

import model.Boosts.Boost;
import model.Boosts.BoostExclusividad;
import model.Preguntas.Pregunta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RondaActual {

    Map<String, List<String>> respuestas;
    Map<String, Integer> puntajes;
    Map<String,Boost> boosts;
    boolean boostExclusividad;

    public RondaActual(){
        respuestas = new HashMap<String, List<String>>();
        puntajes = new HashMap<String, Integer>();
        boosts = new HashMap<String,Boost>();
        /*boostExclusividad = false;*/
    }

    public void guardarRespuesta(String nombreJugador, List<String> respuesta, Boost boost){
        respuestas.put(nombreJugador,respuesta);
        boosts.put(nombreJugador,boost);
        puntajes.put(nombreJugador,0);

        if(boost.esBoostExclusivo()){
            boostExclusividad = true;
        }
    }



    public void determinarPuntaje(Pregunta preguntaActual, List<Jugador> jugadores) {

        puntajes = preguntaActual.determinarPuntaje(respuestas);

        // Se usa el Boost Exclusividad pero no cumple las condiciones para aplicarse
        if (seUsaBoostExclusividad() & !verificaBoostExclusivo()) {
            puntajes.keySet().forEach(j -> puntajes.replace(j, 0));
            restarUsoExclusivo(jugadores);
            pasarPuntajes(jugadores);
            boostExclusividad = false;
            return;
        }

        // Se usa el Boost Exclusividad y cumple condiciones
        if (seUsaBoostExclusividad() & verificaBoostExclusivo()) {
            ModificarBoostsSegunCantidadDeUsosDeBoostExclusividad(jugadores);
        }
        usarBoosts();

        pasarPuntajes(jugadores);
        boostExclusividad = false;
    }

    private boolean seUsaBoostExclusividad(){

        return boostExclusividad;
    }

    private boolean verificaBoostExclusivo(){

        var cantPuntajesNoNulos = puntajes.entrySet().stream().filter(p-> p.getValue() != 0).count();
        return (cantPuntajesNoNulos == 1);

    }

    public void ModificarBoostsSegunCantidadDeUsosDeBoostExclusividad(List<Jugador> jugadores){
        var cantExclusividad = cantidadDeUsosExclusividad(jugadores);
        jugadores.forEach( j->{
            if (!boosts.get(j.getNombre()).getNombre().equals("Exclusividad")){
                boosts.replace(j.getNombre(), new BoostExclusividad());
            }
        });

        // Si más de un jugador aplicó exclusividad, se duplica
        // el multiplicador del Boost por cada vez que un jugador lo usó
        if (cantExclusividad > 1) {
            duplicarBoostsExclusividad(cantExclusividad);
        }
    }

    private Integer cantidadDeUsosExclusividad(List<Jugador> jugadores){
        var cantBoostsExclusividad = 0;
        for (Jugador jugador : jugadores){
            if (boosts.get(jugador.getNombre()).esBoostExclusivo()){
                cantBoostsExclusividad++;
            }
        }
        return cantBoostsExclusividad;
    }

    public void duplicarBoostsExclusividad(Integer veces){
        for (Map.Entry<String,Boost> entry : this.boosts.entrySet()){
            this.boosts.get(entry.getKey()).duplicarExclusivo(veces);
        }
    }

    private void usarBoosts(){

        var jugadores = puntajes.keySet().stream();

        jugadores.forEach( j->
                puntajes.put
                    ( j , boosts.get(j).usarBoost(puntajes.get(j) )
                )
        );

    }

    private void pasarPuntajes(List<Jugador> jugadoresLista){

        Map<String,Jugador> jugadores = new HashMap<>();
        jugadoresLista.forEach(j-> jugadores.put(j.getNombre(), j));

        var puntajes = this.puntajes.keySet().stream();

        puntajes.forEach(jugador ->
                jugadores.get(jugador).actualizarPuntaje( this.puntajes.get(jugador) )
                );
    }

    public Map<String,Integer> getPuntajes(){
        return puntajes;
    }

    public void restarUsoExclusivo(List<Jugador> jugadores){
        jugadores.forEach( j-> {
            var boost = boosts.get(j.getNombre());
            if (boost.esBoostExclusivo()){boost.restarUso();}
        });
    }
}
