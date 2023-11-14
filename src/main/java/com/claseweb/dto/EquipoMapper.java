package com.claseweb.dto;

import com.claseweb.entidades.Equipo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipoMapper {

    EquipoMapper mapper = Mappers.getMapper(EquipoMapper.class);

    @Mapping(source = "nombre" , target = "nombre")
    @Mapping(source = "copas_internacionales" , target = "copas_internacionales")
    EquipoDTO equipoToEquipoDTO(Equipo equipo);
}
