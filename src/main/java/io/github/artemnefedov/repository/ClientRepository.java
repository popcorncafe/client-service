package io.github.artemnefedov.repository;

import io.github.artemnefedov.entity.Client;

import java.util.Optional;

public interface ClientRepository {

    int addClient(Client client);

    int updateClient(Client client);

    Optional<Client> findClientByPhoneNumber(String phoneNumber);

    Optional<Client> findClientById(long id);

    int deleteClient(long id);
}
