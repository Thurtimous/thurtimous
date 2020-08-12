package thurtimous.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import thurtimous.dto.UserDto;
import thurtimous.entity.User;
import thurtimous.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@Transactional
public class UserController extends ThurtimousController<User, UserDto> {

    @Autowired
    UserRepository userRepository;


    private List<User> getAll() {
        return userRepository.findAll();
    }

    public List<UserDto> findAll() {
        return getAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }


    public void saveDto(UserDto dto) {
        User entity = convertToEntity(dto);
        userRepository.save(entity);
    }

    @Override
    public void saveDto(List<UserDto> dto) {

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
