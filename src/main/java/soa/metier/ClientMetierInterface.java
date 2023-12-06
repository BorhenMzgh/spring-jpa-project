package soa.metier;

import soa.entities.Client;

import java.util.List;

public interface ClientMetierInterface {
    public void ajouterClient(Client client) ;
    public List<Client> listeClients() ;
}