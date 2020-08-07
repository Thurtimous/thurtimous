package thurtimous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
@Slf4j
public class TestApi {

    @GetMapping("helloWorld")
    public String helloWorld() {
        return "Hei Verden";
    }
}
