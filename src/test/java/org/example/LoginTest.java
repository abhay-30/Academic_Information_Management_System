package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";

    //////for student/////////
    @Test
    void StudentWrongEmailCheck() {
        Login lo = new Login();
        assertEquals("WrongEmail", lo.LoginCheck(DB_URL, USER, PASS, "student", "2030csb1061@iitrpr.ac.in", "123"));
    }

    @Test
    void StudentWrongPasswordCheck() {
        Login lo = new Login();
        assertEquals("NotLoggedIn", lo.LoginCheck(DB_URL, USER, PASS, "student", "2020csb1061@iitrpr.ac.in", "12345"));

    }

    @Test
    void StudentCorrectDetails() {
        Login lo = new Login();
        assertEquals("LoggedIn", lo.LoginCheck(DB_URL, USER, PASS, "student", "2020csb1061@iitrpr.ac.in", "123"));
        ;
    }

    ///for Instructor /////////
    void InstructorWrongEmailCheck() {
        Login lo = new Login();
        assertEquals("WrongEmail", lo.LoginCheck(DB_URL, USER, PASS, "instructor", "random@iitrpr.ac.in", "123"));
    }

    @Test
    void InstructorWrongPasswordCheck() {
        Login lo = new Login();
        assertEquals("NotLoggedIn", lo.LoginCheck(DB_URL, USER, PASS, "instructor", "apurvmudgal@iitrpr.ac.in", "12345"));

    }

    @Test
    void InstructorCorrectDetails() {
        Login lo = new Login();
        assertEquals("LoggedIn", lo.LoginCheck(DB_URL, USER, PASS, "instructor", "apurvmudgal@iitrpr.ac.in", "123"));
        ;
    }

    ////////for academics ///////////////////
    void AcadWrongEmailCheck() {
        Login lo = new Login();
        assertEquals("WrongEmail", lo.LoginCheck(DB_URL, USER, PASS, "academics", "2030csb1061@iitrpr.ac.in", "123"));
    }

    @Test
    void AcadWrongPasswordCheck() {
        Login lo = new Login();
        assertEquals("NotLoggedIn", lo.LoginCheck(DB_URL, USER, PASS, "academics", "anilshukla@iitrpr.ac.in", "12345"));

    }

    @Test
    void AcadCorrectDetails() {
        Login lo = new Login();
        assertEquals("LoggedIn", lo.LoginCheck(DB_URL, USER, PASS, "academics", "anilshukla@iitrpr.ac.in", "123"));

    }
    @Test
    void ErrorCheck() {
        Login lo = new Login();
        assertNotEquals("LoggedIn", lo.LoginCheck(DB_URL + "123", USER, PASS, "academics", "anilshukla@iitrpr.ac.in", "123"));

    }
}