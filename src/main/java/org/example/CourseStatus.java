package org.example;
import java.sql.*;
public class CourseStatus {
        String  CourseStatusCheck(String DB_URL, String USER, String PASS, String user_id, String course_code) {
        Connection c = null;
        Statement stmt = null;
        String query = "select approval_status from approve_students where course_code=" + "\'" + course_code + "\'"
                + "and entry_no=" + "\'" + user_id + "\'";
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            System.out.println(" course status ----------------" + rs.getString(1));
            stmt.close();
            c.close();
            rs.close();
             return "true";

        } catch (Exception e) {
             return "false";
        }
    }
}
