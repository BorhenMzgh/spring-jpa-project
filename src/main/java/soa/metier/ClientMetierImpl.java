package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Client;
import soa.repository.ClientRepository;

import java.util.List;

@Service
public class ClientMetierImpl implements ClientMetierInterface {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void ajouterClient(Client client) {
        clientRepository.save(client);
    }


    @Override
    public List<Client> listeClients() {
        return clientRepository.findAll();
    }

    // Add other methods as needed for managing clients
}