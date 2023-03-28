package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.Classroom;
import universidades.Nelson.Repository.ClassroomRepository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceClassroom {
    @Autowired
    ClassroomRepository repository;

    public ResponseEntity<Classroom> saveClassroom(@Valid @RequestBody Classroom classroom){
        try{
            repository.save(classroom);
            return new ResponseEntity("saved successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("something went wrong, try again", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<Classroom> showClassroom(){return repository.findAll();}

    public ResponseEntity<Classroom> daleteClassroom(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return  new ResponseEntity("delete successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("classroom not found, try again",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Classroom> updateClassroom(@Valid @RequestBody Classroom classroom, @PathVariable Long id){
        Optional<Classroom> classroomOptional = repository.findById(id);
        if (classroomOptional.isPresent()){
            classroom.setId_room(classroomOptional.get().getId_room());
            repository.save(classroom);
            return new ResponseEntity("classroom update successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity("classroom not found, try again",HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<Classroom> filter (@RequestParam(required = false,name = "name")String name){
        List<Classroom> classroomList = showClassroom().stream().filter(x->x.getName_room().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (classroomList.isEmpty()){
            return new ResponseEntity("classroom not found, try again",HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(classroomList,HttpStatus.OK);
        }
    }
    public ResponseEntity<Classroom> classroomById(@Valid @PathVariable Long id){
        Optional<Classroom> classroomOptional = repository.findById(id);
        if (classroomOptional.isPresent()){
            return new ResponseEntity(classroomOptional,HttpStatus.OK);
        }else{
            return  new ResponseEntity("calssroom not found, try again",HttpStatus.BAD_REQUEST);
        }
    }
}
