package org.banque.itinov.controller;
import org.banque.itinov.entity.Operation;
import org.banque.itinov.service.ClientService;
import org.banque.itinov.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/{numeroCompte}")
    public String getCompte(@PathVariable String numeroCompte) {
        return compteService.getCompte(numeroCompte).toString();
    }

    @GetMapping("/{numeroClient}")
    public String getComptes(@PathVariable String numeroClient) {
        return clientService.getComptes(numeroClient).stream().toList().toString();
    }

    @PostMapping("/deposer")
    public boolean deposer(@RequestParam String numeroCompte, @RequestParam double montant) {
        return compteService.deposer(numeroCompte, montant);
    }

    @PostMapping("/retirer")
    public boolean retirer(@RequestParam String numeroCompte, @RequestParam double montant) {
        return compteService.retirer(numeroCompte, montant);
    }

    @PostMapping("/virer")
    public boolean virer(@RequestParam String numeroCompteSource, @RequestParam String numeroCompteDest, @RequestParam double montant) {
        return compteService.virer(numeroCompteSource, numeroCompteDest, montant);
    }

    @GetMapping("/historique/{compteId}")
    public List<Operation> getHistorique(@PathVariable Long compteId) {
        return compteService.getHistorique(compteId);
    }
}
