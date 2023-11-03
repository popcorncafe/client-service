package io.github.artemnefedov.repository.impl;

import io.github.artemnefedov.entity.Client;
import io.github.artemnefedov.repository.ClientRepository;
import io.github.artemnefedov.rowMapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientDataAccessService implements ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public int addClient(Client client) {

        var sql = """
                INSERT INTO client (id, firstname, surname, username, phone_number)
                VALUES ( ?, ?, ?, ?, ?);
                """;

        return jdbcTemplate.update(sql,
                client.getId(),
                client.getFirstname(),
                client.getSurname(),
                client.getUsername(),
                client.getPhoneNumber());
    }

    @Override
    @Transactional
    public int updateClient(Client client) {

        var sql = """
                UPDATE client
                SET
                firstname = ?,
                surname = ?,
                username = ?,
                phone_number = ?
                WHERE id = ?;
                """;

        return jdbcTemplate.update(sql,
                client.getFirstname(),
                client.getSurname(),
                client.getUsername(),
                client.getPhoneNumber(),
                client.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findClientByPhoneNumber(String phoneNumber) {

        var sql = """
                SELECT * FROM client WHERE phone_number = ?
                LIMIT 1;
                """;

        return jdbcTemplate.query(sql, new ClientMapper(), phoneNumber)
                .stream()
                .findFirst();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findClientById(long id) {

        var sql = "SELECT * FROM client WHERE id = ?;";

        return jdbcTemplate.query(sql, new ClientMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    @Transactional
    public int deleteClient(long id) {

        var sql = "DELETE FROM client WHERE id = ?;";

        return jdbcTemplate.update(sql, id);
    }
}
