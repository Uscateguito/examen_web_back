package com.claseweb.controllers;

import com.claseweb.dto.BibliotecaDTO;
import com.claseweb.dto.BibliotecaMapper;
import com.claseweb.entidades.Biblioteca;
import com.claseweb.services.BibliotecaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @PostMapping("/create")
    public BibliotecaDTO crearBiblioteca(@RequestBody Biblioteca biblioteca) {
        return BibliotecaMapper.mapper.
                bibliotecaToBibliotecaDTO(bibliotecaService.crearBiblioteca(biblioteca));
    }

    @GetMapping("/list")
    public List<BibliotecaDTO> listarBibliotecas() {
        return bibliotecaService.listarBibliotecas().stream().map(
                BibliotecaMapper.mapper::bibliotecaToBibliotecaDTO).
                collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public BibliotecaDTO actualizarBibliotecas(@PathVariable Long id, @RequestBody Biblioteca biblioteca) {
        return BibliotecaMapper.mapper.
                bibliotecaToBibliotecaDTO(bibliotecaService.actualizarBiblioteca(id, biblioteca));
    }

    @DeleteMapping("/{id}")
    public void eliminarBiblioteca(@PathVariable Long id) {
        bibliotecaService.eliminarBiblioteca(id);
    }
}
