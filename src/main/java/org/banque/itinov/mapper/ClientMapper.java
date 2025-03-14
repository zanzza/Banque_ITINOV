package org.banque.itinov.mapper;

import org.banque.itinov.dto.ClientDTO;
import org.banque.itinov.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // Méthode pour convertir une entité Client en ClientDTO
    ClientDTO toDto(Client client);

    // Méthode pour convertir un ClientDTO en entité Client
    Client toEntity(ClientDTO clientDTO);
}
