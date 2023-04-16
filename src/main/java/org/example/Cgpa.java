package org.example;

import java.sql.*;
import java.util.*;
import java.text.DecimalFormat;

public class Cgpa {

      float CgpaCalculate(String DB_URL, String USER, String PASS, String user_id) {
        try {
            Connection c = null;
            Statement stmt = null;
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String grade_table = "SELECT * FROM enrollment_list where student_id =" + "\'" + user_id + "\'"
                    + "and course_status = " + "\'" + "completed" + "\'";
            ResultSet rs = stmt.executeQuery(grade_table);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            float total_credits = 0;
            float current_cred = 0;
            float cur_sum = 0;
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {

                    if (i == 4) {
                        current_cred = rs.getFloat(i);
//                        System.out.println(current_cred);
                        total_credits += current_cred;
                    }
                    if (i == 8) {
                        String grade = rs.getString(i);
                        if (grade.equals("A")) {
                            cur_sum += 10.0 * current_cred;
                        } else if (grade.equals("A-")) {
                            cur_sum += 9.0 * current_cred;
                        } else if (grade.equals("B")) {
                            cur_sum += 8.0 * current_cred;
                        } else if (grade.equals("B-")) {
                            cur_sum += 7.0 * current_cred;
                        } else if (grade.equals("C")) {
                            cur_sum += 6.0 * current_cred;
                        } else if (grade.equals("C-")) {
                            cur_sum += 5.0 * current_cred;
                        } else if (grade.equals("D")) {
                            cur_sum += 4.0 * current_cred;
                        }

                    }
                }

            }
            rs.close();
            System.out.println(cur_sum);
            System.out.println(total_credits);


            float number = cur_sum / total_credits;
            String formatString = String.format("%.2f", number);
            float roundedNumber = Float.parseFloat(formatString);
            System.out.println(roundedNumber);
            return roundedNumber;


        } catch (SQLException e) {
            System.err.println(e.getMessage());
            float number = 0;
            String formatString = String.format("%.2f", number);
            float roundedNumber = Float.parseFloat(formatString);
             return roundedNumber;
        }

    }
}
