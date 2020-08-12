package thurtimous.controller;

import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import thurtimous.dto.ThurtimousDto;
import thurtimous.dto.UserDto;
import thurtimous.entity.ThurtimousEntity;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
public abstract class ThurtimousController<Entity extends ThurtimousEntity, Dto extends ThurtimousDto> {
    @Autowired
    private ModelMapper modelMapper;



    Dto convertToDto(Entity entity) {
        return modelMapper.map(entity, getDtoClass());
    }




    Entity convertToEntity(Dto dto) {
        return modelMapper.map(dto, getEntityClass());
    }


    /**
     * Er ikke sikkert dette er raskeste måten
     */
    List<Entity> convertToEntity(List<Dto> dto) {
        return dto.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
    List<Dto> convertToDto(List<Entity> entity) {
        return entity.stream().map(this::convertToDto).collect(Collectors.toList());
    }





    protected abstract Class<Entity> getEntityClass();

    protected abstract Class<Dto> getDtoClass();

    public abstract void saveDto(Dto dto );
    public abstract void saveDto(List<Dto> dto );

}
