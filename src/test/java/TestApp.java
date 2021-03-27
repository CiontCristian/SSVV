import domain.Student;
import org.junit.Before;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.Assert.*;

public class TestApp {
    private Service testService;

    @Before
    public void setup(){
        StudentXMLRepository studentXmlRepo = new StudentXMLRepository(new StudentValidator(), "studentTest.xml");
        testService = new Service(studentXmlRepo, null, null);
    }

    @Test
    public void test1(){
        int result = testService.saveStudent("1","Cristi",932);
        assertEquals(1, result);
    }

    @Test
    public void test2(){
        int result = testService.saveStudent("1","Cristi",110);
        assertEquals(0, result);
    }

    @Test
    public void test3(){
        int result = testService.saveStudent("1","Cristi",938);
        assertEquals(0, result);
    }

    @Test
    public void test4(){
        int result = testService.saveStudent(null,"Cristi",932);
        assertEquals(0, result);
    }

    @Test
    public void test5(){
        int result = testService.saveStudent("","Cristi",932);
        assertEquals(0, result);
    }

    @Test
    public void test6(){
        int result = testService.saveStudent("1",null,932);
        assertEquals(0, result);
    }

    @Test
    public void test7(){
        int result = testService.saveStudent("1","",932);
        assertEquals(0, result);
    }

    @Test
    public void test8(){
        int result = testService.saveStudent(null,"",109);
        assertEquals(0, result);
    }


}
