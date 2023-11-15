package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRepository {
    private final Connection connection = Dbc.getConnection();
    private final String CREATE = " create table  student(id serial primary key ,info varchar, age integer)";
    private final String INSERT = "insert into  student (info,age)values (?,?)";
    private final String DELETE_BY_ID = "delete  from student  where id =?";
    private  final String DELETE_ALL="truncate table student";
    public StudentRepository() throws SQLException {
    }

    public void create() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE);
        System.out.println("Created!");
    }

    public void save(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setString(1, student.getInfo());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.executeUpdate();
    }

    public void deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();
        System.out.println("deleted id : "+id);

    }
    public void deleteAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(DELETE_ALL);
        System.out.println("All deleted");
    }
}

