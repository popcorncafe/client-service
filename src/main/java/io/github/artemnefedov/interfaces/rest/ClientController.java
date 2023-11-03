package io.github.artemnefedov.interfaces.rest;

import io.github.artemnefedov.entity.Cart;
import io.github.artemnefedov.entity.Client;
import io.github.artemnefedov.entity.Product;
import io.github.artemnefedov.entity.Location;
import io.github.artemnefedov.entity.Store;
import io.github.artemnefedov.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/phones/{phoneNumber}")
    public ResponseEntity<Client> getClientByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return clientService.getClientByPhoneNumber(phoneNumber);
    }

    @GetMapping("/phones/{phoneNumber}/employees")
    public ResponseEntity<Boolean> hasEmployeeWithThisNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return clientService.hasEmployeeWithThisNumber(phoneNumber);
    }

    @PutMapping
    public ResponseEntity<Boolean> addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PatchMapping
    public ResponseEntity<Boolean> updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable("id") long id) {
        return clientService.deleteClient(id);
    }

    @GetMapping("/location")
    public ResponseEntity<List<Store>> getStoresByLocation(Location location) {
        return clientService.getStoresByLocation(location);
    }

    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getAllStores() {
        return clientService.getAllStores();
    }

    @GetMapping("/stores/{id}/products")
    public ResponseEntity<List<Product>> getProductsByStoreId(@PathVariable("id") UUID id) {
        return clientService.getProductsByStoreId(id);
    }

    @PutMapping("/carts")
    public ResponseEntity<UUID> addCart(@RequestBody Cart cart) {
        return clientService.addCart(cart);
    }

    @PatchMapping("/carts")
    public ResponseEntity<Boolean> updateCart(@RequestBody Cart cart) {
        return clientService.updateCart(cart);
    }
}