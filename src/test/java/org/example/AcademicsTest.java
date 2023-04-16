package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademicsTest {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";

    @Test
    void showlisttrue() {
        Academics ac = new Academics();
        assertEquals("true", ac.showlist(DB_URL, USER, PASS, "cs101"));
    }

    @Test
    void showlisttrue1() {
        Academics ac = new Academics();
        assertEquals("false", ac.showlist(DB_URL + "123", USER, PASS, "cs101"));
    }

    @Test
    void Approve1() {
        Academics ac = new Academics();
        assertEquals("true", ac.Approve1(DB_URL, USER, PASS, "cs101"));
    }

    @Test
    void Approve12() {
        Academics ac = new Academics();
        assertEquals("false", ac.Approve1(DB_URL + "123", USER, PASS, "cs101"));
    }

    @Test
    void Approve2() {
        Academics ac = new Academics();
        assertEquals("true", ac.Approve2(DB_URL, USER, PASS, "cs101", 2020));
    }

    @Test
    void Approve21() {
        Academics ac = new Academics();
        assertEquals("false", ac.Approve2(DB_URL + "123", USER, PASS, "cs101", 2020));
    }

    @Test
    void Approve3() {
        Academics ac = new Academics();
        assertEquals("true", ac.Approve3(DB_URL, USER, PASS, "cs101", "2020csb1061"));
    }

    @Test
    void Approve31() {
        Academics ac = new Academics();
        assertEquals("false", ac.Approve3(DB_URL + "123", USER, PASS, "cs101", "2020csb1061"));
    }

    @Test
    void transcript1()
    {
        Academics ac = new Academics();
        assertEquals("false", ac.GenerateTranscript(DB_URL, USER, PASS, "2020csb1064"));
    }

    @Test
    void transcript2() {

        Academics ac = new Academics();
        assertEquals("false", ac.GenerateTranscript(DB_URL, USER, PASS, "2020csb1061"));
    }

    @Test
    void transcript3() {
        Academics ac = new Academics();
        assertEquals("false", ac.GenerateTranscript(DB_URL, USER, PASS, "2020csb1063"));
    }

    @Test
    void transcript4() {
        Academics ac = new Academics();
        assertEquals("false", ac.GenerateTranscript(DB_URL + "123", USER, PASS, "2020csb1063"));
    }

    @Test
    void transcript5() {
        Academics ac = new Academics();
        assertEquals("true", ac.GenerateTranscript(DB_URL, USER, PASS, "2020csb1111"));
    }
    @Test
    void transcript6() {
        Academics ac = new Academics();
        assertEquals("false", ac.GenerateTranscript(DB_URL + "123", USER, PASS, "2020csb1111"));
    }

    @Test
    void transcript4r() {
        Academics ac = new Academics();
        assertEquals("false", ac.GenerateTranscript(DB_URL , USER, PASS, "2020csb1113"));
    }


    @Test
    void checkgraduation(){
        Academics ac = new Academics();
        assertEquals("false", ac.graduationcheck(DB_URL, USER, PASS, "2020csb1113"));
    }

    @Test
    void checkgraduation2(){
        Academics ac = new Academics();
        assertEquals("false", ac.graduationcheck(DB_URL, USER, PASS, "2020csb10633"));
    }


}