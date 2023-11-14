package com.claseweb.services;

import com.claseweb.entidades.Biblioteca;
import com.claseweb.repository.BibliotecaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public Biblioteca crearBiblioteca(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public List<Biblioteca> listarBibliotecas() {
        return bibliotecaRepository.findAll();
    }

    public Biblioteca obtenerBiblioteca(Long id) {
        return bibliotecaRepository.findById(id).orElse(null);
    }

    public Biblioteca actualizarBiblioteca(Long id, Biblioteca biblioteca) {
        if (bibliotecaRepository.existsById(id)) {
            Biblioteca modificado = bibliotecaRepository.findById(id).orElse(null);
            modificado.setNombre(biblioteca.getNombre());
            modificado.setCiudad(biblioteca.getCiudad());
            modificado.setDireccion(biblioteca.getDireccion());
            return bibliotecaRepository.save(modificado);
        }
        return null;
    }

    public void eliminarBiblioteca(Long id) {
        bibliotecaRepository.deleteById(id);
    }
}
