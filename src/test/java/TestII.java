import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
public class TestII {
    @Mock
    private StudentXMLRepository studentXMLRepository;

    @Mock
    private TemaXMLRepository temaXMLRepository;

    @Mock
    private NotaXMLRepository notaXMLRepository;

    @InjectMocks
    private final Service service = new Service(studentXMLRepository,temaXMLRepository,notaXMLRepository);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1(){
        Student student  = new Student("2", "Jordan", 932);
        when(studentXMLRepository.save(student)).thenReturn(student);
        assertEquals(1, service.saveStudent("2", "Jordan", 932));
    }


    private void testAddStudent(){
        Student student  = new Student("2", "Jordan", 932);
        when(studentXMLRepository.save(student)).thenReturn(student);
        assertEquals(1, service.saveStudent("2", "Jordan", 932));
    }

    private void testAddAssignment(){
        Tema tema  = new Tema("2", "SSVV Lab 3 Take Home", 8, 6);
        when(temaXMLRepository.save(tema)).thenReturn(tema);
        assertEquals(1, service.saveTema("2", "SSVV Lab 3 Take Home", 8, 6));
    }

    @Test
    public void test2(){
        testAddStudent();
        testAddAssignment();
    }


    private void testAddGrade(){
        Student student  = new Student("2", "Jordan", 932);
        Tema tema  = new Tema("2", "SSVV Lab 3 Take Home", 8, 6);
        Nota nota = new Nota(new Pair("2", "2"), 7.5, 8, "Tema stearsa dar ai punctaj pentru efort!");
        when(notaXMLRepository.save(Mockito.any())).thenReturn(nota);
        when(studentXMLRepository.findOne("2")).thenReturn(student);
        when(temaXMLRepository.findOne("2")).thenReturn(tema);
        assertEquals(1, service.saveNota("2", "2", 7.5, 8, "Tema stearsa dar ai punctaj pentru efort!"));
    }

    @Test
    public void test3(){
        testAddStudent();
        testAddAssignment();
        testAddGrade();
    }
}
