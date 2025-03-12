package org.banque.itinov.controller;
import org.banque.itinov.entity.Operation;
import org.banque.itinov.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping("/{numeroCompte}")
    public String getCompte(@PathVariable String numeroCompte) {
        // Retourne le solde et d'autres informations du compte
        return "Solde du compte " + numeroCompte + ": " + compteService.getCompte(numeroCompte).getSolde();
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
