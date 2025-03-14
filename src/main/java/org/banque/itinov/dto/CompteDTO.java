package org.banque.itinov.dto;

public class CompteDTO {

    private String numeroCompte;
    private double solde;
    private double decouvertAutorise;

    // Constructeur
    public CompteDTO(String numeroCompte, double solde, double decouvertAutorise) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.decouvertAutorise = decouvertAutorise;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }
}
