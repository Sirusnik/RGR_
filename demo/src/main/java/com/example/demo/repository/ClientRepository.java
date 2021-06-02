package com.example.demo.repository;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientById(Long id);

    Client findClientByName(String name);

    Client findClientByAdress(String adress);

    Client findClientByTel(String tel);

}
