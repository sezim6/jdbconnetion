package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ) throws SQLException {
        super( testName );
//        CompanyRepository company = new CompanyRepository();
//        company.create();
//        Company company1 = new Company("Apple",8);
//        company.save(company1);
//        PresidentRepository president = new PresidentRepository();
//        president.create();
//        President president1 = new President("Sadyr","Zhaparov");
//        president.save(president1);
        StudentRepository student = new StudentRepository();
        student.create();
        Student student1 = new Student("Sezim Jyrgalbekova",17);
        student.save(student1);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

}