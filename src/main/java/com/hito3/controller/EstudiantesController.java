package com.hito3.controller;

import com.hito3.estructuras.ListaEstudiantes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {

    private final ListaEstudiantes listaEstudiantes;

    public EstudiantesController(ListaEstudiantes listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @GetMapping("/agregar")
    public String agregarEstudiante(@RequestParam int id, @RequestParam String nombre, @RequestParam int puntaje) {
        return listaEstudiantes.insertar(id, nombre, puntaje);
    }

    @GetMapping
    public String mostrarEstudiantes() {
        return listaEstudiantes.mostrarTodos();
    }

    @GetMapping("/ordenados")
    public String estudiantesOrdenados() {
        return listaEstudiantes.ordenadosPorPuntaje();
    }

    @GetMapping("/buscar/{nombre}")
    public String buscarEstudiante(@PathVariable String nombre) {
        return listaEstudiantes.buscarPorNombre(nombre);
    }
}
