package com.claseweb.dto;

import com.claseweb.entidades.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibroMapper {

    LibroMapper mapper = Mappers.getMapper(LibroMapper.class);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "autor", target = "autor")
    LibroDTO libroToLibroDTO(Libro libro);
}
