package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CgpaTest {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";


    @Test
    void Check2(){
        Cgpa cg = new Cgpa();
        assertNotEquals(10.00,cg.CgpaCalculate(DB_URL +"123", USER, PASS,"2020csb1063"));
    }
    @Test
    void Check3(){
        Cgpa cg = new Cgpa();
        float expected = 6.92f;
        float actual = cg.CgpaCalculate(DB_URL, USER, PASS,"2020csb1063");
        float delta = 0.01f; // set a delta value for floating-point comparison
        assertEquals(expected, actual, delta);
    }

}