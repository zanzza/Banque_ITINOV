package org.banque.itinov.dto;

import java.util.Date;

public class OperationDTO {

    private Date date;
    private String type;
    private double montant;

    public OperationDTO() {
    }

    public OperationDTO(Date date, String type, double montant) {
        this.date = date;
        this.type = type;
        this.montant = montant;
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
}
