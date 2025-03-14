package org.banque.itinov.mapper;

import org.banque.itinov.dto.OperationDTO;
import org.banque.itinov.entity.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    // Méthode pour convertir une entité Operation en OperationDTO
    OperationDTO toDto(Operation operation);

    // Méthode pour convertir un OperationDTO en entité Operation
    Operation toEntity(OperationDTO operationDTO);
}
