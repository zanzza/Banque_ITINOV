package org.banque.itinov.service;

import org.banque.itinov.dto.OperationDTO;
import org.banque.itinov.entity.Compte;
import org.banque.itinov.entity.Operation;
import org.banque.itinov.mapper.OperationMapper;
import org.banque.itinov.repository.CompteRepository;
import org.banque.itinov.repository.OperationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OperationServiceTest {

    @Mock
    private CompteRepository compteRepository;

    @Mock
    private OperationRepository operationRepository;

    @Mock
    private OperationMapper operationMapper;

    @InjectMocks
    private OperationService operationService;

    private Compte compte;
    private Operation operation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Création d'un compte pour les tests
        compte = new Compte();
        compte.setNumeroCompte("123456789");
        compte.setSolde(1000.0);
        compte.setOperations(new ArrayList<>());

        // Création d'une opération pour les tests
        operation = new Operation();
        operation.setDate(new Date());
        operation.setType("Dépôt");
        operation.setMontant(500.0);
        operation.setCompte(compte);
    }

    @Test
    void testGetHistorique() {
        // Préparation des données simulées
        when(compteRepository.findByNumeroCompte("123456789")).thenReturn(compte);
        when(operationMapper.toDto(any(Operation.class))).thenReturn(new OperationDTO());

        // Test
        List<OperationDTO> operations = operationService.getHistorique("123456789");

        assertNotNull(operations);
        assertEquals(0, operations.size()); // Aucune opération associée au compte dans cet exemple
    }

    @Test
    void testDeposer() {
        // Préparation des données simulées
        when(compteRepository.findByNumeroCompte("123456789")).thenReturn(compte);
        when(operationRepository.save(any(Operation.class))).thenReturn(operation);
        when(operationMapper.toDto(any(Operation.class))).thenReturn(new OperationDTO());

        // Test du dépôt
        OperationDTO result = operationService.deposer("123456789", 500.0);

        assertNotNull(result);
        assertEquals(1500.0, compte.getSolde()); // Le solde doit être de 1500 après dépôt
    }

    @Test
    void testRetirer() {
        // Préparation des données simulées
        when(compteRepository.findByNumeroCompte("123456789")).thenReturn(compte);
        when(operationRepository.save(any(Operation.class))).thenReturn(operation);
        when(operationMapper.toDto(any(Operation.class))).thenReturn(new OperationDTO());

        // Test du retrait
        OperationDTO result = operationService.retirer("123456789", 500.0);

        assertNotNull(result);
        assertEquals(500.0, compte.getSolde()); // Le solde doit être de 500 après retrait
    }

    @Test
    void testVirer() {
        // Préparation des données simulées
        Compte compteDest = new Compte();
        compteDest.setNumeroCompte("987654321");
        compteDest.setSolde(500.0);

        when(compteRepository.findByNumeroCompte("123456789")).thenReturn(compte);
        when(compteRepository.findByNumeroCompte("987654321")).thenReturn(compteDest);
        when(operationRepository.save(any(Operation.class))).thenReturn(operation);
        when(operationMapper.toDto(any(Operation.class))).thenReturn(new OperationDTO());

        // Test du virement
        List<OperationDTO> result = operationService.virer("123456789", "987654321", 200.0);

        assertNotNull(result);
        assertEquals(2, result.size()); // Un virement implique deux opérations
        assertEquals(800.0, compte.getSolde()); // Le solde du compte source après virement
        assertEquals(700.0, compteDest.getSolde()); // Le solde du compte destination après virement
    }

    @Test
    void testDeposerCompteInexistant() {
        when(compteRepository.findByNumeroCompte("123456789")).thenReturn(null);

        // Test avec un compte inexistant
        OperationDTO result = operationService.deposer("123456789", 500.0);

        assertNull(result); // Le résultat doit être null si le compte n'existe pas
    }

    @Test
    void testRetirerMontantInsuffisant() {
        when(compteRepository.findByNumeroCompte("123456789")).thenReturn(compte);

        // Test du retrait avec un montant supérieur au solde
        OperationDTO result = operationService.retirer("123456789", 1500.0);

        assertNull(result); // Le résultat doit être null si le retrait échoue
    }
}
