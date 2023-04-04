package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.Faculty;
import universidades.Nelson.Repository.FacultyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ServiceFaculty {
    @Autowired
    FacultyRepository repository;

    public ResponseEntity<Faculty> saveFaculty(@Valid @RequestBody Faculty faculty){
        try{
            repository.save(faculty);
            return new ResponseEntity("saved successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("something went worg, try again",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<Faculty> showFaculty(){return repository.findAll();}

    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return new ResponseEntity("delete seccessfully",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity("country not found, try again",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Faculty> updateFaculty(@Valid @RequestBody Faculty faculty,@PathVariable Long id){
        Optional<Faculty> facultyOptional = repository.findById(id);
        if (facultyOptional.isPresent()){
            repository.save(faculty);
            return new ResponseEntity("faculty update successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity("faculty not found, try again",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Faculty> filter (@RequestParam(required = false,name = "name")String name){
        List<Faculty> facultyList = showFaculty().stream().filter(x->x.getName_faculty().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (facultyList.isEmpty()){
            return new ResponseEntity("ocuntry not found, try again",HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(facultyList,HttpStatus.OK);
        }
    }

    public ResponseEntity<Faculty> facultyById(@Valid @PathVariable Long id){
        Optional<Faculty> facultyOptional = repository.findById(id);
        if (facultyOptional.isPresent()){
            return new ResponseEntity(facultyOptional,HttpStatus.OK);
        }else {
            return new ResponseEntity("country not found, try again",HttpStatus.BAD_REQUEST);
        }
    }
}
