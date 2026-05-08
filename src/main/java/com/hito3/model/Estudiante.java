package com.hito3.model;

public class Estudiante {

    private int id;
    private String nombre;
    private int puntaje;

    public Estudiante(int id, String nombre, int puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Puntaje: " + puntaje;
    }
}
