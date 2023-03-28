package universidades.Nelson.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidades.Nelson.Class.City;
import universidades.Nelson.Services.ServiceCity;

import java.util.List;

@RestController
@RequestMapping(path = "university/city")
public class CityController {
    @Autowired
    private ServiceCity serviceCity;

    @GetMapping(path = "/show/cityes")
    public List<City> cityList(){return serviceCity.showCiti();}

    @PostMapping(path = "/add/city")
    public ResponseEntity<City> addcity (@Valid @RequestBody City city){
        return serviceCity.saveCity(city);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id){return serviceCity.delteCity(id);}

    @PutMapping(path = "/{id}")
    public ResponseEntity<City> updateCity(@Valid @RequestBody City city, @PathVariable Long id){
        return serviceCity.updateCity(city, id);
    }

    @GetMapping(path = "/name/city")
    public ResponseEntity<City> filter (@RequestParam(required = false,name = "name")String name){
        return serviceCity.filter(name);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<City> cityId(@Valid @PathVariable Long id){return serviceCity.cityById(id);}
}
