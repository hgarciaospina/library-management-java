package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.book.*;
import com.jikkosoft.library.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between Book domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateBookCommand to Book entity.
 * - Convert Book entity to BookDto.
 * - Update Book entity from UpdateBookCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface BookMapper {

    /**
     * Maps a CreateBookCommand to a Book entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create a Book.
     * @return New Book entity.
     */
    @Mapping(target = "id", ignore = true)
    Book toEntity(CreateBookCommand command);

    /**
     * Converts a Book entity to its DTO representation.
     *
     * @param book Domain entity.
     * @return DTO with all relevant information.
     */
    BookDto toDto(Book book);

    /**
     * Updates an existing Book entity with data from UpdateBookCommand.
     *
     * @param command Command containing updated fields.
     * @param book Entity to update.
     */
    void updateEntityFromCommand(UpdateBookCommand command, Book book);
}
