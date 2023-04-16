package org.example;

import java.util.*;
import java.sql.*;
import java.io.*;

public class Main {
    public boolean main(String[] args) throws IOException {
        final String JDBC_DRIVER = "org.postgresql.Driver";
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASS = "iitropar";
        Connection c = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean x = true;
        while (true) {
            System.out.println("*************************Welcome to aims portal !!! *******************************");
            System.out.println("Enter 1 for Student Login ...");
            System.out.println("Enter 2 for Instructor Login...");
            System.out.println("Enter 3 for Academics Login ...");
            System.out.println("Enter 4 to go to previous menu ...");
            String input = reader.readLine();
            int a = Integer.parseInt(input);
            System.out.println(a);
            String role = "";
            if (a == 1) {
                while (true) {
                    role = "student";
                    System.out.println("Enter 1 to go to login Page.");
                    System.out.println("Enter 2 to go to previous menu. ");
                    input = reader.readLine();
                    int temp = Integer.parseInt(input);
                    System.out.println(temp);
                    if (temp == 1) {
                        System.out.println();
                        System.out.println("Enter your email address");
                        String email_id = reader.readLine();

                        System.out.println();
                        System.out.println("Enter your password");
                        String pass = reader.readLine();
                        /////////////////////////Calling Login funtion /////////////////////////////////////////////////////
                        Login lo = new Login();
                        String log = lo.LoginCheck(DB_URL, USER, PASS, role, email_id, pass);
                        if (log.equals("LoggedIn")) {
                            System.out.println();
                            System.out.println("*****************LoggedIn Successfully*********************");
                            while (true) {
                                String inputString = email_id;
                                int index = inputString.indexOf("@");
                                String user_id = inputString.substring(0, index);
                                System.out.println("Enter 1 to view you grades");
                                System.out.println("Enter 2 to view course offered for enrollment");
                                System.out.println("Enter 3 to view you current CGPA");
                                System.out.println("Enter 4  to check the status of elective course");
                                System.out.println("Enter 5  to check the graduation details ");
                                System.out.println("Enter 6 to go back to previous menu");
                                input = reader.readLine();
                                int choice = Integer.parseInt(input);
                                if (choice == 1) {
                                    CourseGrades Cgr = new CourseGrades();
                                    String tempo = Cgr.CoursesGrades(DB_URL, USER, PASS, user_id);
                                } else if (choice == 2) {
                                    //////////funtion call /////////////////////
                                    student s = new student();
                                    s.showAvailableCourses(DB_URL, USER, PASS);
                                    System.out.println("Enter the course code in which you want to enroll : ");
                                    String course_code = reader.readLine();
                                    //////////////funtion call //////////////////
                                    student ss = new student();
                                    String tempo = ss.ApplyCourse(DB_URL, USER, PASS, user_id, course_code);
                                } else if (choice == 3) {
                                    Cgpa cg = new Cgpa();

                                    System.out.println("Your Cgpa is   :" + cg.CgpaCalculate(DB_URL, USER, PASS, user_id));

                                } else if (choice == 4) {

                                    System.out.println("Enter the course code whose status you want to chekc ");
                                    String course_code = reader.readLine();
                                    CourseStatus cs = new CourseStatus();
                                    cs.CourseStatusCheck(DB_URL, USER, PASS, user_id, course_code);
                                } else if (choice == 5) {

                                    Academics ac = new Academics();
                                    ac.graduationcheck(DB_URL, USER, PASS, user_id);
                                } else if (choice == 6) {
                                    break;
                                }
                            }
                        } else if (log.equals("NotLoggedIn")) {
                            System.out.println();
                            System.out.println("******************Incorrect Password**************************");
                        } else if (log.equals("WrongEmail")) {
                            System.out.println();
                            System.out.println("Email does not exist ");
                        } else {
                            System.out.println();
                            System.out.println(log);
                        }
                    } else {
                        break;
                    }
                }

            } else if (a == 2) {

                while (true) {
                    role = "instructor";
                    System.out.println("Enter 1 to go to login Page.");
                    System.out.println("Enter 2 to go to previous menu. ");
                    input = reader.readLine();
                    int temp = Integer.parseInt(input);
                    System.out.println(temp);
                    if (temp == 1) {
                        System.out.println();
                        System.out.println("Enter your email address");
                        String email_id = reader.readLine();
                        System.out.println();
                        System.out.println("Enter your password");
                        String pass = reader.readLine();

                        Login lo = new Login();
                        String log = lo.LoginCheck(DB_URL, USER, PASS, role, email_id, pass);

                        if (log.equals("LoggedIn")) {
                            System.out.println();
                            System.out.println("*****************LoggedIn Successfully*********************");
                            while (true) {

                                System.out.println("Enter 1 to view grades of a student: ");
                                System.out.println("Enter 2  for register/derigister for a course  ");
                                System.out.println("Enter 3 to update marks of students ");
                                System.out.println("Enter 4 to approve elective course students  ");
                                System.out.println("Enter 5 to go the previous menu ");

                                String tt = reader.readLine();
                                int choice = Integer.parseInt(tt);
                                if (choice == 1) {

                                    System.out.println("Enter the entry no of the student ");
                                    String user_id = reader.readLine();
                                    CourseGrades cgg = new CourseGrades();
                                    String ttsdf = cgg.CoursesGrades(DB_URL, USER, PASS, user_id);

                                } else if (choice == 2) {

                                    System.out.println("Enter 1 to Register a Course");
                                    System.out.println("Enter 2 to De-Register a couse");
                                    String ttt = reader.readLine();
                                    int opt = Integer.parseInt(ttt);
                                    if (opt == 1) {
                                        System.out.println("Enter the course code");
                                        String course_code = reader.readLine();
                                        System.out.println("Enter the course title");
                                        String course_title = reader.readLine();
                                        System.out.println("Enter the course LTP structure");
                                        String course_ltp = reader.readLine();
                                        System.out.println("Enter the prerequistes courses code  specified by comma ");
                                        String course_prereq = reader.readLine();

                                        CourseRegister cr = new CourseRegister();
                                        cr.CourseRegistration(DB_URL, USER, PASS, course_code, course_title, course_ltp, course_prereq);


                                    } else if (opt == 2) {

                                        System.out.println("Enter the course code ");
                                        String course_code = reader.readLine();
                                        CourseDeRegister cdr = new CourseDeRegister();
                                        cdr.CourseDeRegistration(DB_URL, USER, PASS, course_code);

                                    }
                                } else if (choice == 3) {
                                    System.out.println("Enter the course code ");
                                    String course_code = reader.readLine();
                                    System.out.print("Enter the full path of csv file :");
                                    String path = reader.readLine();
                                    String csvFilePath = path;
                                    MarksUpload mp = new MarksUpload();
                                    mp.MarksUploadThroughCSV(DB_URL, USER, PASS, course_code, csvFilePath);

                                } else if (choice == 4) {
                                    System.out.println("Enter the course code for to see the list of students");
                                    String course_code = reader.readLine();
                                    // System.out.println(course_code);
                                    Instructor ins = new Instructor();
                                    ins.Showlist(DB_URL, USER, PASS, course_code);
                                    System.out.println("Enter 1 to approve all ");
                                    System.out.println("Enter 2 to approve a particular year students ");
                                    System.out.println("enter 3 to approve a specific student ");
                                    String ttttt = reader.readLine();
                                    int way = Integer.parseInt(ttttt);
                                    if (way == 1) {
                                        Instructor tins = new Instructor();
                                        tins.ApproveStudent1(DB_URL, USER, PASS, course_code);

                                    } else if (way == 2) {

                                        System.out.println("enter year ");
                                        String ran = reader.readLine();
                                        int year = Integer.parseInt(ran);
                                        Instructor it = new Instructor();
                                        it.ApproveStudent2(DB_URL, USER, PASS, course_code, year);
                                    } else if (way == 3) {
                                        System.out.println("Enter the entry number of the student to approve");
                                        String entryNumber = reader.readLine();
                                        Instructor itt = new Instructor();
                                        itt.ApproveStudent3(DB_URL, USER, PASS, course_code, entryNumber);
                                    }
                                } else if (choice == 5) {
                                    break;
                                }

                            }
                        } else if (log.equals("NotLoggedIn")) {
                            System.out.println();
                            System.out.println("******************Incorrect Password**************************");
                        } else if (log.equals("WrongEmail")) {
                            System.out.println();
                            System.out.println("Email does not exist ");
                        } else {
                            System.out.println();
                            System.out.println(log);
                        }
                    } else {
                        break;
                    }
                }
            } else if (a == 3) {

                while (true) {
                    role = "academics";
                    System.out.println("Enter 1 to go to login Page.");
                    System.out.println("Enter 2 to go to previous menu. ");
                    input = reader.readLine();
                    int temp = Integer.parseInt(input);
                    System.out.println(temp);
                    if (temp == 1) {
                        System.out.println();
                        System.out.println("Enter your email address");
                        String email_id = reader.readLine();
                        System.out.println();
                        System.out.println("Enter your password");
                        String pass = reader.readLine();

                        Login lo = new Login();
                        String log = lo.LoginCheck(DB_URL, USER, PASS, role, email_id, pass);

                        if (log.equals("LoggedIn")) {
                            System.out.println();
                            System.out.println("*****************LoggedIn Successfully*********************");
                            while (true) {
                                System.out.println("Enter 1 to edit the course catalog");
                                System.out.println("Enter 2  view grades of all user");
                                System.out.println("Enter 3 to generate transcript of a student");
                                System.out.println("Enter 4 to see the list of students applied for elective ");
                                System.out.println("Enter 5 to go to the previous menu ");

                                String tt = reader.readLine();
                                int choice = Integer.parseInt(tt);
                                if (choice == 1) {


                                    System.out.println("Enter 1 to Register a Course");
                                    System.out.println("Enter 2 to De-Register a couse");
                                    String tttt = reader.readLine();
                                    int opt = Integer.parseInt(tttt);
                                    if (opt == 1) {
                                        System.out.println("Enter the course code");

                                        String course_code = reader.readLine();
                                        System.out.println(course_code);
                                        System.out.println("Enter the course title");
                                        String course_title = reader.readLine();
                                        System.out.println(course_title);
                                        System.out.println("Enter the course LTP structure");
                                        String course_ltp = reader.readLine();
                                        System.out.println(course_ltp);
                                        System.out.println("Enter the prerequistes courses code  specified by comma ");
                                        String course_prereq = reader.readLine();
                                        System.out.println(course_prereq);
                                        CourseRegister crd = new CourseRegister();
                                        crd.CourseRegistration(DB_URL, USER, PASS, course_code, course_title, course_ltp, course_prereq);
                                    } else if (opt == 2) {

                                        System.out.println("Enter the course code ");
                                        String course_code = reader.readLine();
                                        CourseDeRegister dd = new CourseDeRegister();
                                        dd.CourseDeRegistration(DB_URL, USER, PASS, course_code);
                                    }

                                } else if (choice == 2) {
                                    System.out.println("Enter the entry no of the student ");
                                    String user_id = reader.readLine();
                                    CourseGrades cgd = new CourseGrades();
                                    String tttt = cgd.CoursesGrades(DB_URL, USER, PASS, user_id);
                                } else if (choice == 3) {
                                    System.out.println("Enter the useer id of the student");
                                    String user_id = reader.readLine();
                                    System.out.println("Your generated transcript is as follows  ");
                                    Academics ac = new Academics();
                                    ac.GenerateTranscript(DB_URL, USER, PASS, user_id);
                                } else if (choice == 4) {
                                    System.out.println("Enter the course code for to see the list of students");
                                    String course_code = reader.readLine();
                                    // System.out.println(course_code);
                                    Academics ac = new Academics();
                                    ac.showlist(DB_URL, USER, PASS, course_code);
                                    System.out.println("Enter 1 to approve all ");
                                    System.out.println("Enter 2 to approve a particular year students ");
                                    System.out.println("enter 3 to approve a specific student ");
                                    String sam = reader.readLine();
                                    int way =  Integer.parseInt(sam);
                                    if (way == 1) {
                                        Academics att = new Academics();
                                        att.Approve1(DB_URL, USER, PASS, course_code);

                                    } else if (way == 2) {
                                        Academics att = new Academics();
                                        System.out.println("enter year ");
                                        int year = sc.nextInt();

                                        att.Approve2(DB_URL, USER, PASS, course_code, year);
                                    } else if (way == 3) {
                                        Academics att = new Academics();
                                        System.out.println("Enter the entry number of the student to approve");
                                        String entryNumber = reader.readLine();
                                        att.Approve3(DB_URL, USER, PASS, course_code, entryNumber);
                                    }

                                } else if (choice == 5) {
                                    break;
                                }
                            }

                        } else if (log.equals("NotLoggedIn")) {
                            System.out.println();
                            System.out.println("******************Incorrect Password**************************");

                        } else if (log.equals("WrongEmail")) {
                            System.out.println();
                            System.out.println("Email does not exist ");
                        } else {
                            System.out.println();
                            System.out.println(log);
                        }
                    } else {
                        break;
                    }
                }
            } else if (a == 4) {
                break;
            }

        }
        return x;

    }
}