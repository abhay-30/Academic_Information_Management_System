package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarksUploadTest {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASS = "iitropar";

    @Test
    void statuschecktrue(){
        MarksUpload mp = new MarksUpload();
        assertEquals("true",mp.MarksUploadThroughCSV(DB_URL, USER,PASS, "ml101","/home/oem/IdeaProjects/AimsPortal2/src/main/java/org/example/marks.csv"));
    }
    @Test
    void statuscheckfalse(){
        MarksUpload mp = new MarksUpload();
        assertEquals("false",mp.MarksUploadThroughCSV(DB_URL+"123", USER,PASS, "cs302", "/marks.csv"));
    }

}