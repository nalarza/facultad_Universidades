package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.Student;
import universidades.Nelson.Services.ServiceStudent;

import java.util.List;

@RestController
@RequestMapping(path = "/university/student")
public class StudentController {
    @Autowired
    ServiceStudent serviceStudent;

    @GetMapping(path = "/show/student")
    public List<Student> studentList(){
        return serviceStudent.showStudent();
    }

    @PostMapping(path = "/add/student")
    public ResponseEntity<Student> addStudent (@Valid @RequestBody Student student) {
        return serviceStudent.saveStudent(student);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> studentCareer(@PathVariable Long id){
        return serviceStudent.deleteStudent(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Student> updateStudent (@Valid @RequestBody Student student, @PathVariable Long id){
        return serviceStudent.updateStudent(student,id);
    }
    @GetMapping(path = "/name/student")
    public ResponseEntity<Student> filter (@RequestParam (required = false,name = "name")String name){
        return serviceStudent.filter(name);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> studentId (@Valid @PathVariable Long id){
        return serviceStudent.studentById(id);
    }
}
