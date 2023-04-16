package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void student1() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("1\n1\n2020csb1113@iitrpr.ac.in\n123\n1\n2\ncs301\n3\n4\ncs301\n5\n6\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"aak"}));
    }
    @Test
    void student2() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("1\n1\n2018csb1115@iitrpr.ac.in\n123\n1\n5\n6\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"aak"}));
    }

    @Test
    void student3() throws  IOException{
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("1\n1\n201csb1115@iitrpr.ac.in\n123\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"aak"}));
    }
    @Test
    void student4() throws  IOException{
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("1\n1\n2018csb1115@iitrpr.ac.in\n1243\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"aak"}));
    }


    @Test
    void Instructor1() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n1\napurvmudgal@iitrpr.ac.in\n123\n1\n2020csb1113\n2\n1\ncs306\ntheory of compuataion\n3-0-5\ncs301\n2\n2\ncs306\n5\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"sf"}));
    }

    @Test
    void Instructor2() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n1\napurvmudgal@iitrpr.ac.in\n123\n4\ncs301\n3\n2020csb1113\n4\ncs301\n2\n2020\n4\ncs301\n1\n5\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"sf"}));
    }
    @Test
    void Instructor3() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n1\napusdrvmudgal@iitrpr.ac.in\n123\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"sf"}));
    }
    @Test
    void Instructor4() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n1\napurvmudgal@iitrpr.ac.in\n1234\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"sf"}));
    }


    @Test
    void Academics1() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("3\n1\nanilshukla@iitrpr.ac.in\n123\n1\n1\ncs306\ntheory of compuataion\n3-0-5\ncs301\n1\n2\ncs301\n2\n2020csb1113\n3\n2020csb1113\n4\ncs301\n3\n2020csb1113\n4\ncs301\n2\n2020\n4\ncs301\n1\n5\n2\n4\n".getBytes());
        System.setIn(in);
        assertFalse(Main.main(new String[]{"sf"}));
    }

    @Test
    void Academics2() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("3\n1\nanilshukla@iitrpr.ac.in\n123\n2\n2020csb1113\n".getBytes());
        System.setIn(in);
        assertFalse(Main.main(new String[]{"shjgjf"}));
    }

    @Test
    void Academics33() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("3\n1\nanilshukla@iitrpr.ac.in\n123\n4\n".getBytes());
        System.setIn(in);
        assertFalse(Main.main(new String[]{"shjgjf"}));
    }

    @Test
    void Academics3() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("3\n1\nanilsdshukla@iitrpr.ac.in\n123\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"shjgjf"}));
    }
    @Test
    void Academics4() throws IOException {
        Main Main=new Main();
        ByteArrayInputStream in=new ByteArrayInputStream("3\n1\nanilshukla@iitrpr.ac.in\n12sd3\n2\n4\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"shjgjf"}));
    }

}