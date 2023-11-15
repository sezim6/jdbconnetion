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
        PresidentRepository president = new PresidentRepository();
        president.create();
        President president1 = new President("Sadyr","Zhaparov");
        president.save(president1);
        StudentRepository student = new StudentRepository();
        student.create();
        Student student1 = new Student("Sezim Jyrgalbekova",17);
        student.save(student1);
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
