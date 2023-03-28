package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.Career;
import universidades.Nelson.Repository.CareerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceCareer {
    @Autowired
    CareerRepository repository;

    public ResponseEntity<Career> saveCareer(@Valid @RequestBody Career career){
        try {
            repository.save(career);
            return  new ResponseEntity("save successfully ", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("something went wrong, try again",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<Career> showCareer(){return repository.findAll();}

    public ResponseEntity<Career> deleteCareer(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return new ResponseEntity("delete seccessfully",HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity("career not found, try again",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Career> updateCareer(@Valid @RequestBody Career career, @PathVariable Long id){
        Optional<Career> careerOptional = repository.findById(id);
        if (careerOptional.isPresent()){
            career.setId_career(careerOptional.get().getId_career());
            repository.save(career);
            return new ResponseEntity("career update successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity("career not found, try again",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Career> filter(@RequestParam(required = false,name = "name")String name){
        List<Career> careerList = showCareer().stream().filter(x->x.getName_career().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (careerList.isEmpty()){
            return new ResponseEntity("country not found, try again",HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(careerList,HttpStatus.OK);
        }
    }
    public ResponseEntity<Career> careerById(@Valid @PathVariable Long id){
        Optional<Career> careerOptional = repository.findById(id);
        if (careerOptional.isPresent()){
            return new ResponseEntity(careerOptional,HttpStatus.OK);
        }else {
            return new ResponseEntity("career not found,try again",HttpStatus.BAD_REQUEST);
        }
    }
}
