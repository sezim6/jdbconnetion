package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.SQLException;
public class AppTest
    extends TestCase
{
    public AppTest( String testName ) throws SQLException {
        super( testName );
        CompanyRepository company = new CompanyRepository();
        company.create();
        Company company1 = new Company("Apple",8);
        company.save(company1);
        System.out.println(company.findAll());
        System.out.println(company.findById(2L));
        PresidentRepository president = new PresidentRepository();
        president.create();
        President president1 = new President("Sadyr","Zhaparov");
        president.save(president1);
        president.deleteAll();
        president.deleteById(3L);
        StudentRepository student = new StudentRepository();
        student.create();
        Student student1 = new Student("Sezim Satybaldyeva",17);
        student.save(student1);
        student.deleteById(1L);
        student.deleteAll();
    }
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    public void testApp()
    {
        assertTrue( true );
    }

}
