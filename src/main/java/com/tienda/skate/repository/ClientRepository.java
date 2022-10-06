package com.tienda.skate.repository;

import com.tienda.skate.model.Client;
import com.tienda.skate.repository.interfaces.ClientRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientRepositoryInterface clientRepositoryInterface;

    public ClientRepository() {
    }

    public List<Client> getAll(){
        return (List<Client>) clientRepositoryInterface.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepositoryInterface.findById(id);
    }
    public Client save(Client client){
        return clientRepositoryInterface.save(client);
    }
    public void delete(Client client){
        clientRepositoryInterface.delete(client);
    }
}
