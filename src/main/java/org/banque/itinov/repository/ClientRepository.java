package org.banque.itinov.repository;

import org.banque.itinov.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNumeroClient(String numeroClient);
}
