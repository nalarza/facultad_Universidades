package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.Teacher;
import universidades.Nelson.Services.ServiceTeacher;

import java.util.List;

@RestController
@RequestMapping(path = "university/teacher")
public class TeacherController {
    @Autowired
    ServiceTeacher serviceTeacher;
    @GetMapping(path = "/show/teacher")
    public List<Teacher> teacherList(){
        return serviceTeacher.showTeacher();
    }

    @PostMapping(path = "/add/teacher")
    public ResponseEntity<Teacher> addTeacher (@Valid @RequestBody Teacher teacher) {
        return serviceTeacher.saveTeacher(teacher);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id){
        return serviceTeacher.deleteTeacher(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Teacher> updateTeacher (@Valid @RequestBody Teacher teacher, @PathVariable Long id){
        return serviceTeacher.updateTeacher(teacher,id);
    }
    @GetMapping(path = "/name/teacher")
    public ResponseEntity<Teacher> filter (@RequestParam (required = false,name = "name")String name){
        return serviceTeacher.filter(name);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Teacher> teacherId (@Valid @PathVariable Long id){
        return serviceTeacher.teacherById(id);
    }
}
