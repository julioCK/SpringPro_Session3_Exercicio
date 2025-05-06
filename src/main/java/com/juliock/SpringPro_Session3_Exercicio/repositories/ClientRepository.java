package com.juliock.SpringPro_Session3_Exercicio.repositories;

import com.juliock.SpringPro_Session3_Exercicio.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
