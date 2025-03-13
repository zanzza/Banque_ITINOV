package org.banque.itinov.dto;

import java.util.List;

public class ClientDTO {
    private String numeroClient;

    // Constructeur
    public ClientDTO(String numeroClient) {
        this.numeroClient = numeroClient;
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(String numeroClient) {
        this.numeroClient = numeroClient;
    }
}
