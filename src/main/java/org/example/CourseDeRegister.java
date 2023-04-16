package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CourseDeRegister {

        String  CourseDeRegistration(String DB_URL, String USER, String PASS,  String course_code) {
        Connection c = null;
        Statement stmt = null;
        String derigister_query = "delete from course_catalog where course_code =" + '\'' + course_code + '\'';
        System.out.println(derigister_query);

        try {

            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            stmt.execute(derigister_query);
            stmt.close();
            c.close();
            System.out.println("Course Successfully removed from course catalog");
            return "true";

        } catch (Exception e) {
            return "false";
        }



    }
}

