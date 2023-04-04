package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.Career;
import universidades.Nelson.Services.ServiceCareer;

import java.util.List;

@RestController
@RequestMapping(path = "/university/career")
public class CareerController {
    @Autowired
    ServiceCareer serviceCareer;

    @GetMapping(path = "/show/career")
    public List<Career> careerList(){
        return serviceCareer.showCareer();
    }

    @PostMapping(path = "/add/career")
    public ResponseEntity<Career> addCareer (@Valid @RequestBody Career career) {
        return serviceCareer.saveCareer(career);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Career> deleteCareer(@PathVariable Long id){
        return serviceCareer.deleteCareer(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Career> updateCareer (@Valid @RequestBody Career career, @PathVariable Long id){
        return serviceCareer.updateCareer(career,id);
    }
    @GetMapping(path = "/name/career")
    public ResponseEntity<Career> filter (@RequestParam (required = false,name = "name")String name){
        return serviceCareer.filter(name);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Career> careerId (@Valid @PathVariable Long id){
        return serviceCareer.careerById(id);
    }
}
