import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import static org.junit.Assert.assertEquals;

public class TestAddGradeIT {
    private static Service testService;
    private static TemaXMLRepository temaXMLRepository;
    private static NotaXMLRepository notaXMLRepository;
    private static StudentXMLRepository studentXMLRepository;

    @BeforeClass
    public static void setup(){
        temaXMLRepository = new TemaXMLRepository(new TemaValidator(), "assignmentTest.xml");
        studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "studentTest.xml");
        notaXMLRepository = new NotaXMLRepository(new NotaValidator(), "gradeTest.xml");
        testService = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);
    }

    @AfterClass
    public static  void delete(){
        notaXMLRepository.delete(new Pair<>("1", "1"));
        temaXMLRepository.delete("1");
        studentXMLRepository.delete("1");
        notaXMLRepository.delete(new Pair<>("2", "2"));
        temaXMLRepository.delete("2");
        studentXMLRepository.delete("2");
    }

    @Test
    public void test1(){
        // test WBT addGrade
        assertEquals(1, testService.saveStudent("1", "Cristi", 932));
        assertEquals(1, testService.saveTema("1", "SSVV Lab 4 In Class", 8, 7));
        assertEquals(1, testService.saveNota("1", "1", 10.0, 8, "Foarte bine facuta, Domnle!"));
    }

    private void testAddStudent(){
        assertEquals(1, testService.saveStudent("2", "Jordan", 932));
    }

    private void testAddAssignment(){
        assertEquals(1, testService.saveTema("2", "SSVV Lab 3 Take Home", 8, 6));
    }

    private void testAddGrade(){
        assertEquals(1, testService.saveNota("2", "2", 7.5, 8, "Tema stearsa dar ai punctaj pentru efort!"));
    }

    @Test
    public void test2(){
        testAddStudent();
        testAddAssignment();
        testAddGrade();
    }

}

