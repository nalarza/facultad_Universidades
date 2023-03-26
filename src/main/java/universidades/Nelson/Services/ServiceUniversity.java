package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.University;
import universidades.Nelson.Repository.UniversityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceUniversity {
    @Autowired
    UniversityRepository repository;

    public ResponseEntity<University> saveCountry (@Valid @RequestBody University university){
        repository.save(university);
        return new ResponseEntity("save successfully ", HttpStatus.OK);
    }

    public List<University> showUniversity(){
        return repository.findAll();
    }

    public ResponseEntity<University> deleteCountry (@PathVariable Long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity("deleted seccessfully ",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("university not found, try again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<University> updateUniversity(@Valid @RequestBody University university, @PathVariable Long id){
        Optional<University> universityOptional = repository.findById(id);
        if (universityOptional.isPresent()){
            university.setId(universityOptional.get().getId());
            repository.save(university);
            return new ResponseEntity("university updated seccessfully ", HttpStatus.OK);
        }else {
            return new ResponseEntity("university not found, try again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<University> filter (@RequestParam(required = false, name = "name")String name){
        List<University> universityList = showUniversity().stream().filter(x->x.getName_university().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (universityList.isEmpty()){
            return new ResponseEntity("university not found, try again",HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(universityList,HttpStatus.OK);
        }
    }
    public ResponseEntity<University> universityById (@Valid @PathVariable Long id){
        Optional<University> universityOptional = repository.findById(id);
        if (universityOptional.isPresent()){
            return new ResponseEntity(universityOptional,HttpStatus.OK);
        }else {
            return new ResponseEntity("university not found, try again",HttpStatus.BAD_REQUEST);
        }
    }
}
