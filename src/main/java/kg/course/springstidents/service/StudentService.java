package kg.course.springstidents.service;

import kg.course.springstidents.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
     List<Student> findAllStudent();

     Student saveStudent(Student student);
     Student findByEmail(String email);
     Student updateStudent(Student student);
     void deleteStudent(String email);
}
