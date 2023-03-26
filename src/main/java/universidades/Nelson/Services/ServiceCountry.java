package universidades.Nelson.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import universidades.Nelson.Class.Country;
import universidades.Nelson.Repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceCountry {
    @Autowired
    CountryRepository repository;

    public ResponseEntity<Country> saveCountry(@Valid @RequestBody Country country){
        try {
            repository.save(country);
            return new ResponseEntity("saved successfully" , HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("something went wrong, try again", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    public List<Country> showCountries(){
        return repository.findAll();
    }

    public ResponseEntity<Country> DeleteCountry (@PathVariable Long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity("delete successfully",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity("country not found, try again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Country> updateCountry(@Valid @RequestBody Country country, @PathVariable Long id){
        Optional<Country> countryOptional = repository.findById(id);
        if(countryOptional.isPresent()){
            country.setId(countryOptional.get().getId());
            repository.save(country);
            return new ResponseEntity("country updated successfully ", HttpStatus.OK);
        }else {
            return new ResponseEntity("country not found, try again", HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<Country> filter(@RequestParam(required = false, name = "name")String name){
        List<Country> countryList = showCountries().stream().filter(x->x.getName_country().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (countryList.isEmpty()){
            return new ResponseEntity("country not found, try again", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(countryList,HttpStatus.OK);
        }
    }
    public ResponseEntity<Country> countryById (@Valid @PathVariable Long id){
        Optional<Country> countryOptional = repository.findById(id);
        if (countryOptional.isPresent()){
            return new ResponseEntity(countryOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("country not found, try again", HttpStatus.BAD_REQUEST);
        }
    }
}

