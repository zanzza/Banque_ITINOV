package org.banque.itinov.dto;

import java.util.Date;

public class OperationDTO {

    private Date date;
    private String type; // "Dépôt", "Retrait", "Virement"
    private double montant;
    private double soldeAvant;
    private double soldeApres;

    // Constructeur
    public OperationDTO(Date date, String type, double montant, double soldeAvant, double soldeApres) {
        this.date = date;
        this.type = type;
        this.montant = montant;
        this.soldeAvant = soldeAvant;
        this.soldeApres = soldeApres;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getSoldeAvant() {
        return soldeAvant;
    }

    public void setSoldeAvant(double soldeAvant) {
        this.soldeAvant = soldeAvant;
    }

    public double getSoldeApres() {
        return soldeApres;
    }

    public void setSoldeApres(double soldeApres) {
        this.soldeApres = soldeApres;
    }
}
