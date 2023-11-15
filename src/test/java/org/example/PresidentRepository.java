package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PresidentRepository {
    private final Connection connection = Dbc.getConnection();
    private final String CREATE = " create table  president(id serial primary key ,name varchar, lastname varchar)";
    private final String INSERT = "insert into president (name,lastname) values (?,?)";
    private final String DELETE_ALL = "truncate table president";
    private final String DELETE_BY_ID = "delete from president where id=?";

    public PresidentRepository() throws SQLException {
    }

    public void create() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE);
        System.out.println("Created!");
    }

    public void save(President president) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setString(1, president.getName());
        preparedStatement.setString(2, president.getLastname());
        preparedStatement.executeUpdate();
    }

    public void deleteAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(DELETE_ALL);
        System.out.println("All deleted");
    }

    public void deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
        System.out.println("deleted id : " + id);
    }
}

