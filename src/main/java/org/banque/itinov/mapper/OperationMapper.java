package org.banque.itinov.mapper;

import org.banque.itinov.dto.OperationDTO;
import org.banque.itinov.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

    // Méthode pour convertir une entité Operation en OperationDTO
    OperationDTO toDto(Operation operation);

    // Méthode pour convertir un OperationDTO en entité Operation
    Operation toEntity(OperationDTO operationDTO);
}
