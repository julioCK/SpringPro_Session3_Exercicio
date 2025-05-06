package com.juliock.SpringPro_Session3_Exercicio.services;

import com.juliock.SpringPro_Session3_Exercicio.dto.ClientDTO;
import com.juliock.SpringPro_Session3_Exercicio.entities.Client;
import com.juliock.SpringPro_Session3_Exercicio.services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juliock.SpringPro_Session3_Exercicio.repositories.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO findClientByID(Long id) {
        Optional<Client> clientOptional =  clientRepository.findById(id);
        Client client = clientOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found: id " + id));
        return ClientToDTO(client);
    }

    private ClientDTO ClientToDTO(Client client) {
        return new ClientDTO(client.getName(),
                             client.getCpf(),
                             client.getIncome(),
                             client.getBirthDate(),
                             client.getChildren());
    }
}
