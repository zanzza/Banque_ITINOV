package org.banque.itinov.repository;

import org.banque.itinov.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    Compte findByNumeroCompte(String numeroCompte);
}
