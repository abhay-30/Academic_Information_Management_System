package org.example;

import java.sql.*;

public class CourseGrades {

        String  CoursesGrades(String DB_URL, String USER, String PASS, String user_id) {
        Connection c = null;
        Statement stmt = null;

        System.out.printf("%-15s", "Course Code ");
        System.out.printf("%-70s", "Course Name");
        System.out.printf("%-15s", " Grade ");
        System.out.printf("%-15s", "Category");
        System.out.printf("%-15s", "Credits ");
        System.out.println();

        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String tquery = "select course_code,course_title, grade, category,credits from enrollment_list where student_id ="
                    + "\'" + user_id + "\'" + "and grade  is not null";

            ResultSet rs = stmt.executeQuery(tquery);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {

                    if (i == 2) {
                        System.out.printf("%-70s", rs.getString(i));
                    } else {
                        System.out.printf("%-15s", rs.getString(i));
                        // System.out.print(" ");
                    }
                }

                System.out.println();// Move to the next line to print the next row.

            }
            rs.close();
            return "Printed";

        } catch (SQLException e) {
           return   e.getMessage();

        }

    }
}
