package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.Country;
import universidades.Nelson.Class.Teacher;
import universidades.Nelson.Repository.TeacherRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceTeacher {
    @Autowired
    TeacherRepository repository;
    public ResponseEntity<Teacher> saveTeacher (@Valid @RequestBody Teacher teacher ){
        try {
            repository.save(teacher);
            return new ResponseEntity("saved successfully" , HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("something went wrong, try again", HttpStatus.NOT_ACCEPTABLE);
        }

    }
    public List<Teacher> showTeacher(){
        return repository.findAll();
    }

    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity("delete successfully",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("teacher not found, try again", HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<Teacher> updateTeacher(@Valid @RequestBody Teacher teacher , @PathVariable Long id){
        Optional<Teacher> teacherOptional = repository.findById(id);
        if(teacherOptional.isPresent()){
            teacher.setId_teacher(teacherOptional.get().getId_teacher());
            repository.save(teacher);
            return new ResponseEntity("teacher updated successfully ", HttpStatus.OK);
        }else {
            return new ResponseEntity("teacher not found, try again", HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<Teacher> filter(@RequestParam(required = false, name = "name")String name){
        List<Teacher> teacherList = showTeacher().stream().filter(x->x.getNames_teacher().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (teacherList.isEmpty()){
            return new ResponseEntity("teacher not found, try again", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(teacherList,HttpStatus.OK);
        }
    }
    public ResponseEntity<Teacher> teacherById (@Valid @PathVariable Long id){
        Optional<Teacher> teacherOptional = repository.findById(id);
        if (teacherOptional.isPresent()){
            return new ResponseEntity(teacherOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("teacher not found, try again", HttpStatus.BAD_REQUEST);
        }
    }
}
