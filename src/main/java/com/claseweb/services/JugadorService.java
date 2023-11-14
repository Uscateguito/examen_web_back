package com.claseweb.services;

import com.claseweb.entidades.Jugador;
import com.claseweb.repository.JugadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public Jugador crearJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> listarJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador obtenerJugador(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador actualizarJugador(Long id, Jugador jugador) {
        if (jugadorRepository.existsById(id)) {
            Jugador modificado = jugadorRepository.findById(id).orElse(null);
            modificado.setNombres(jugador.getNombres());
            modificado.setApellidos(jugador.getApellidos());
            modificado.setNumero(jugador.getNumero());
            modificado.setEquipo(jugador.getEquipo());
            return jugadorRepository.save(modificado);
        }
        return null;
    }

    public void eliminarJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
}
