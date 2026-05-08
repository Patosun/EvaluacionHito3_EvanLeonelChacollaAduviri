package com.hito3.service;

import org.springframework.stereotype.Service;

@Service
public class CalificacionesService {

    private static final int CAPACIDAD = 10;
    private final int[] calificaciones = new int[CAPACIDAD];
    private int cantidad = 0;

    public String agregarCalificacion(int valor) {
        if (cantidad >= CAPACIDAD) {
            return "No se pueden agregar más calificaciones (máximo " + CAPACIDAD + ").";
        }
        calificaciones[cantidad] = valor;
        cantidad++;
        return "Calificación " + valor + " agregada en posición " + cantidad + ".";
    }

    public String mostrarCalificaciones() {
        if (cantidad == 0) {
            return "No hay calificaciones.";
        }
        StringBuilder sb = new StringBuilder("Calificaciones registradas (" + cantidad + "/" + CAPACIDAD + "):\n");
        for (int i = 0; i < cantidad; i++) {
            sb.append("  [").append(i + 1).append("] ").append(calificaciones[i]);
            if (calificaciones[i] >= 60) {
                sb.append(" (aprobado)");
            } else {
                sb.append(" (reprobado)");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String calcularPromedio() {
        if (cantidad == 0) {
            return "No hay calificaciones.";
        }
        double suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma += calificaciones[i];
        }
        double promedio = suma / cantidad;
        return String.format("Promedio de calificaciones: %.2f", promedio);
    }

    public String obtenerMaximo() {
        if (cantidad == 0) {
            return "No hay calificaciones.";
        }
        int max = calificaciones[0];
        for (int i = 1; i < cantidad; i++) {
            if (calificaciones[i] > max) {
                max = calificaciones[i];
            }
        }
        return "Nota máxima: " + max;
    }

    public String obtenerMinimo() {
        if (cantidad == 0) {
            return "No hay calificaciones.";
        }
        int min = calificaciones[0];
        for (int i = 1; i < cantidad; i++) {
            if (calificaciones[i] < min) {
                min = calificaciones[i];
            }
        }
        return "Nota mínima: " + min;
    }
}
