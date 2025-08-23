package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.bookcopy.*;
import com.jikkosoft.library.domain.model.BookCopy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between BookCopy domain entities and DTOs.
 * <p>
 * Responsibilities:
 * - Convert CreateBookCopyCommand to BookCopy entity.
 * - Convert BookCopy entity to BookCopyDto.
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
     * Converts a BookCopy entity to its DTO representation.
     *
     * @param bookCopy Domain entity.
     * @return DTO with all relevant information.
     */
    BookCopyDto toDto(BookCopy bookCopy);

    /**
     * Updates an existing BookCopy entity with data from UpdateBookCopyCommand.
     *
     * @param command Command containing updated fields.
     * @param bookCopy Entity to update.
     */
    void updateEntityFromCommand(UpdateBookCopyCommand command, BookCopy bookCopy);
}
