package org.example;

import java.util.*;
import java.sql.*;

public class Academics {
    String GenerateTranscript(String DB_URL, String USER, String PASS, String user_id) {
        Connection c = null;
        Statement stmt = null;
        int yoy;
        String category = "";
        int pc = 0, pe = 0, el = 0;

        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String user_detail = "SELECT *FROM student_details where user_id =" + "\'"
                    + user_id + "\'";
            ResultSet rs = stmt.executeQuery(user_detail);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {

                System.out.println(
                        "*******************************************transcript****************************************************");
                for (int i = 1; i <= columnsNumber; i++) {

                    if (i == 1) {
                        System.out.print("Entry No: ");
                        System.out.print(rs.getString(i));
                        System.out.print("         ");
                    }

                    if (i == 2) {
                        System.out.print("email: ");
                        System.out.print(rs.getString(i));
                        System.out.print("        ");
                    }

                    if (i == 3) {
                        System.out.print("Name: ");
                        System.out.print(rs.getString(i));
                        System.out.print(" ");

                    }
                    if (i == 4) {
                        System.out.println(rs.getString(i));

                    }
                    if (i == 7) {
                        System.out.println();
                        System.out.print("Degree: ");
                        System.out.print(rs.getString(i));
                        System.out.print("      ");
                    }
                    if (i == 8) {
                        System.out.print("Department :");
                        System.out.print(rs.getString(i));
                        System.out.println("       ");
                    }

                    if (i == 9) {
                        System.out.println();
                        System.out.print("Year of entry : ");
                        String temp = rs.getString(i);
                        System.out.print(temp);
                        yoy = Integer.parseInt(temp);
                        // System.out.println(yoy);
                    }
                }
                System.out.println();// Move to the next line to print the next row.
            }
            rs.close();
            System.out.println();
            System.out.println("Academics for Credit Courses");
            System.out.println();

        } catch (SQLException e) {
            return e.getMessage();
        }

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
                        System.out.printf("%-80s", rs.getString(i));
                    } else if (i == 5) {
                        float x = rs.getFloat(i);
                        String s = Float.toString(x);
                        System.out.printf("%-10s", s);

                    } else {
                        System.out.printf("%-10s", rs.getString(i));
                    }


                    //////////// calculating credits to check the graduation
                    if (i == 4) {
                        category = rs.getString(i);
                    }
                    if (i == 5) {

                        if (category.equals("PC")) {

                            pc += Integer.parseInt(rs.getString(i));
                        } else if (category.equals("PE")) {
                            pe += Integer.parseInt(rs.getString(i));
                        } else if (category.equals("EL")) {
                            el += Integer.parseInt(rs.getString(i));
                        }
                    }
                }

                System.out.println();// Move to the next line to print the next row.
            }
            rs.close();
        } catch (SQLException e) {
            return e.getMessage();
        }
        System.out.println();

        if (pc == 60 && pe == 30 && el == 30) {
            String query1 = "select count(*) from enrollment_list where course_code=" + "\'" + "CP302" + "\'";
            String query2 = "select count(*) from enrollment_list where course_code=" + "\'" + "CP303" + "\'";
            int x = 0, y = 0;
            try {
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(query1);
                rs.next();
                x = rs.getInt(1);
                stmt.close();
                c.close();
                rs.close();
                // break;
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                return e.getMessage();
            }
            try {
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(query2);
                rs.next();
                y = rs.getInt(1);
                stmt.close();
                c.close();
                rs.close();
                // break;

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                return e.getMessage();
            }

            if (x == 1 && y == 1) {

                System.out.println(
                        "*********************************************Graduation Completed !!!***********************************************");
                return "true";
            } else {

                System.out.println("Capstone not done !!!");

                System.out.println(

                        "*********************************************Not Graduated !!!***********************************************");
                return "false";
            }
        } else {
            System.out.println("Total program core credits left : ");
            System.out.println(60 - pc);
            System.out.println("Total program elective credits left : ");
            System.out.println(30 - pe);
            System.out.println("Total elective  credits left : ");
            System.out.println(30 - el);
            System.out.println(
                    "*********************************************Not Graduated !!!***********************************************");
            return "false";
        }


    }

    ////// checking the elective requirements for graduation ///////////////

    String graduationcheck(String DB_URL, String USER, String PASS, String user_id) {
        Connection c = null;
        Statement stmt = null;
        String category = "";
        float pc = 0, pe = 0, el = 0;

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

                    //////////// calculating credits to check the graduation
                    if (i == 4) {
                        category = rs.getString(i);
                    }
                    if (i == 5) {

                        if (category.equals("pc")) {

                            pc +=  rs.getFloat(i);
                        } else if (category.equals("pe")) {
                            pe +=  rs.getFloat(i);
                        } else if (category.equals("el")) {
                            el += rs.getFloat(i);
                        }
                    }
                }

//                System.out.println();// Move to the next line to print the next row.
            }
            rs.close();
        } catch (SQLException e) {
            return e.getMessage();
        }
//        System.out.println();

        if (pc == 60 && pe == 30 && el == 30) {
            String query1 = "select count(*) from enrollment_list where course_code=" + "\'" + "cp302" + "\'";
            String query2 = "select count(*) from enrollment_list where course_code=" + "\'" + "cp303" + "\'";
            int x = 0, y = 0;
            try {
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(query1);
                rs.next();
                x = rs.getInt(1);
                stmt.close();
                c.close();
                rs.close();
                // break;
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                return e.getMessage();
            }
            try {
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(query2);
                rs.next();
                y = rs.getInt(1);
                stmt.close();
                c.close();
                rs.close();
                // break;

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                return e.getMessage();
            }

            if (x == 1 && y == 1) {

                System.out.println(
                        "*********************************************Graduation Completed !!!***********************************************");
                return "true";
            } else {

                System.out.println("Capstone not done !!!");

                System.out.println(

                        "*********************************************Not Graduated !!!***********************************************");
                return "false";
            }
        } else {
            System.out.println("Total program core credits left : ");
            System.out.println(60 - pc);
            System.out.println("Total program elective credits left : ");
            System.out.println(30 - pe);
            System.out.println("Total elective  credits left : ");
            System.out.println(30 - el);
            System.out.println(
                    "*********************************************Not Graduated !!!***********************************************");
            return "false";
        }
    }

    ///////////////////////////////////////academics approve funtion ///////////////////////////
    String showlist(String DB_URL, String USER, String PASS, String course_code) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);

        try {

            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String approve_table = "SELECT * FROM approve_students where course_code = " + "\'" + course_code
                    + "\'";
            ResultSet rs = stmt.executeQuery(approve_table);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            int no = 1;

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {

                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();// Move to the next line to print the next row.
                no++;
            }
            rs.close();
            return "true";
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return "false";
        }

    }

    String Approve1(String DB_URL, String USER, String PASS, String course_code) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);

        String query = "update approve_students set approval_status =" + "\'" + "credit" + "\'"
                + " where course_code =" + "\'" + course_code
                + "\'";

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

    String Approve2(String DB_URL, String USER, String PASS, String course_code, int year) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);

        String query = "update approve_students set approval_status =" + "\'" + "credit" + "\'"
                + " where  entry_no like " + "\'" + year + "%\'" + "and course_code =" + "\'" + course_code
                + "\'";

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


    String Approve3(String DB_URL, String USER, String PASS, String course_code, String entryNumber) {
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);

        String query = "update approve_students set approval_status =" + "\'" + "credit" + "\'"
                + " where  entry_no=" + "\'" + entryNumber + "\'" + "and course_code =" + "\'" + course_code
                + "\'";

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
}






