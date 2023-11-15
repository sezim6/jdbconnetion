package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    private final Connection connection = Dbc.getConnection();
    private  final String CREATE=" create table  company(id serial primary key ,name varchar, ranking integer)";
    private  final String INSERT="insert into company(name,ranking) values (?,?)";
    private final String FIND_All="select  * from company";
    private final String FIND_BY_ID="select * from company where id = ?";
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
    public List<Company>findAll() throws SQLException {
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_All);
        List <Company>list = new ArrayList<>();
        while (resultSet.next()){
            Company  company = new Company();
            company.setId(resultSet.getLong("id"));
            company.setName(resultSet.getString("name"));
            company.setRanking(resultSet.getInt("ranking"));
            list.add(company);
        }
        return list;
    }
    public Company findById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
        preparedStatement.setLong(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
            Company company = new Company();
        while (resultSet.next()){
            company.setId(resultSet.getLong("id"));
            company.setName(resultSet.getString("name"));
            company.setRanking(resultSet.getInt("ranking"));
        }
        return company;
    }
}
