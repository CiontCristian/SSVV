import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.TemaValidator;

import static org.junit.Assert.assertEquals;

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
}
