package thurtimous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thurtimous.controller.UserController;
import thurtimous.dto.UserDto;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.List;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
@Slf4j
@Component
public class UserApi {


    @Autowired
    UserController controller;

    @GetMapping("users/getUsers")
    public List<UserDto> getUsers() {
        Instant before = Instant.now();
        List<UserDto> all = controller.findAll();
        log.info(getLogMessage(before));
        return all;
    }


    @GetMapping("users/getUsers/save")
    public String getUsersSave() {
        Instant before = Instant.now();
        List<UserDto> all = controller.findAll();
        UserDto userDto = all.get(0);
        userDto.setMiddleName("idiot");
        controller.saveDto(userDto);
        log.info(getLogMessage(before));
        return "SAVED";
    }

    /*
    @GetMapping("users/getUsers/assets")
    public List<UserDto> getUsersWithAssets(){
        List<UserDto> allWithAssets = controller.findAllWithAssets();
        return allWithAssets;
    }

    @GetMapping("users/getUsers/receipts")
    public List<UserDto> getUsersWithReceipts(){
        Instant before = Instant.now();
        List<UserDto> allWithReceipts = controller.findAllWithReceipts();
        log.info(getLogMessage(before));
        return allWithReceipts;
    }

    @GetMapping("users/getUsers/all")
    public List<UserDto> getUsersAll(){
        Instant before = Instant.now();
        List<UserDto> allWithAll = controller.findAllWithAll();
        log.info(getLogMessage(before));
        return allWithAll;
    }
*/
    private String getLogMessage(final Temporal before) {
        String seconds = Duration.between(before, Instant.now()).toMillis() + " millis";
        return getClass().getSimpleName() + " took " + seconds + " to complete request";
    }
}
