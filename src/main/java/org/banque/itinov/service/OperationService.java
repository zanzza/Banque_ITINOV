package org.banque.itinov.service;

import org.banque.itinov.dto.OperationDTO;
import org.banque.itinov.entity.Compte;
import org.banque.itinov.entity.Operation;
import org.banque.itinov.mapper.OperationMapper;
import org.banque.itinov.repository.CompteRepository;
import org.banque.itinov.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CompteRepository compteRepository;

    @Autowired
    OperationMapper operationMapper;

    public List<OperationDTO> getHistorique(String numeroCompte) {
        return compteRepository.findByNumeroCompte(numeroCompte).getOperations().stream().map(operationMapper::toDto).collect(Collectors.toList());
    }

    public OperationDTO deposer(String numeroCompte, double montant) {
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte);
        if (compte == null ) return null;
        compte.ajouterMontant(montant);

        Operation operation = new Operation();
        operation.setDate(new Date());
        operation.setType("Dépôt");
        operation.setMontant(montant);
        operation.setSoldeAvant(compte.getSolde() - montant);
        operation.setSoldeApres(compte.getSolde());
        operation.setCompte(compte);

        Operation operationSaved = operationRepository.save(operation);

        return  operationMapper.toDto(operationSaved);
    }

    public OperationDTO retirer(String numeroCompte, double montant) {
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte);
        if (compte == null ) return null;

        if (!compte.retirerMontant(montant)) {
            return null;
        }
        Operation operation = new Operation();
        operation.setDate(new Date());
        operation.setType("Retrait");
        operation.setMontant(montant);
        operation.setSoldeAvant(compte.getSolde() + montant);
        operation.setSoldeApres(compte.getSolde());
        operation.setCompte(compte);

        Operation operationSaved = operationRepository.save(operation);

        return operationMapper.toDto(operationSaved);
    }

    public List<OperationDTO> virer(String numeroCompteSource, String numeroCompteDest, double montant) {
        Compte compteSource = compteRepository.findByNumeroCompte(numeroCompteSource);
        Compte compteDest = compteRepository.findByNumeroCompte(numeroCompteDest);

        if (compteSource == null || compteDest == null) return null;

        OperationDTO operationDTORetrait = retirer(numeroCompteSource, montant);

        if ( operationDTORetrait == null ) return null;

        OperationDTO operationDTODest = deposer(numeroCompteDest, montant);

        List<OperationDTO> operationDTOS = new ArrayList<>();
        operationDTOS.add(operationDTORetrait);
        operationDTOS.add(operationDTODest);

        return operationDTOS;
    }
}
