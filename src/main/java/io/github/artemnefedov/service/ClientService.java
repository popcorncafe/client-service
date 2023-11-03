package io.github.artemnefedov.service;

import io.github.artemnefedov.entity.Cart;
import io.github.artemnefedov.entity.Client;
import io.github.artemnefedov.entity.Product;
import io.github.artemnefedov.entity.Location;
import io.github.artemnefedov.entity.Store;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    ResponseEntity<Client> getClientById(long id);

    ResponseEntity<Client> getClientByPhoneNumber(String phoneNumber);

    ResponseEntity<Boolean> addClient(Client client);

    ResponseEntity<Boolean> updateClient(Client client);

    ResponseEntity<Boolean> deleteClient(long id);

    ResponseEntity<UUID> addCart(Cart cart);

    ResponseEntity<Boolean> updateCart(Cart cart);

    ResponseEntity<List<Store>> getStoresByLocation(Location location);

    ResponseEntity<List<Store>> getAllStores();

    ResponseEntity<List<Product>> getProductsByStoreId(UUID id);

    ResponseEntity<Boolean> hasEmployeeWithThisNumber(String phoneNumber);
}
