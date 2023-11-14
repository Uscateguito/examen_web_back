package com.claseweb.dto;

import com.claseweb.entidades.Jugador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JugadorMapper {

    JugadorMapper mapper = Mappers.getMapper(JugadorMapper.class);

    @Mapping(source = "nombres" , target = "nombres")
    @Mapping(source = "apellidos" , target = "apellidos")
    @Mapping(source = "numero" , target = "numero")
    JugadorDTO jugadorToJugadorDTO(Jugador jugador);
}
