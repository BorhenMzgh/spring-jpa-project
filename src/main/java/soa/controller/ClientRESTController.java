package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soa.entities.Client;
import soa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/clients")
public class ClientRESTController {

    @Autowired
    private ClientRepository clientRepos;



    @GetMapping(
            value = "/",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Client> getAllClients() {
        return clientRepos.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Optional<Client> getClientById(@PathVariable Long id) {
        return clientRepos.findById(id);
    }

    @PostMapping(
            value = "/",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Client createClient(@RequestBody Client c) {
        return clientRepos.save(c);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        Optional<Client> existingClientOptional = clientRepos.findById(id);

        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();

            // Update the fields of the existing client with the values from the updated client
            existingClient.setNom(updatedClient.getNom());
            existingClient.setPrenom(updatedClient.getPrenom());
            existingClient.setNum(updatedClient.getNum());
            existingClient.setAdress(updatedClient.getAdress());
            existingClient.setEtat(updatedClient.getEtat());

            // Save the updated client
            Client savedClient = clientRepos.save(existingClient);

            return new ResponseEntity<>(savedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepos.deleteById(id);
    }

    @DeleteMapping(
            value = "/",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void deleteClient(@RequestBody Client c) {
        clientRepos.delete(c);
    }
}
