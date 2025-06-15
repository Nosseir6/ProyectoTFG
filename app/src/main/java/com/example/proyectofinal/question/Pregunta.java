package com.example.proyectofinal.question;

import java.util.List;

public class Pregunta {
    private String pregunta;
    private List<String> opciones;
    private int respuesta_correcta;

    public String getPregunta() {
        return pregunta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public int getRespuesta_correcta() {
        return respuesta_correcta;
    }
}

