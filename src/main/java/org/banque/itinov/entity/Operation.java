package org.banque.itinov.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String type; // "Dépôt", "Retrait", "Virement"
    private double montant;
    private double soldeAvant;
    private double soldeApres;

    @ManyToOne
    private Compte compte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
