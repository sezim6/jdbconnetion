package org.example;

import java.sql.*;

public class CompanyRepository {
    private final Connection connection = Dbc.getConnection();
    private  final String CREATE=" create table  company(id serial primary key ,name varchar, ranking integer)";
    private  final String INSERT="insert into company(name,ranking) values (?,?)";
    public CompanyRepository() throws SQLException {
    }
    public  void create () throws SQLException {
    Statement statement = connection.createStatement();
    statement.executeUpdate(CREATE);
        System.out.println("Created!");
    }
    public  void save ( Company company) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setString(1, company.getName());
        preparedStatement.setInt(2,company.getRanking());
        preparedStatement.executeUpdate();
    }
}
