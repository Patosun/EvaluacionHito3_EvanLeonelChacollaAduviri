package com.hito3.estructuras;

import com.hito3.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class ListaEstudiantes {

    private Nodo cabeza;

    public String insertar(int id, String nombre, int puntaje) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getId() == id) {
                return "Ya existe un estudiante con ID " + id + ".";
            }
            actual = actual.siguiente;
        }
        Nodo nuevo = new Nodo(new Estudiante(id, nombre, puntaje));
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        return "Estudiante '" + nombre + "' agregado correctamente.";
    }

    public String mostrarTodos() {
        if (cabeza == null) {
            return "No hay estudiantes registrados.";
        }
        StringBuilder sb = new StringBuilder("Estudiantes registrados:\n");
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append("  ").append(actual.estudiante.toString()).append("\n");
            actual = actual.siguiente;
        }
        return sb.toString();
    }

    public String ordenadosPorPuntaje() {
        if (cabeza == null) {
            return "No hay estudiantes registrados.";
        }

        int total = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getPuntaje() >= 60) {
                total++;
            }
            actual = actual.siguiente;
        }

        if (total == 0) {
            return "No hay estudiantes aprobados.";
        }

        Estudiante[] aprobados = new Estudiante[total];
        int i = 0;
        actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getPuntaje() >= 60) {
                aprobados[i++] = actual.estudiante;
            }
            actual = actual.siguiente;
        }

        for (int x = 0; x < aprobados.length - 1; x++) {
            for (int y = 0; y < aprobados.length - 1 - x; y++) {
                if (aprobados[y].getPuntaje() < aprobados[y + 1].getPuntaje()) {
                    Estudiante temp = aprobados[y];
                    aprobados[y] = aprobados[y + 1];
                    aprobados[y + 1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder("Aprobados ordenados por puntaje (mayor a menor):\n");
        for (Estudiante e : aprobados) {
            sb.append("  ").append(e.toString()).append("\n");
        }
        return sb.toString();
    }

    public String buscarPorNombre(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return "Estudiante encontrado: " + actual.estudiante.toString();
            }
            actual = actual.siguiente;
        }
        return "No se encontró ningún estudiante con el nombre '" + nombre + "'.";
    }
}
