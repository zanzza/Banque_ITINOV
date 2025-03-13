package org.banque.itinov.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCompte;
    private double solde;
    private double decouvertAutorise;

    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;

    @ManyToOne
    private Client client;

    public void ajouterMontant(double montant) {
        this.solde += montant;
    }

    public boolean retirerMontant(double montant) {
        if (this.solde - montant < -decouvertAutorise) {
            return false;  // Retrait refusé
        }
        this.solde -= montant;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numeroCompte='" + numeroCompte + '\'' +
                ", solde=" + solde +
                ", decouvertAutorise=" + decouvertAutorise +
                '}';
    }
}
