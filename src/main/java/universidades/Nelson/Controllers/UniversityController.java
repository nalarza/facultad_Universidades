package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.University;
import universidades.Nelson.Services.ServiceUniversity;

import java.util.List;

@RestController
@RequestMapping(path = "university")
public class UniversityController {
    @Autowired
    ServiceUniversity serviceUniversity;

    @GetMapping(path = "/show/university")
    public List<University> universityList(){
        return serviceUniversity.showUniversity();
    }

    @PostMapping(path = "/add/university")
    public ResponseEntity<University> addUniversity (@Valid @RequestBody University university){
        return serviceUniversity.saveUniversity(university);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<University> deleteUniversity(@PathVariable Long id){return serviceUniversity.deleteUniversity(id);}

    @PutMapping(path = "/{id}")
    public ResponseEntity<University> updateUniversity (@Valid @RequestBody University university, @PathVariable Long id){
        return serviceUniversity.updateUniversity(university,id);
    }

    @GetMapping(path = "/name/university")
    public ResponseEntity<University> filter (@RequestParam(required = false,name = "name")String name){
        return serviceUniversity.filter(name);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<University> universityId (@Valid @PathVariable Long id){
        return serviceUniversity.universityById(id);
    }
}
