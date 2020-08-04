package model.Preguntas;

import model.Comportamientos.Comportamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agrupar extends Pregunta{

    List<String> respuestaCorrectaGrupoA;
    List<String> respuestaCorrectaGrupoB;

    public Agrupar(List<String> respuesta, Comportamiento comportamiento) {
        super(respuesta, comportamiento);
        respuestaCorrectaGrupoA = new ArrayList<>();
        respuestaCorrectaGrupoB = new ArrayList<>();

        SepararGrupos(respuestaCorrectaGrupoA, respuestaCorrectaGrupoB, respuestaCorrecta);


    }

    @Override
    public boolean esRespuestaCorrecta(List<String> respuesta) {

        List<String> respuestaUsuarioGrupoA = new ArrayList<>();
        List<String> respuestaUsuarioGrupoB = new ArrayList<>();

        SepararGrupos(respuestaUsuarioGrupoA,respuestaUsuarioGrupoB,respuesta);

        return (respuestaUsuarioGrupoA.equals(respuestaCorrectaGrupoA) &&
                respuestaUsuarioGrupoB.equals(respuestaCorrectaGrupoB));

    }

    private void SepararGrupos(List<String> grupoA, List<String> grupoB, List<String> respuesta) {

        int i = 0;

        var cantGuardadas = guardarRespuestas(i, grupoA, respuesta);
        guardarRespuestas(cantGuardadas+1, grupoB, respuesta);

        Collections.sort(grupoA);
        Collections.sort(grupoB);
        return;
    }

    private int guardarRespuestas(int index, List<String> grupo, List<String> respuesta){

        while (!respuesta.get(index).equals("\0")){
            grupo.add(respuesta.get(index));
            index++;
        }
        return index;
    }








}

