package org.banque.itinov.controller;

import org.banque.itinov.dto.OperationDTO;
import org.banque.itinov.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operation")
public class OperationController {

    @Autowired
    OperationService operationService;

    @GetMapping("/historique/{numeroCompte}")
    public List<OperationDTO> getHistorique(@PathVariable String numeroCompte) {
        return operationService.getHistorique(numeroCompte);
    }

    @PostMapping("/deposer")
    public OperationDTO deposer(@RequestParam String numeroCompte, @RequestParam double montant) {
        return operationService.deposer(numeroCompte, montant);
    }

    @PostMapping("/retirer")
    public OperationDTO retirer(@RequestParam String numeroCompte, @RequestParam double montant) {
        return operationService.retirer(numeroCompte, montant);
    }

    @PostMapping("/virer")
    public List<OperationDTO> virer(@RequestParam String numeroCompteSource, @RequestParam String numeroCompteDest, @RequestParam double montant) {
        return operationService.virer(numeroCompteSource, numeroCompteDest, montant);
    }
}
