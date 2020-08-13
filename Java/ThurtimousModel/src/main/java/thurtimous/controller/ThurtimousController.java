package thurtimous.controller;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import thurtimous.dto.ThurtimousDto;
import thurtimous.dto.UserDto;
import thurtimous.entity.ThurtimousEntity;
import thurtimous.entity.User;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Slf4j
public abstract class ThurtimousController<Entity extends ThurtimousEntity, Dto extends ThurtimousDto, Repo extends JpaRepository<Entity, Long>> {


    @Autowired
    private ModelMapper modelMapper;


    public Dto convertToDto(Entity entity) {
        return modelMapper.map(entity, getDtoClass());
    }

    public void remove(Dto dto) {
        getRepo().delete(convertToEntity(dto));
    }

    public void saveDto(Dto dto) {
        log.info(dto.toString());
        getRepo().save(convertToEntity(dto));
    }

    public Entity convertToEntity(Dto dto) {
        return modelMapper.map(dto, getEntityClass());
    }

    public List<Dto> findAll() {
        return convertToDto(getRepo().findAll());
    }


    List<Entity> convertToEntity(List<Dto> dto) {
        return dto.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
    List<Dto> convertToDto(List<Entity> entity) {
        return entity.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    protected abstract Repo getRepo();

    protected abstract Class<Entity> getEntityClass();

    protected abstract Class<Dto> getDtoClass();

    public void deleteById(long id) {
        getRepo().deleteById(id);
    }
}
