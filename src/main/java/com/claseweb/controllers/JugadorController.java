package com.claseweb.controllers;

import com.claseweb.dto.EquipoDTO;
import com.claseweb.dto.EquipoMapper;
import com.claseweb.dto.JugadorDTO;
import com.claseweb.dto.JugadorMapper;
import com.claseweb.entidades.Equipo;
import com.claseweb.entidades.Jugador;
import com.claseweb.services.JugadorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/jugador")
public class JugadorController {

    private final JugadorService jugadorService;

    @PostMapping("/create")
    public JugadorDTO crearJugador(@RequestBody Jugador jugador) {
        return JugadorMapper.mapper.jugadorToJugadorDTO(jugadorService.crearJugador(jugador));
    }

    @GetMapping("/list")
    public List<JugadorDTO> listarJugadores() {
        return jugadorService.listarJugadores().stream().map(
                JugadorMapper.mapper::jugadorToJugadorDTO).
                collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public JugadorDTO obtenerJugador(@PathVariable Long id) {
        return JugadorMapper.mapper.jugadorToJugadorDTO(jugadorService.obtenerJugador(id));
    }

    @PutMapping("/{id}")
    public JugadorDTO actualizarJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
        return JugadorMapper.mapper.jugadorToJugadorDTO(jugadorService.actualizarJugador(id, jugador));
    }

    @DeleteMapping("/{id}")
    public void eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugador(id);
    }

}
