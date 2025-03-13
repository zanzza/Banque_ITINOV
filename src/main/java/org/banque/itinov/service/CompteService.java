package org.banque.itinov.service;

import org.banque.itinov.dto.CompteDTO;
import org.banque.itinov.entity.Compte;
import org.banque.itinov.mapper.CompteMapper;
import org.banque.itinov.mapper.OperationMapper;
import org.banque.itinov.repository.CompteRepository;
import org.banque.itinov.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {

    @Autowired
    CompteRepository compteRepository;

    @Autowired
    CompteMapper compteMapper;

    public CompteDTO getCompte(String numeroCompte) {
        return compteMapper.toDto(compteRepository.findByNumeroCompte(numeroCompte));
    }
}
