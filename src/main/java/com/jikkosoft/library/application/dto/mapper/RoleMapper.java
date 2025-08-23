package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.role.*;
import com.jikkosoft.library.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between Role domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateRoleCommand to Role entity.
 * - Convert Role entity to RoleDto.
 * - Update Role entity from UpdateRoleCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface RoleMapper {

    /**
     * Maps a CreateRoleCommand to a Role entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create a Role.
     * @return New Role entity.
     */
    @Mapping(target = "id", ignore = true)
    Role toEntity(CreateRoleCommand command);

    /**
     * Converts a Role entity to its DTO representation.
     *
     * @param role Domain entity.
     * @return DTO with all relevant information.
     */
    RoleDto toDto(Role role);

    /**
     * Updates an existing Role entity with data from UpdateRoleCommand.
     *
     * @param command Command containing updated fields.
     * @param role Entity to update.
     */
    void updateEntityFromCommand(UpdateRoleCommand command, Role role);
}
