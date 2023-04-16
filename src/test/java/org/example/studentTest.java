package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class studentTest {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";

    ///////show courses test ////////////////
    @Test
    void ShowCoursePrinted(){
        student st = new student();
        assertEquals("Printed",st.showAvailableCourses(DB_URL, USER, PASS));
    }
    @Test
    void ShowCourseNotPrinted(){
        student st = new student();
        assertNotEquals("Printed", st.showAvailableCourses(DB_URL+"123", USER+"123", PASS));
    }
//
//
//
//    //////////////Apply course test////////////
    @Test
    void cgpacriteriacheck(){
        student st = new student();
        assertEquals("cgpa",st.ApplyCourse(DB_URL, USER, PASS, "2020csb1113", "cs101"));
    }
    @Test
    void prerequistes(){
        student st = new student();
        assertEquals("pre",st.ApplyCourse(DB_URL, USER, PASS, "2020csb1113", "cs302"));
    }

    @Test
    void creditlimit(){
        student st = new student();
        assertEquals("success",st.ApplyCourse(DB_URL, USER, PASS, "2020csb1115", "cs301"));
    }

}