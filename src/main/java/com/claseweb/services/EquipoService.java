package com.claseweb.services;

import com.claseweb.entidades.Equipo;
import com.claseweb.repository.EquipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo obtenerEquipo(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }



    public Equipo actualizarEquipo(Long id, Equipo equipo) {
        if (equipoRepository.existsById(id)) {
            Equipo modificado = equipoRepository.findById(id).orElse(null);
            modificado.setNombre(equipo.getNombre());
            modificado.setCopas_internacionales(equipo.getCopas_internacionales());
            return equipoRepository.save(modificado);
        }
        return null;
    }

    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
}
