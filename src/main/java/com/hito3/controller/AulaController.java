package com.hito3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hito3.service.AulaService;

@RestController
@RequestMapping("/aula")
public class AulaController {

    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping
    public String mostrarAula() {
        return aulaService.mostrarMatriz();
    }

    @GetMapping("/ocupados")
    public String asientosOcupados() {
        return aulaService.contarOcupados();
    }

    @GetMapping("/ocupar")
    public String ocuparAsiento(@RequestParam int fila, @RequestParam int columna) {
        return aulaService.ocuparAsiento(fila, columna);
    }

    @GetMapping("/liberar")
    public String liberarAsiento(@RequestParam int fila, @RequestParam int columna) {
        return aulaService.liberarAsiento(fila, columna);
    }
}
