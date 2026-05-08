package com.hito3.service;

import org.springframework.stereotype.Service;

@Service
public class AulaService {

    private static final int FILAS = 5;
    private static final int COLUMNAS = 5;
    private final int[][] aula = new int[FILAS][COLUMNAS];

    public String ocuparAsiento(int fila, int columna) {
        if (!coordenadasValidas(fila, columna)) {
            return "Coordenadas inválidas. Fila: 1-" + FILAS + ", Columna: 1-" + COLUMNAS + ".";
        }
        int f = fila - 1;
        int c = columna - 1;
        if (aula[f][c] == 1) {
            return "El asiento [" + fila + "][" + columna + "] ya está ocupado.";
        }
        aula[f][c] = 1;
        return "Asiento [" + fila + "][" + columna + "] ocupado correctamente.";
    }

    public String liberarAsiento(int fila, int columna) {
        if (!coordenadasValidas(fila, columna)) {
            return "Coordenadas inválidas. Fila: 1-" + FILAS + ", Columna: 1-" + COLUMNAS + ".";
        }
        int f = fila - 1;
        int c = columna - 1;
        if (aula[f][c] == 0) {
            return "El asiento [" + fila + "][" + columna + "] ya está libre.";
        }
        aula[f][c] = 0;
        return "Asiento [" + fila + "][" + columna + "] liberado correctamente.";
    }

    public String mostrarMatriz() {
        StringBuilder sb = new StringBuilder("Distribución del aula (" + FILAS + "x" + COLUMNAS + "):\n");
        sb.append("     ");
        for (int c = 1; c <= COLUMNAS; c++) {
            sb.append("C").append(c).append(" ");
        }
        sb.append("\n");
        for (int f = 0; f < FILAS; f++) {
            sb.append("F").append(f + 1).append(" [ ");
            for (int c = 0; c < COLUMNAS; c++) {
                sb.append(aula[f][c] == 0 ? "L" : "O").append("  ");
            }
            sb.append("]\n");
        }
        sb.append("L = libre, O = ocupado");
        return sb.toString();
    }

    public String contarOcupados() {
        int ocupados = 0;
        for (int f = 0; f < FILAS; f++) {
            for (int c = 0; c < COLUMNAS; c++) {
                if (aula[f][c] == 1) {
                    ocupados++;
                }
            }
        }
        int libres = (FILAS * COLUMNAS) - ocupados;
        return "Asientos ocupados: " + ocupados + " | Asientos libres: " + libres + " | Total: " + (FILAS * COLUMNAS);
    }

    private boolean coordenadasValidas(int fila, int columna) {
        return fila >= 1 && fila <= FILAS && columna >= 1 && columna <= COLUMNAS;
    }
}
