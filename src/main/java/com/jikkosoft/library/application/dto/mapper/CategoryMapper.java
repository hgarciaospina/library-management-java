package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.category.command.CreateCategoryCommand;
import com.jikkosoft.library.application.dto.category.command.UpdateCategoryCommand;
import com.jikkosoft.library.application.dto.category.dto.CategoryDto;
import com.jikkosoft.library.application.dto.category.dto.CategorySummaryDto;
import com.jikkosoft.library.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between Category domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateCategoryCommand to Category entity.
 * - Convert Category entity to CategoryDto or CategorySummaryDto.
 * - Update Category entity from UpdateCategoryCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface CategoryMapper {

    /**
     * Maps a CreateCategoryCommand to a Category entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create a Category.
     * @return New Category entity.
     */
    @Mapping(target = "id", ignore = true)
    Category toEntity(CreateCategoryCommand command);

    /**
     * Converts a Category entity to CategoryDto (full details).
     *
     * @param category Domain entity.
     * @return DTO with all relevant information, including audit fields if applicable.
     */
    CategoryDto toDto(Category category);

    /**
     * Converts a Category entity to CategorySummaryDto (condensed view).
     *
     * @param category Domain entity.
     * @return Summary DTO with essential information.
     */
    CategorySummaryDto toSummaryDto(Category category);

    /**
     * Updates an existing Category entity with data from UpdateCategoryCommand.
     *
     * @param command Command containing updated fields.
     * @param category Entity to update.
     */
    void updateEntityFromCommand(UpdateCategoryCommand command, Category category);
}
