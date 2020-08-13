package thurtimous.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import thurtimous.dto.UserDto;
import thurtimous.entity.User;
import thurtimous.repository.UserRepository;

import java.util.List;

@Controller
@Slf4j
@Transactional
public class UserController extends ThurtimousController<User, UserDto, UserRepository> {

    @Autowired
    UserRepository userRepository;

    @Override
    protected UserRepository getRepo() {
        return userRepository;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Class<UserDto> getDtoClass() {
        return UserDto.class;
    }

}
