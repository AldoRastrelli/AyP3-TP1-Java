package algo3.tp2.modelo;

import java.util.List;

public class Respuesta {

    private String valor;

    public Respuesta() {
        valor = "";
    }

    public Respuesta(String respuestaCorrecta){
        valor = respuestaCorrecta;
    }

    public String getValor() {
        return valor;
    }

    public boolean compararRespuesta(Respuesta respuesta){
        return respuesta.compararValor(valor);
    }

    private boolean compararValor(String valor){
        return this.valor.equals(valor);
    }
}
