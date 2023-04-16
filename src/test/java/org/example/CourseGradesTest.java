package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseGradesTest {


    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";
    //////for student/////////
    @Test
    void Printed(){
        CourseGrades cg = new CourseGrades();
        assertEquals("Printed",cg.CoursesGrades(DB_URL, USER, PASS, "2020csb1061"));
    }
    @Test
    void NotPrinted(){
        CourseGrades cg = new CourseGrades();
        assertNotEquals("Printed", cg.CoursesGrades(DB_URL, USER+"123", PASS,"2020csb1061"));
    }

}