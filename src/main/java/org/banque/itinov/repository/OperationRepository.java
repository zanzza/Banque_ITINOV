package org.banque.itinov.repository;
import org.banque.itinov.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByCompteId(Long compteId);
}
