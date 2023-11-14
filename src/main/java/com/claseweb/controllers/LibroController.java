package com.claseweb.controllers;

import com.claseweb.dto.LibroDTO;
import com.claseweb.dto.LibroMapper;
import com.claseweb.entidades.Libro;
import com.claseweb.services.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/libro")
public class LibroController {

    private final LibroService libroService;

    @PostMapping("/create")
    public LibroDTO crearLibro(@RequestBody Libro libro) {
        return LibroMapper.mapper.libroToLibroDTO(libroService.crearLibro(libro));
    }

    @GetMapping("/list")
    public List<LibroDTO> listarLibros() {
        return libroService.listarLibros().stream().map(
                LibroMapper.mapper::libroToLibroDTO).
                collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LibroDTO obtenerLibro(@PathVariable Long id) {
        return LibroMapper.mapper.libroToLibroDTO(libroService.obtenerLibro(id));
    }

    @PutMapping("/{id}")
    public LibroDTO actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return LibroMapper.mapper.libroToLibroDTO(libroService.actualizarLibro(id, libro));
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}
