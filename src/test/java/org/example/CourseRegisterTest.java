package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRegisterTest {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";

    ///////show courses test ////////////////
    @Test
    void registersuccessful(){
        CourseRegister cr = new CourseRegister();
        assertEquals("true",cr.CourseRegistration(DB_URL, USER, PASS, "cs306","Theory of Computation","3-0-2","cs201"  ));
    }
    @Test
    void registerunsuccessful(){
        CourseRegister cr = new CourseRegister();
        assertEquals("false",cr.CourseRegistration(DB_URL+"123", USER, PASS,"cs306","Theory of Computation","3-0-2","cs201"  ));
    }


}