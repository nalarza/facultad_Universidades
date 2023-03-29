package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.Matter;
import universidades.Nelson.Repository.MatterRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceMatter {
    @Autowired
    MatterRepository repository;

    public ResponseEntity<Matter> saveMatter(@Valid @RequestBody Matter matter){
        try{
            repository.save(matter);
            return new ResponseEntity("saved successfully", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("someting went wrong, try again",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<Matter> showMatter (){return repository.findAll();}

    public ResponseEntity<Matter> deleteMatter(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return new ResponseEntity("delete successfully",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("matter not found, try again",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Matter> uddateMatter(@Valid @RequestBody Matter matter,@PathVariable Long id){
        Optional<Matter>matterOptional=repository.findById(id);
        if (matterOptional.isPresent()){
            matter.setId_matter(matterOptional.get().getId_matter());
            repository.save(matter);
            return new ResponseEntity("matter update successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity("matter not found, try again",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Matter> filter (@RequestParam(required = false,name = "name")String name){
        List<Matter> matterList = showMatter().stream().filter(x->x.getName_matter().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (matterList.isEmpty()){
            return new ResponseEntity("matter not found, try again",HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(matterList,HttpStatus.OK);
        }
    }

    public ResponseEntity<Matter> matterById(@Valid @PathVariable Long id){
        Optional<Matter> matterOptional = repository.findById(id);
        if (matterOptional.isPresent()){
            return new ResponseEntity(matterOptional,HttpStatus.OK);
        }else {
            return new ResponseEntity("matter not found, try again",HttpStatus.BAD_REQUEST);
        }
    }
}
