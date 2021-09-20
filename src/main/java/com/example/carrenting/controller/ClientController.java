package com.example.carrenting.controller;

import com.example.carrenting.entity.Client;
import com.example.carrenting.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/list")
    public String getAllClients(Model model){
        List<Client> clients = clientRepository.findAll();
        model.addAttribute( "clients", clients);
        return "/client/client-list";
    }



}
