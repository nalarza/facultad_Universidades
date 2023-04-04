package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.City;
import universidades.Nelson.Repository.CityRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ServiceCity {
    @Autowired
    CityRepository repository;
    
    public ResponseEntity<City> saveCity (@Valid @RequestBody City city){
        repository.save(city);
        return new ResponseEntity("save successfully ",HttpStatus.OK);
    }

    public List<City> showCiti(){
        return repository.findAll();
    }

    public ResponseEntity<City> delteCity(@PathVariable Long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity("deleted seccessfully ",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("city not found, try again ",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<City> updateCity (@Valid @RequestBody City city, @PathVariable Long id){
        Optional<City> cityopOptional = repository.findById(id);
        if (cityopOptional.isPresent()) {
            city.setId(cityopOptional.get().getId());
            repository.save(city);
            return new ResponseEntity("city updates seccessfully ",HttpStatus.OK);
        }else{
            return new ResponseEntity("city not found, try again ",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<City> filter (@RequestParam(required=false,name="name")String name){
        List<City> cityList = showCiti().stream().filter(x->x.getName_city().equalsIgnoreCase(name)).collect(Collectors.toList());
        if(cityList.isEmpty()){
            return new ResponseEntity("city not found, try again ",HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(cityList,HttpStatus.OK);
        }
    }

    public ResponseEntity<City> cityById (@Valid @PathVariable Long id){
        Optional<City> cityOptional = repository.findById(id);
        if (cityOptional.isPresent()) {
            return new ResponseEntity(cityOptional,HttpStatus.OK);
        } else {
            return new ResponseEntity("city not found, try again ",HttpStatus.BAD_REQUEST);
        }
    }
}
