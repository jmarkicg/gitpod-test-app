package hr.markic.mapper;

import hr.markic.domain.User;
import hr.markic.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO user);
}
