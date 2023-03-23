package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.Country;
import universidades.Nelson.Services.ServiceCountry;

import java.util.List;

@RestController
@RequestMapping(path = "university/country")
public class CountryController {
    @Autowired
    private ServiceCountry serviceCountry;

    @GetMapping(path = "/show/countries")
    public List<Country> countryList(){
        return serviceCountry.showCountries();
    }
    @PostMapping(path = "add/countries")
    public ResponseEntity<Country> addCountry (@Valid @RequestBody Country country) {
        return serviceCountry.saveCountry(country);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id){
        return serviceCountry.DeleteCountry(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Country> updateCountry (@Valid @RequestBody Country country, @PathVariable Long id){
        return serviceCountry.updateCountry(country,id);
    }
    @GetMapping(path = "/name/country")
    public ResponseEntity<Country> filter (@RequestParam (required = false,name = "nombre")String nombre){
        return serviceCountry.filter(nombre);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Country> countryId (@Valid @PathVariable Long id){
        return serviceCountry.countryById(id);
    }
}
