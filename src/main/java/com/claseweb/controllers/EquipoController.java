package com.claseweb.controllers;

import com.claseweb.dto.EquipoDTO;
import com.claseweb.dto.EquipoMapper;
import com.claseweb.entidades.Equipo;
import com.claseweb.services.EquipoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/equipo")
public class EquipoController {

    private final EquipoService equipoService;

    @PostMapping("/create")
    public EquipoDTO crearEquipo(@RequestBody Equipo equipo) {
        return EquipoMapper.mapper.equipoToEquipoDTO(equipoService.crearEquipo(equipo));
    }


    @GetMapping("/list")
    public List<EquipoDTO> listarEquipos() {
        return equipoService.listarEquipos().stream().map(
                EquipoMapper.mapper::equipoToEquipoDTO).
                collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EquipoDTO obtenerEquipo(@PathVariable Long id) {
        return EquipoMapper.mapper.equipoToEquipoDTO(equipoService.obtenerEquipo(id));
    }

    @PutMapping("/{id}")
    public EquipoDTO actualizarEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        return EquipoMapper.mapper.equipoToEquipoDTO(equipoService.actualizarEquipo(id, equipo));
    }

    @DeleteMapping("/{id}")
    public void eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
    }
}
