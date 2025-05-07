package com.juliock.SpringPro_Session3_Exercicio.controllers;

import com.juliock.SpringPro_Session3_Exercicio.dto.ClientDTO;
import com.juliock.SpringPro_Session3_Exercicio.services.ClientService;
import com.juliock.SpringPro_Session3_Exercicio.services.Exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping(value = "")
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        Page<ClientDTO> page = clientService.findAllClients(pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto) {

        dto = clientService.insertClient(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
        dto = clientService.updateClient(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            HttpStatus statusCode = HttpStatus.NO_CONTENT;
            return ResponseEntity.status(statusCode).build();
        }
        catch(IllegalArgumentException e) {
            throw new ResourceNotFoundException("Client with provided ID does not exists");
        }
    }
}
