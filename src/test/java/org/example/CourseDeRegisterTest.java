package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseDeRegisterTest {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";

    ///////show courses test ////////////////
    @Test
    void deregistersuccessful(){
        CourseDeRegister cg = new CourseDeRegister();
        assertEquals("true",cg.CourseDeRegistration(DB_URL, USER, PASS, "cs306"));
    }
    @Test
    void deregisterunsuccessful(){
        CourseDeRegister cg = new CourseDeRegister();
        assertEquals("false",cg.CourseDeRegistration(DB_URL+"123", USER, PASS,"cs306" ));
    }


}