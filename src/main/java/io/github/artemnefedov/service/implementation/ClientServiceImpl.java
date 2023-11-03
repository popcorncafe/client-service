package io.github.artemnefedov.service.implementation;

import io.github.artemnefedov.client.EmployeeServiceClient;
import io.github.artemnefedov.client.StoreServiceClient;
import io.github.artemnefedov.entity.Cart;
import io.github.artemnefedov.entity.Client;
import io.github.artemnefedov.entity.Product;
import io.github.artemnefedov.entity.Location;
import io.github.artemnefedov.entity.Store;
import io.github.artemnefedov.exsception.ResourceNotFound;
import io.github.artemnefedov.repository.ClientRepository;
import io.github.artemnefedov.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final StoreServiceClient storeClient;
    private final EmployeeServiceClient employeeClient;


    @Override
    public ResponseEntity<Client> getClientById(long id) {

        return ResponseEntity.ok(clientRepository.findClientById(id)
                .orElseThrow(() -> new ResourceNotFound("The client with the specified id was not found.")));
    }

    @Override
    public ResponseEntity<Client> getClientByPhoneNumber(String phoneNumber) {

        return ResponseEntity.ok(clientRepository.findClientByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourceNotFound("The client at the specified phone number was not found.")));
    }

    @Override
    public ResponseEntity<Boolean> addClient(Client client) {

        return ResponseEntity.ok(clientRepository.addClient(client) > 0);
    }

    @Override
    public ResponseEntity<Boolean> updateClient(Client client) {

        return ResponseEntity.ok(clientRepository.updateClient(client) > 0);
    }

    @Override
    public ResponseEntity<Boolean> deleteClient(long id) {

        return ResponseEntity.ok(clientRepository.deleteClient(id) > 0);
    }

    @Override
    public ResponseEntity<UUID> addCart(Cart cart) {
        return storeClient.addCart(cart);
    }

    @Override
    public ResponseEntity<Boolean> updateCart(Cart cart) {
        return storeClient.updateCart(cart);
    }

    @Override
    public ResponseEntity<List<Store>> getStoresByLocation(Location location) {

        return storeClient.getStoresByLocation(location);
    }

    @Override
    public ResponseEntity<List<Store>> getAllStores() {

        return storeClient.getAllStores();
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByStoreId(UUID id) {

        return storeClient.getProductsByStoreId(id);
    }

    @Override
    public ResponseEntity<Boolean> hasEmployeeWithThisNumber(String phoneNumber) {

        return employeeClient.hasEmployeeWithThisNumber(phoneNumber);
    }
}
