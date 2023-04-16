package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CourseRegister {
         String  CourseRegistration(String DB_URL, String USER, String PASS, String course_code, String course_title, String course_ltp, String course_prereq){
        Connection c = null;
        Statement stmt = null;
        String register_query = "";
        register_query = "insert into course_catalog values " + "(" + '\'' + course_code + '\'' + "," + '\''
                + course_title + '\'' + "," + '\'' + course_ltp + '\'' + "," + '\'' + "{" + course_prereq + "}"
                + '\'' + ")";
         System.out.println(register_query);

        try {

            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            stmt.execute(register_query);
            stmt.close();
            c.close();

            System.out.println("Course registerd in course catalog succesfuuly ");
           return "true";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
          return "false";
        }
    }
}
