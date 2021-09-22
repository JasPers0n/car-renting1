package com.example.carrenting.service;

import com.example.carrenting.entity.Client;
import com.example.carrenting.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public void saveClient(Client client) {
        this.clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.getById(id);
    }

    public void deleteClientById(Long id) {
        this.clientRepository.deleteById(id);
    }
}
