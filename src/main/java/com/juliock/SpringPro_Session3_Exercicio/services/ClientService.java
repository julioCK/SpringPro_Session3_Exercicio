package com.juliock.SpringPro_Session3_Exercicio.services;

import com.juliock.SpringPro_Session3_Exercicio.dto.ClientDTO;
import com.juliock.SpringPro_Session3_Exercicio.entities.Client;
import com.juliock.SpringPro_Session3_Exercicio.repositories.ClientRepository;
import com.juliock.SpringPro_Session3_Exercicio.services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientDTO findClientByID(Long id) {
        Optional<Client> clientOptional =  clientRepository.findById(id);
        Client client = clientOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found: ID " + id));
        return new ClientDTO(client);
    }

    @Transactional
    public Page<ClientDTO> findAllClients(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }
}
