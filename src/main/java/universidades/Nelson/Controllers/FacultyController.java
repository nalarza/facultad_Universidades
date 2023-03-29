package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.Career;
import universidades.Nelson.Class.Faculty;
import universidades.Nelson.Services.ServiceFaculty;

import java.util.List;

@RestController
@RequestMapping(path = "university/faculty")
public class FacultyController {
    @Autowired
    ServiceFaculty serviceFaculty;
    @GetMapping(path = "/show/faculty")
    public List<Faculty> facultyList(){
        return serviceFaculty.showFaculty();
    }

    @PostMapping(path = "/add/faculty")
    public ResponseEntity<Faculty> addFaculty (@Valid @RequestBody Faculty faculty) {
        return serviceFaculty.saveFaculty(faculty);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id){
        return serviceFaculty.deleteFaculty(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Faculty> updateFaculty (@Valid @RequestBody Faculty faculty, @PathVariable Long id){
        return serviceFaculty.updateFaculty(faculty,id);
    }
    @GetMapping(path = "/name/faculty")
    public ResponseEntity<Faculty> filter (@RequestParam (required = false,name = "name")String name){
        return serviceFaculty.filter(name);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Faculty> facultyId (@Valid @PathVariable Long id){
        return serviceFaculty.facultyById(id);
    }
}
