package org.banque.itinov.repository;

import org.banque.itinov.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNumeroClient(String numeroClient);
}
