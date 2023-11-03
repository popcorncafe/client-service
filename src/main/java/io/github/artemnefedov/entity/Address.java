package io.github.artemnefedov.entity;

import java.util.UUID;

public record Address(
        UUID id,
        String cityName,
        String streetName,
        int homeNumber,
        String homeLetter
) {
}

