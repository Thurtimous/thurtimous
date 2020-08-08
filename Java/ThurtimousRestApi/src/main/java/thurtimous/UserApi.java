package thurtimous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thurtimous.user.UserJson;
import thurtimous.user.UserController;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
@Slf4j
@Component
public class UserApi {

    @Autowired
    UserController userController;

    @GetMapping("users/getUsers")
    public List<UserJson> getUsers() {
        return userController.findAll();
    }

    @GetMapping("users/getUserss")
    public List<UserJson> getUsersWithAssets(){
        return userController.findAllWithAssets();
    }
}
