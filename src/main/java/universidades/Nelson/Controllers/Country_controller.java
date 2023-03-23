package universidades.Nelson.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "university/country")
public class Country_controller {

    @GetMapping(path = "/Show/Countries")
    public String prueba(){
        return "hola";
    }
}
