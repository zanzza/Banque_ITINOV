package org.banque.itinov.controller;

import org.banque.itinov.dto.ClientDTO;
import org.banque.itinov.dto.CompteDTO;
import org.banque.itinov.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{numeroClient}")
    public List<CompteDTO> getComptes(@PathVariable String numeroClient) {
        return clientService.getComptes(numeroClient).stream().toList();
    }

    @GetMapping("/all/client")
    public List<ClientDTO> getAllClient() {
        return clientService.getAllClient();
    }
}
