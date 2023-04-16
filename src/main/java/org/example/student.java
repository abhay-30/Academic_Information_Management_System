package org.example;

import java.util.*;
import java.sql.*;

public class student {
    String showAvailableCourses(String DB_URL, String USER, String PASS) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String grade_table = "SELECT * FROM offered_courses";
            ResultSet rs = stmt.executeQuery(grade_table);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();
            int no = 1;

            System.out.printf("%-20s", "Course Code ");
            System.out.printf("%-80s", "Course Name");

            System.out.printf("%-20s", "Credit");

            System.out.printf("%-20s", "Category");

            System.out.printf("%-20s", "Cgpa Required");
            System.out.printf("%-20s", "Pre-requiste Courses");
            System.out.println();
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {

                    if (i == 2) {
                        System.out.printf("%-80s", rs.getString(i));
                    } else {
                        System.out.printf("%-20s", rs.getString(i));
                        // System.out.print(" ");
                    }
                }

                System.out.println();// Move to the next line to print the next row.
                no++;
            }
            rs.close();
            System.out.println();

            return "Printed";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    String ApplyCourse(String DB_URL, String USER, String PASS, String user_id, String course_code) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        ////////////////////////////////// cgpa criteria//////////////////
        float required_cgpa = 0;
        Cgpa cg = new Cgpa();
        float current_cgpa = cg.CgpaCalculate(DB_URL, USER, PASS, user_id);
        String cpgaquery = "select cgpa_criteria from  offered_courses where course_code =" + "\'" + course_code + "\'";

        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(cpgaquery);
            rs.next();
            required_cgpa = rs.getFloat(1);

            stmt.close();
            c.close();
            rs.close();
        } catch (Exception e) {
            return e.getMessage();

        }

        if (current_cgpa < required_cgpa) {
            System.out.println("Cgpa criteria not fullfilled !!!");
            System.out.print("Current Cgpa :");
            System.out.println(current_cgpa);
            return "cgpa";
        } else {
            /////////////////////////// prereqiustes check //////////////////////////
            String pre_req_query = "select  prerequisites from offered_courses where course_code =" + "\'" + course_code + "\'";
            String pre_req = "{}";
            try {

                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(pre_req_query);
                rs.next();
                pre_req = rs.getString(1);
//                System.out.println(pre_req);
                stmt.close();
                c.close();
                rs.close();
            } catch (Exception e) {
                return e.getMessage();
            }

            pre_req = pre_req.substring(1, pre_req.length() - 1);
            System.out.println(pre_req);

            String str = pre_req;
            String[] res = str.split("[,]", 0);
           int count=0;
            for (String myStr : res) {

                String chek_query = "select count(*) from enrollment_list where student_id=" + "\'" + user_id + "\'" + " and  course_code=" + "\'" + myStr + "\'";
                int k = 0;
                try {
                    c = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery(chek_query);
                    rs.next();
                    k = rs.getInt(1);
                    stmt.close();
                    c.close();
                    rs.close();
                    if (k == 0) {
                        count++;

                    }
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
            if(count!=0){
                return "pre";
            }

            float registerid_credits = 0;
            float course_credit = 0;
            String register_crdit_query = "select  credits from enrollment_list where course_status =" + "\'" + "running" + "\'" + "and student_id="
                    + "\'" + user_id + "\'";
            try {
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();

                ResultSet rs = stmt.executeQuery(register_crdit_query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int columnsNumber = rsmd.getColumnCount();

                while (rs.next()) {
                    // Print one row
                    for (int i = 1; i <= columnsNumber; i++) {

                        registerid_credits += rs.getFloat(i);
                    }
                }
                rs.close();
            } catch (SQLException e) {
                return e.getMessage();
            }
            String course_cred_query = "select credits from  offered_courses where course_code =" + "\'" + course_code + "\'";
            try {
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(course_cred_query);
                rs.next();
                course_credit = rs.getFloat(1);
                stmt.close();
                c.close();
                rs.close();
            } catch (Exception e) {
                return e.getMessage();
            }
            /////////////last two sems /////////////////////////
            details obj = new details();
            int current_year = obj.current_year;
            String current_sem = obj.current_sem;
            String last_sem = "";
            String second_last_sem = "";
            int last_year;
            int second_last_year;

            if (current_sem == "I") {
                last_year = current_year - 1;
                last_sem = "II";
                second_last_year = current_year - 1;
                second_last_sem = "I";
            } else {
                last_year = current_year;
                last_sem = "I";
                second_last_year = current_year - 1;
                second_last_sem = "II";

            }

            String query1 = "Select  sum(credits) from enrollment_list where student_id=" + "\'" + user_id + "\'" + "and year =" + "\'" + last_year + "\'" + "and sem=" + "\'" + last_sem +
                    "\'" + "and course_status= " + "\'" + "completed" + "\'";

            String query2 = "Select sum(credits) from enrollment_list where student_id=" + "\'" + user_id + "\'" + "and year =" + "\'" + second_last_year + "\'" + "and sem=" + "\'" + second_last_sem +
                    "\'" + "and course_status= " + "\'" + "completed" + "\'";

//            System.out.println(query2);
//            System.out.println(query1);
            float last_credit=0;
            float second_last_credit=0;
            try {
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(query1);
                rs.next();
                course_credit = rs.getFloat(1);
                stmt.close();
                c.close();
                rs.close();
            } catch (Exception e) {
                return e.getMessage();
            }


            if (course_credit + registerid_credits <= 24) {

                String insert_query = "INSERT INTO approve_students values  ( " + "\'" + user_id + "\'" + ",\'" + course_code + "\'" + "," + "\'" + "Pendig  Instructor approval " + "\' )";
                System.out.println(insert_query);
                try {
                    c = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = c.createStatement();
                    stmt.execute(insert_query);
                    stmt.close();
                    c.close();

                    System.out.println("Pending Instructor approval .");
                    return "success";

                } catch (Exception e) {
                    return e.getMessage();
                }
            } else {
                System.out.println("Cannot enroll Credit limit exceedeed !!!");
                return "credit";

            }

        }

    }
}


