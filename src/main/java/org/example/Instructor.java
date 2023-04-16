package org.example;

import java.util.*;
import java.sql.*;

import org.example.CourseRegister;
import org.example.CourseDeRegister;
import org.example.MarksUpload;

public class Instructor {

        String Showlist(String DB_URL, String USER, String PASS, String course_code) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String approve_table = "SELECT * FROM approve_students where course_code = " + "\'" + course_code + "\'";
            ResultSet rs = stmt.executeQuery(approve_table);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();
            // System.out.println(rs.getString(0));
            int no = 1;

            while (rs.next()) {
                // Print one row
                // System.out.print(no + "-----> ");
                for (int i = 1; i <= columnsNumber; i++) {

                    System.out.print(rs.getString(i) + " "); // Print one element of a row

                }

                System.out.println();// Move to the next line to print the next row.
                no++;
            }
            rs.close();
            return "true";
        } catch (
                SQLException e) {
            System.err.println(e.getMessage());
            return "false";
        }
    }

        String ApproveStudent1(String DB_URL, String USER, String PASS, String course_code) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        String query = "update approve_students set approval_status =" + "\'" + "Pending Advisor apprval" + "\'" + " where course_code =" + "\'" + course_code + "\'";
        System.out.println(query);

        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            stmt.execute(query);
            stmt.close();
            c.close();
            System.out.println(" Approved successfully");
            return "true";
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return "false";
        }
    }

        String ApproveStudent2(String DB_URL, String USER, String PASS, String course_code, int year) {
        Connection c = null;
        Statement stmt = null;

        String query = "update approve_students set approval_status =" + "\'" + "Pending Advisor apprval" + "\'" + " where  entry_no like " + "\'" + year + "%\'" + "and course_code =" + "\'" + course_code + "\'";

        System.out.println(query);

        try {

            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            stmt.execute(query);
            stmt.close();
            c.close();

            System.out.println(" Approved successfully");
            System.out.println(" Approved successfully");
            return "true";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return "false";
        }
    }

        String ApproveStudent3(String DB_URL, String USER, String PASS, String course_code, String entryNumber) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);

        String query = "update approve_students set approval_status =" + "\'" + "Pending Advisor apprval" + "\'" + " where  entry_no=" + "\'" + entryNumber + "\'" + "and course_code =" + "\'" + course_code + "\'";

        System.out.println(query);

        try {

            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            stmt.execute(query);
            stmt.close();
            c.close();
            System.out.println(" Approved successfully");
            System.out.println(" Approved successfully");
            return "true";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return "false";
        }

    }
}








