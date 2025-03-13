package org.banque.itinov.controller;

import org.banque.itinov.dto.CompteDTO;
import org.banque.itinov.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compte")
public class CompteController {

    @Autowired
    CompteService compteService;

    @GetMapping("/{numeroCompte}")
    public CompteDTO getCompte(@PathVariable String numeroCompte) {
        return compteService.getCompte(numeroCompte);
    }
}
