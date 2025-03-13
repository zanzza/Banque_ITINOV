package org.banque.itinov.mapper;

import org.banque.itinov.dto.ClientDTO;
import org.banque.itinov.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    // Méthode pour convertir une entité Client en ClientDTO
    ClientDTO toDto(Client client);

    // Méthode pour convertir un ClientDTO en entité Client
    Client toEntity(ClientDTO clientDTO);
}
