package org.banque.itinov.service;

import org.banque.itinov.dto.ClientDTO;
import org.banque.itinov.dto.CompteDTO;
import org.banque.itinov.entity.Client;
import org.banque.itinov.mapper.ClientMapper;
import org.banque.itinov.mapper.CompteMapper;
import org.banque.itinov.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    CompteMapper compteMapper;

    public List<CompteDTO> getComptes(String numeroClient) {
        return clientRepository.findByNumeroClient(numeroClient).getComptes().stream().map(compteMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ClientDTO> getAllClient() {
        List<ClientDTO> clients = new ArrayList<>();
        for (Client client : clientRepository.findAll()) {
            clients.add(clientMapper.toDto(client));
        }
        return clients;
    }
}
