package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.Career;
import universidades.Nelson.Class.Matter;
import universidades.Nelson.Services.ServiceMatter;

import java.util.List;

@RestController
@RequestMapping(path = "/university/mateer")
public class MateerController {
    @Autowired
    ServiceMatter serviceMatter;
    @GetMapping(path = "/show/mateer")
    public List<Matter> mateerList(){
        return serviceMatter.showMatter();
    }

    @PostMapping(path = "/add/mateer")
    public ResponseEntity<Matter> addMateer (@Valid @RequestBody Matter matter) {
        return serviceMatter.saveMatter(matter);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Matter> deleteMateer(@PathVariable Long id){
        return serviceMatter.deleteMatter(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Matter> updateMateer (@Valid @RequestBody Matter matter, @PathVariable Long id){
        return serviceMatter.uddateMatter(matter,id);
    }
    @GetMapping(path = "/name/mateer")
    public ResponseEntity<Matter> filter (@RequestParam (required = false,name = "name")String name){
        return serviceMatter.filter(name);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Matter> mateerId (@Valid @PathVariable Long id){
        return serviceMatter.matterById(id);
    }
}
