package thurtimous.user;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<UserJson> findAllWithAssets() {
        List<User> allFromRepo = userRepository.findAll();
        return  allFromRepo.stream().map(this::getUserWithAssets).collect(Collectors.toList());
    }


    public List<UserJson> findAll() {
        Stream<User> userStream = userRepository.findAll().stream();
        return  userStream.map(UserJson::new).collect(Collectors.toList());
    }



    private UserJson getUserWithAssets(User user) {
        return new UserJson(user, List.copyOf(user.getAssets()));
    }


}
