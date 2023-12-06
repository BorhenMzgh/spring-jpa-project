package soa.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soa.entities.Client;
import soa.entities.Facture;
import soa.repository.FactureRepository;

import java.util.List;

@RestController
@RequestMapping("/factures")
@CrossOrigin(origins = "http://localhost:3000/")
public class FactureRESTController {

    @Autowired
    private FactureRepository factureRepository;

    @PostMapping(value = "/getFactures", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Facture>> getFacturesByClient(@RequestBody Client client) {
        try {
            List<Facture> factures = factureRepository.findByClient(client);
            return ResponseEntity.ok(factures);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }




    @GetMapping(value = "/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Facture getFacture(@PathVariable Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteFacture(@PathVariable Long id) {
        factureRepository.deleteById(id);
    }

    @PostMapping(value = "/", produces =
            { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Facture saveFacture(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @PostMapping(value = "/update", produces =
            { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Facture updateFacture(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @DeleteMapping("/")
    public void deleteFacture(@RequestBody Facture facture) {
        factureRepository.delete(facture);
    }
}
