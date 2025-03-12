package org.banque.itinov.service;

import org.banque.itinov.entity.Compte;
import org.banque.itinov.repository.ClientRepository;
import org.banque.itinov.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Compte> getComptes (String numeroClient){
        return clientRepository.findByNumeroClient(numeroClient).getComptes();
    }
}
