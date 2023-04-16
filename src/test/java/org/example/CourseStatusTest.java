package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseStatusTest {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";

    @Test
    void statuschecktrue(){
        CourseStatus cs = new CourseStatus();
        assertEquals("true",cs.CourseStatusCheck(DB_URL, USER,PASS, "2020csb1113", "cs301"));
    }
    @Test
    void statuscheckfalse(){
        CourseStatus cs = new CourseStatus();
        assertEquals("false",cs.CourseStatusCheck(DB_URL+"123", PASS,USER, "2020csb1069", "cs102"));
    }

}