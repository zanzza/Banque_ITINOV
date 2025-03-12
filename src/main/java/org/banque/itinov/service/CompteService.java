package org.banque.itinov.service;

import org.banque.itinov.entity.Compte;
import org.banque.itinov.entity.Operation;
import org.banque.itinov.repository.CompteRepository;
import org.banque.itinov.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository operationRepository;

    public Compte getCompte(String numeroCompte) {
        return compteRepository.findByNumeroCompte(numeroCompte);
    }

    public boolean deposer(String numeroCompte, double montant) {
        Compte compte = getCompte(numeroCompte);
        compte.ajouterMontant(montant);

        Operation operation = new Operation();
        operation.setDate(new Date());
        operation.setType("Dépôt");
        operation.setMontant(montant);
        operation.setSoldeAvant(compte.getSolde() - montant);
        operation.setSoldeApres(compte.getSolde());
        operation.setCompte(compte);

        operationRepository.save(operation);
        compteRepository.save(compte);

        return true;
    }

    public boolean retirer(String numeroCompte, double montant) {
        Compte compte = getCompte(numeroCompte);

        if (!compte.retirerMontant(montant)) {
            return false;  // Retrait refusé si le solde est insuffisant
        }

        Operation operation = new Operation();
        operation.setDate(new Date());
        operation.setType("Retrait");
        operation.setMontant(montant);
        operation.setSoldeAvant(compte.getSolde() + montant);
        operation.setSoldeApres(compte.getSolde());
        operation.setCompte(compte);

        operationRepository.save(operation);
        compteRepository.save(compte);

        return true;
    }

    public boolean virer(String numeroCompteSource, String numeroCompteDest, double montant) {
        if (!retirer(numeroCompteSource, montant)) {
            return false;  // Retrait refusé
        }

        deposer(numeroCompteDest, montant);
        return true;
    }

    public List<Operation> getHistorique(Long compteId) {
        return operationRepository.findByCompteId(compteId);
    }
}
