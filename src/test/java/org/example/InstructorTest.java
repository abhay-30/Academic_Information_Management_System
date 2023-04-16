package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";

    @Test
    void showlisttrue() {
        Instructor it = new Instructor();
        assertEquals("true", it.Showlist(DB_URL, USER, PASS, "cs301"));
    }
    @Test
    void showlisttrue1() {
        Instructor it = new Instructor();
        assertEquals("true", it.Showlist(DB_URL+"123", USER, PASS, "cs301"));
    }

    @Test
    void Approve1() {
        Instructor it = new Instructor();
        assertEquals("true", it.ApproveStudent1(DB_URL, USER, PASS, "cs301"));
    }
    @Test
    void Approve11() {
        Instructor it = new Instructor();
        assertEquals("true", it.ApproveStudent1(DB_URL+"123", USER, PASS, "cs301"));
    }

    @Test
    void Approve2() {
        Instructor it = new Instructor();
        assertEquals("true", it.ApproveStudent2(DB_URL, USER, PASS, "cs301",2020));
    }
    @Test
    void Approve22() {
        Instructor it = new Instructor();
        assertEquals("true", it.ApproveStudent2(DB_URL+"123", USER, PASS, "cs301",2020));
    }


    @Test
    void Approve3() {
        Instructor it = new Instructor();
        assertEquals("true", it.ApproveStudent3(DB_URL, USER, PASS, "cs301", "2020csb1113"));
    }

    @Test
    void Approve33() {
        Instructor it = new Instructor();
        assertEquals("true", it.ApproveStudent3(DB_URL+"123", USER, PASS, "cs301", "2020csb1113"));
    }



}