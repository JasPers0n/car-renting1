package com.example.carrenting.controller;

import com.example.carrenting.entity.Car;
import com.example.carrenting.entity.Client;
import com.example.carrenting.entity.Employee;
import com.example.carrenting.repository.ClientRepository;
import com.example.carrenting.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client-list")
    public String viewClientList(Model model) {
        model.addAttribute("listClients", clientService.getAll());
        return "/client/client-list";
    }

    @GetMapping("/showAddClientForm")
    public String showAddClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "/client/client-add-form";
    }

    @PostMapping("/saveClient")
    public String saveClient(@Validated @ModelAttribute("client") Client client, BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           return "/client/client-add-form";
       }else{
        clientService.saveClient(client);
        return "redirect:/client/client-list";
    }
    }

    @GetMapping("/showClientUpdateForm/{id}")
    public String showClientUpdateForm(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "/client/client-update-form";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return "redirect:/client/client-list";
    }

}