package io.github.artemnefedov.client;

import io.github.artemnefedov.entity.Cart;
import io.github.artemnefedov.entity.Product;
import io.github.artemnefedov.entity.Location;
import io.github.artemnefedov.entity.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient("store-service")
public interface StoreServiceClient {

    @PutMapping("/carts")
    ResponseEntity<UUID> addCart(@RequestBody Cart cart);

    @PatchMapping("/carts")
    ResponseEntity<Boolean> updateCart(@RequestBody Cart cart);

    @GetMapping("/carts/{id}")
    ResponseEntity<List<Cart>> getCartsByClientId(@PathVariable("id") UUID id);

    @GetMapping
    ResponseEntity<List<Store>> getAllStores();

    @GetMapping("/{id}/products")
    ResponseEntity<List<Product>> getProductsByStoreId(@PathVariable("id") UUID id);

    @GetMapping("/location")
    ResponseEntity<List<Store>> getStoresByLocation(@RequestBody Location location);
}
