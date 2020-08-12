package model;

import model.Boosts.Boost;
import model.FactoryPreguntas.FactoryPreguntas;
import model.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Juego {

    List<Jugador> jugadores;
    List<Pregunta> preguntas;
    Pregunta preguntaActual;
    RondaActual rondaActual;
    List<Boost> boosters;

    public Juego(){

        jugadores = new ArrayList<>();
        preguntas = new ArrayList<>();
        boosters = new ArrayList<>();
        rondaActual = crearRondaActual();
        inicializarPreguntas();
    }

    public void inicializarPreguntas(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("AyP3-TP1-Java\\src\\Recursos\\Preguntas.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray preguntas = (JSONArray) obj;

            //Iterate over preguntas array
            preguntas.forEach( p -> parsePreguntasObject( (JSONObject) p ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parsePreguntasObject(JSONObject pregunta)
    {
        //Get employee object within list
        String tipo = (String) pregunta.get("tipo");
        String comportamiento = (String) pregunta.get("comportamiento");
        String titulo = (String) pregunta.get("titulo");
        String opcionesLeidas = (String) pregunta.get("opciones");
        String respuestaCorrectaLeida = (String) pregunta.get("respuestaCorrecta");

        List<String> opciones = modificarFormato(opcionesLeidas);
        List<String> respuestaCorrecta = modificarFormato(respuestaCorrectaLeida);
        guardarPregunta(tipo.toString(),comportamiento.toString(),titulo.toString(),opciones,respuestaCorrecta);
    }

    public static List<String> modificarFormato(String respuesta){
        String[] respuestasCorrectas = respuesta.split(",");
        List<String> respuestaCorrecta = new ArrayList<String>();

        var cantRespuestas = respuestasCorrectas.length;
        for (int i = 0; i < cantRespuestas; i++){
            respuestaCorrecta.add(respuestasCorrectas[i]);
        }
        return respuestaCorrecta;
    }

    public void guardarPregunta(String tipo, String comportamiento, String titulo, List<String> opciones, List<String> respuestaCorrecta){
        FactoryPreguntas factoryPreguntas = new FactoryPreguntas();
        Pregunta pregunta = factoryPreguntas.crear(tipo,comportamiento,titulo,opciones,respuestaCorrecta);
        this.preguntas.add(pregunta);
    }

    public RondaActual crearRondaActual(){
        rondaActual = new RondaActual();
        return rondaActual;
    }

    public Jugador crearJugador(String nombre){

        if(nombre.equals("")){
            nombre = "Jugador"+String.valueOf(jugadores.stream().count()+1);
        }

        var jugador = new Jugador(nombre);
        jugadores.add(jugador);

        return jugador;
    }

    public void calcularPuntaje(){

        rondaActual.determinarPuntaje( preguntaActual, jugadores );
    }

    public void guardarPreguntaActual(Pregunta pregunta){
        preguntaActual = pregunta;
    }

    public Jugador verJugador(int numeroJugador){
        return jugadores.get(numeroJugador-1);
    }

    public List<Jugador> getJugadores(){return jugadores;}

    public List<Pregunta> getPreguntas(){return preguntas;}
    
    public void guardarRespuesta(Jugador jugador, List<String> respuesta, Boost boost){
        rondaActual.guardarRespuesta(jugador.getNombre(), respuesta, boost);
    }

    public RondaActual getRondaActual(){
        return rondaActual;
    }
    public Pregunta getPreguntaActual(){
        return preguntaActual;
    }

}
