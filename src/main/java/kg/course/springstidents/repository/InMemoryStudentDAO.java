package kg.course.springstidents.repository;

import kg.course.springstidents.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Repository
public class InMemoryStudentDAO {

    private final List<Student> STUDENT = new ArrayList<>();

    public List<Student> findAllStudent() {
        return STUDENT;
    }

    public Student saveStudent(Student student) {
        STUDENT.add(student);
        return student;
    }

    public Student findByIdEmail(String email) {
        return STUDENT.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst().orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream
                .range(0, STUDENT.size()).filter(e->STUDENT.get(e).getEmail().equals(student.getEmail())).
                findFirst().orElse(-1);
        if(studentIndex>-1){
            STUDENT.set(studentIndex, student);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {
        var student = findByIdEmail(email);
        if(student==null)
            STUDENT.remove(email);
    }
}
