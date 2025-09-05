package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.author.AuthorDto;

import com.jikkosoft.library.application.dto.author.AuthorSummaryDto;
import com.jikkosoft.library.application.dto.author.CreateAuthorCommand;
import com.jikkosoft.library.application.dto.author.UpdateAuthorCommand;
import com.jikkosoft.library.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between Author domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateAuthorCommand to Author entity.
 * - Convert Author entity to AuthorDto or AuthorSummaryDto.
 * - Update Author entity from UpdateAuthorCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface AuthorMapper {

    /**
     * Maps a CreateAuthorCommand to an Author entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create an Author.
     * @return New Author entity.
     */
    @Mapping(target = "id", ignore = true)
    Author toEntity(CreateAuthorCommand command);

    /**
     * Converts an Author entity to AuthorDto (full details).
     *
     * @param author Domain entity.
     * @return DTO with all relevant information.
     */
    AuthorDto toDto(Author author);

    /**
     * Converts an Author entity to AuthorSummaryDto (condensed view).
     *
     * @param author Domain entity.
     * @return Summary DTO.
     */
    AuthorSummaryDto toSummaryDto(Author author);

    /**
     * Updates an existing Author entity with data from UpdateAuthorCommand.
     *
     * @param command Command containing updated fields.
     * @param author Entity to update.
     */
    void updateEntityFromCommand(UpdateAuthorCommand command, Author author);
}
