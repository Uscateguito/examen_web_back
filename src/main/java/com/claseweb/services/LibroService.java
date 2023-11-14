package com.claseweb.services;

import com.claseweb.entidades.Libro;
import com.claseweb.repository.LibroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro obtenerLibro(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }



    public Libro actualizarLibro(Long id, Libro libro) {
        if (libroRepository.existsById(id)) {
            Libro modificado = libroRepository.findById(id).orElse(null);
            modificado.setAutor(libro.getAutor());
            modificado.setNombre(libro.getNombre());
            modificado.setBiblioteca(libro.getBiblioteca());
            return libroRepository.save(modificado);
        }
        return null;
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }


}
