import domain.Tema;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.TemaValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestAddAssignmentWBT {
    private static Service testService;
    private static TemaXMLRepository temaXMLRepository;

    @BeforeClass
    public static void setup(){
        temaXMLRepository = new TemaXMLRepository(new TemaValidator(), "assignmentTest.xml");
        testService = new Service(null, temaXMLRepository, null);
    }

    @AfterClass
    public static  void delete(){
        temaXMLRepository.delete("1");
        temaXMLRepository.delete("2");
    }
    @Test
    public void test1(){
        int result = testService.saveTema("1","Tema1", 10, 4);
        assertEquals(1, result);
    }

    @Test
    public void test2(){
        int result = testService.saveTema("1","Tema1", 17, 4);
        assertEquals(0, result);
    }

    @Test
    public void test3(){
        Tema tema2 = new Tema("2","Tema2", 10, 4);
        Tema result  = temaXMLRepository.save(tema2);
        assertEquals(tema2, result);
    }

    @Test
    public void test4(){
        Tema tema3 = new Tema("3","Tema3", 10, 4);
        temaXMLRepository.save(tema3);
        Tema result  = temaXMLRepository.save(tema3);
        assertNull(result);
    }

    @Test
    public void test5(){
        Tema tema4 = new Tema("4","Tema4", 2, 4);
        Tema result  = temaXMLRepository.save(tema4);
        assertNull(result);
    }
}
