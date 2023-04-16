package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class MarksUpload {
    String MarksUploadThroughCSV(String DB_URL, String USER, String PASS, String course_code, String csvFilePath) {
        int batchSize = 20;
        Connection connection = null;
        Statement stmt = null;
        Connection c = null;
        try {

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setAutoCommit(false);

            String sql = "insert into  grades_update (entry_no, grade) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String entry_no = data[0];
                String grade = data[1];
                statement.setString(1, entry_no);
                statement.setString(2, grade);

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            lineReader.close();

            // execute the remaining queries
            statement.executeBatch();

            connection.commit();
            connection.close();

        } catch (IOException ex) {
            System.err.println(ex);
            return "false";
        } catch (SQLException ex) {
            ex.printStackTrace();


            return "false";
        }

        String updatequery = "update enrollment_list set grade=grades_update.grade from grades_update where enrollment_list.student_id=grades_update.entry_no" +" and enrollment_list.course_code =" + "\'" + course_code + "\'";

        String deltequery = "delete from grades_update";

        try {

            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            stmt.execute(updatequery);
            stmt.execute(deltequery);
            stmt.close();
            c.close();

            System.out.println(" Grades updated successfully");
            return "true";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return "false";
        }


    }

}
