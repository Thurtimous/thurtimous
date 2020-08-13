package thurtimous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import thurtimous.controller.UserController;
import thurtimous.dto.UserDto;
import thurtimous.entity.User;

import javax.validation.Valid;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.List;


@Slf4j
@RequestMapping("/user")
@RestController
public class UserApi extends ThurtimousApi {


    @Autowired
    UserController controller;

    @GetMapping("/all")
    public List<UserDto> getUsers() {
        Instant before = Instant.now();
        List<UserDto> all = controller.findAll();
        log.info(getLogMessage(before));
        return all;
    }


    @GetMapping("/deleteFirst")
    public List<UserDto> getUsersd() {
        Instant before = Instant.now();
        List<UserDto> all = controller.findAll();
        controller.remove(all.get(0));
        log.info(getLogMessage(before));
        return all;
    }


    @GetMapping("/save")
    public String getUsersSave() {
        Instant before = Instant.now();
        List<UserDto> all = controller.findAll();
        UserDto userDto = all.get(1);
        userDto.setMiddleName("idiot");
        controller.saveDto(userDto);
        log.info(getLogMessage(before));
        return "SAVED";
    }

    @DeleteMapping("/delete/{id}")
    void deleteEmployee(@PathVariable Long id) {
        log.info("bruker med id " + id + " har blitt slettet sier vi");
        controller.deleteById(id);
    }

    @PutMapping("/edit/{id}")
    UserDto editUser(@RequestBody UserDto newUserDto, @PathVariable Long id) {
        log.info(newUserDto.toString());
        return newUserDto;
    }

    private String getLogMessage(final Temporal before) {
        String seconds = Duration.between(before, Instant.now()).toMillis() + " millis";
        return getClass().getSimpleName() + " took " + seconds + " to complete request";
    }
}
