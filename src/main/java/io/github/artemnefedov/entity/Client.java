package io.github.artemnefedov.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private Long id;
    private String firstname;
    private String surname;
    private String username;
    private String phoneNumber;
}