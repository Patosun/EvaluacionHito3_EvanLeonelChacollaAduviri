package com.hito3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hito3.service.CalificacionesService;

@RestController
@RequestMapping("/notas")
public class NotasController {

    private final CalificacionesService calificacionesService;

    public NotasController(CalificacionesService calificacionesService) {
        this.calificacionesService = calificacionesService;
    }

    @GetMapping("/agregar")
    public String agregarNota(@RequestParam int valor) {
        return calificacionesService.agregarCalificacion(valor);
    }

    @GetMapping
    public String mostrarNotas() {
        return calificacionesService.mostrarCalificaciones();
    }

    @GetMapping("/promedio")
    public String promedio() {
        return calificacionesService.calcularPromedio();
    }

    @GetMapping("/max")
    public String notaMaxima() {
        return calificacionesService.obtenerMaximo();
    }

    @GetMapping("/min")
    public String notaMinima() {
        return calificacionesService.obtenerMinimo();
    }
}
