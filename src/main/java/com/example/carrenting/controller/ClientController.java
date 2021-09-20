package com.example.carrenting.controller;

import com.example.carrenting.entity.Client;
import com.example.carrenting.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/client-list")
    public String GetAllClients(Model model){
        List<Client> clients = clientRepository.findAll();
        model.addAttribute( "client", clients);
        return "/client-list";
    }



}
