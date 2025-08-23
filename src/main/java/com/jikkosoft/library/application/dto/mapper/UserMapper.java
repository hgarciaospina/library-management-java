package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.user.*;
import com.jikkosoft.library.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between User domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateUserCommand to User entity.
 * - Convert User entity to UserDto.
 * - Update User entity from UpdateUserCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface UserMapper {

    /**
     * Maps a CreateUserCommand to a User entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create a User.
     * @return New User entity.
     */
    @Mapping(target = "id", ignore = true)
    User toEntity(CreateUserCommand command);

    /**
     * Converts a User entity to its DTO representation.
     *
     * @param user Domain entity.
     * @return DTO with all relevant information.
     */
    UserDto toDto(User user);

    /**
     * Updates an existing User entity with data from UpdateUserCommand.
     *
     * @param command Command containing updated fields.
     * @param user Entity to update.
     */
    void updateEntityFromCommand(UpdateUserCommand command, User user);
}
