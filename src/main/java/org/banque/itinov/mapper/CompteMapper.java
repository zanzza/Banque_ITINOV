package org.banque.itinov.mapper;

import org.banque.itinov.dto.CompteDTO;
import org.banque.itinov.entity.Compte;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompteMapper {


    // Méthode pour convertir une entité Compte en CompteDTO
    CompteDTO toDto(Compte compte);

    // Méthode pour convertir un CompteDTO en entité Compte
    Compte toEntity(CompteDTO compteDTO);
}
