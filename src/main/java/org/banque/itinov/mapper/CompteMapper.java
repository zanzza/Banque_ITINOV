package org.banque.itinov.mapper;

import org.banque.itinov.dto.CompteDTO;
import org.banque.itinov.entity.Compte;
import org.banque.itinov.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CompteMapper {

    CompteMapper INSTANCE = Mappers.getMapper(CompteMapper.class);

    // Méthode pour convertir une entité Compte en CompteDTO
    CompteDTO toDto(Compte compte);

    // Méthode pour convertir un CompteDTO en entité Compte
    Compte toEntity(CompteDTO compteDTO);
}
