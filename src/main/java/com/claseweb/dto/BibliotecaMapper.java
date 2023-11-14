package com.claseweb.dto;

import com.claseweb.entidades.Biblioteca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BibliotecaMapper {

    BibliotecaMapper mapper = Mappers.getMapper(BibliotecaMapper.class);

    @Mapping(source = "nombre" , target = "nombre")
    @Mapping(source = "direccion" , target = "direccion")
    @Mapping(source = "ciudad" , target = "ciudad")
    BibliotecaDTO bibliotecaToBibliotecaDTO(Biblioteca biblioteca);

}
