package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.auditlog.*;
import com.jikkosoft.library.domain.model.AuditLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between AuditLog domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateAuditLogCommand to AuditLog entity.
 * - Convert AuditLog entity to AuditLogDto.
 * - Update AuditLog entity from UpdateAuditLogCommand if needed.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface AuditLogMapper {

    /**
     * Maps a CreateAuditLogCommand to an AuditLog entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create an AuditLog entry.
     * @return New AuditLog entity.
     */
    @Mapping(target = "id", ignore = true)
    AuditLog toEntity(CreateAuditLogCommand command);

    /**
     * Converts an AuditLog entity to its DTO representation.
     *
     * @param auditLog Domain entity.
     * @return DTO with all relevant information.
     */
    AuditLogDto toDto(AuditLog auditLog);

    /**
     * Updates an existing AuditLog entity with data from UpdateAuditLogCommand.
     * Audit logs are usually immutable, but method provided for completeness.
     *
     * @param command Command containing updated fields.
     * @param auditLog Entity to update.
     */
    void updateEntityFromCommand(UpdateAuditLogCommand command, AuditLog auditLog);
}
