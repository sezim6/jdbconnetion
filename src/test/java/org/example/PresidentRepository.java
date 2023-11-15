package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PresidentRepository {
    private final Connection connection = Dbc.getConnection();
    private final String CREATE = " create table  president(id serial primary key ,name varchar, lastname varchar)";
    private final String INSERT = "insert into president (name,lastname) values (?,?)";

    public PresidentRepository() throws SQLException {
    }

    public void create() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE);
        System.out.println("Created!");
    }
    public void save(President president) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setString(1,president.getName());
        preparedStatement.setString(2, president.getLastname());
        preparedStatement.executeUpdate();
    }
}

