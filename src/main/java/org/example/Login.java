package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class Login {
        String LoginCheck(String DB_URL, String USER, String PASS, String role, String email_id, String pass) {
        Connection c = null;
        Statement stmt = null;

        Scanner sc = new Scanner(System.in);
        String user_check = "select count(*) from login_details where email = " + "\'" + email_id + "\'" + " and role="
                + "\'" + role + "\'";
        int user_count = 0;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(user_check);
            rs.next();
            user_count = rs.getInt(1);
            stmt.close();
            c.close();
            rs.close();

        } catch (Exception e) {

            return e.getClass().getName() + ": " + e.getMessage();
        }
        if (user_count == 0) {

            return "WrongEmail";
        }

        String real_pass_query = "select password from login_details where email = " + "\'" + email_id + "\'"
                + " and role="
                + "\'" + role + "\'";
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(real_pass_query);
            rs.next();
            String real_pass = rs.getString(1);

            stmt.close();
            c.close();
            rs.close();
            if (real_pass.equals(pass)) {
                return "LoggedIn";
            } else {
                return "NotLoggedIn";
            }

        } catch (Exception e) {
            return e.getClass().getName() + ": " + e.getMessage();
        }

    }
}