package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Facture;
import soa.repository.FactureRepository;

import java.util.List;

@Service
public class FactureMetierImpl implements FactureMetierInterface {

    @Autowired
    private FactureRepository factureRepository;

    @Override
    public void ajouterFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public List<Facture> listeFactures() {
        return factureRepository.findAll();
    }


}
