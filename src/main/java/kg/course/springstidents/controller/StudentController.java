package kg.course.springstidents.controller;

import kg.course.springstidents.model.Student;
import kg.course.springstidents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public List<Student> findAllStudent(){
        return service.findAllStudent();
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email){
        return service.findByEmail(email);
    }

    @PutMapping("/update")
    public Student updateStudent(Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("/delete/{email}")
    public void deleteStudent(@PathVariable String email){
        service.deleteStudent(email);
    }

}
