package soa.dao;

import soa.entities.Client;

import java.util.List;

public interface IClientDao {

    Client save (Client c);
    List<Client> findAll();
    Client findOne(Long id);
    Client update (Client c);
    void delete (Long id);
    List<Client> findByDesignation( String mc);
    List<Client> findByDesignationAndPrix( String mc, double prix);
}
