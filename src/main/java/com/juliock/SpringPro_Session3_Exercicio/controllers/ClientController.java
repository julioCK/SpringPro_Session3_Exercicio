package com.juliock.SpringPro_Session3_Exercicio.controllers;

import com.juliock.SpringPro_Session3_Exercicio.dto.ClientDTO;
import com.juliock.SpringPro_Session3_Exercicio.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO client = clientService.findClientByID(id);
        return ResponseEntity.ok().body(client);
    }
}
