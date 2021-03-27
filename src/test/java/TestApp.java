import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.StudentXMLRepository;
import service.Service;
import validation.StudentValidator;

import static org.junit.Assert.*;

public class TestApp {
    private static Service testService;
    private static StudentXMLRepository studentXmlRepo;

    @BeforeClass
    public static void setup(){
        studentXmlRepo = new StudentXMLRepository(new StudentValidator(), "studentTest.xml");
        testService = new Service(studentXmlRepo, null, null);
    }

    @AfterClass
    public static  void delete(){
        studentXmlRepo.delete("1");
        studentXmlRepo.delete("2");
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

    @Test
    public void test9(){
        testService.saveStudent("2","Timo",932);
        int result = testService.saveStudent("2","Vali",932);
        assertEquals(0, result);
    }


}
