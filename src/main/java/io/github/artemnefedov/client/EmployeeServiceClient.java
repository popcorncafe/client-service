package io.github.artemnefedov.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("employee-service")
public interface EmployeeServiceClient {

    @GetMapping("/phones/{phoneNumber}")
    ResponseEntity<Boolean> hasEmployeeWithThisNumber(@PathVariable("phoneNumber") String phoneNumber);
}
