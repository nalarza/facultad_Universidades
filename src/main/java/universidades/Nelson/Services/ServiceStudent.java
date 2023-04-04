package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.Student;
import universidades.Nelson.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ServiceStudent {
    @Autowired
    StudentRepository repository;

    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        try{
            repository.save(student);
            return new ResponseEntity("saved successfully", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("something went wrong, try again",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<Student> showStudent(){return repository.findAll();}

    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity("delete successfully",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("Student not found, try again",HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<Student> updateStudent (@Valid @RequestBody Student student, @PathVariable Long id){
        Optional<Student> studentOptional = repository.findById(id);
        if(studentOptional.isPresent()){
            student.setId_student(studentOptional.get().getId_student());
            repository.save(student);
            return new ResponseEntity("student updated successfully ", HttpStatus.OK);
        }else {
            return new ResponseEntity("student not found, try again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Student> filter(@RequestParam(required = false, name = "name")String name){
        List<Student> studentList = showStudent().stream().filter(x->x.getNames_student().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (studentList.isEmpty()){
            return new ResponseEntity("student not found, try again", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(studentList,HttpStatus.OK);
        }
    }
    public ResponseEntity<Student> studentById (@Valid @PathVariable Long id){
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isPresent()){
            return new ResponseEntity(studentOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("student not found, try again", HttpStatus.BAD_REQUEST);
        }
    }

}
