package universidades.Nelson.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/universities")
public class University_controller {

    @GetMapping(path = "/ejemplo")
    public String prueba(){
        return "hola";
    }
}
