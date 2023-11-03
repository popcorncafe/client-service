package io.github.artemnefedov.rowMapper;


import io.github.artemnefedov.entity.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        return Client.builder()
                .id(resultSet.getLong("id"))
                .firstname(resultSet.getString("firstname"))
                .surname(resultSet.getString("surname"))
                .username(resultSet.getString("username"))
                .phoneNumber(resultSet.getString("phone_number"))
                .build();
    }
}
