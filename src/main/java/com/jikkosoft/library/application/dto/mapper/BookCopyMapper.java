package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.bookcopy.*;
import com.jikkosoft.library.domain.model.BookCopy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between BookCopy domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateBookCopyCommand to BookCopy entity.
 * - Convert BookCopy entity to BookCopyDto or BookCopySummaryDto.
 * - Update BookCopy entity from UpdateBookCopyCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface BookCopyMapper {

    /**
     * Maps a CreateBookCopyCommand to a BookCopy entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create a BookCopy.
     * @return New BookCopy entity.
     */
    @Mapping(target = "id", ignore = true)
    BookCopy toEntity(CreateBookCopyCommand command);

    /**
     * Converts a BookCopy entity to BookCopyDto (full details).
     *
     * @param bookCopy Domain entity.
     * @return DTO with all relevant information, including audit fields.
     */
    BookCopyDto toDto(BookCopy bookCopy);

    /**
     * Converts a BookCopy entity to BookCopySummaryDto (condensed view).
     *
     * @param bookCopy Domain entity.
     * @return Summary DTO with essential information.
     */
    BookCopySummaryDto toSummaryDto(BookCopy bookCopy);

    /**
     * Updates an existing BookCopy entity with data from UpdateBookCopyCommand.
     *
     * @param command Command containing updated fields.
     * @param bookCopy Entity to update.
     */
    void updateEntityFromCommand(UpdateBookCopyCommand command, BookCopy bookCopy);
}