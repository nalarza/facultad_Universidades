package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.Classroom;
import universidades.Nelson.Services.ServiceClassroom;

import java.util.List;

@RestController
@RequestMapping(path = "/univerity/classroom")
public class ClassroomController {
    @Autowired
    ServiceClassroom serviceClassroom;
    @GetMapping(path = "/show/classroom")
    public List<Classroom> classroomList(){
        return serviceClassroom.showClassroom();
    }

    @PostMapping(path = "/add/classroom")
    public ResponseEntity<Classroom> addClassroom (@Valid @RequestBody Classroom classroom) {
        return serviceClassroom.saveClassroom(classroom);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Classroom> deleteClassroom(@PathVariable Long id){
        return serviceClassroom.daleteClassroom(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Classroom> updateClassroom (@Valid @RequestBody Classroom classroom, @PathVariable Long id){
        return serviceClassroom.updateClassroom(classroom,id);
    }
    @GetMapping(path = "/name/classroom")
    public ResponseEntity<Classroom> filter (@RequestParam (required = false,name = "name")String name){
        return serviceClassroom.filter(name);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Classroom> classroomId (@Valid @PathVariable Long id){
        return serviceClassroom.classroomById(id);
    }

}
