package soa.metier;

import soa.entities.Facture;

import java.util.List;

public interface FactureMetierInterface {
    void ajouterFacture(Facture facture);
    List<Facture> listeFactures();
    // Add other methods as needed for managing factures
}
