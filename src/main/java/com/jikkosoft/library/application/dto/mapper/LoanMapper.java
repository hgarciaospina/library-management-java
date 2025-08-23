package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.loan.*;
import com.jikkosoft.library.domain.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between Loan domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateLoanCommand to Loan entity.
 * - Convert Loan entity to LoanDto.
 * - Update Loan entity from UpdateLoanCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface LoanMapper {

    /**
     * Maps a CreateLoanCommand to a Loan entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create a Loan.
     * @return New Loan entity.
     */
    @Mapping(target = "id", ignore = true)
    Loan toEntity(CreateLoanCommand command);

    /**
     * Converts a Loan entity to its DTO representation.
     *
     * @param loan Domain entity.
     * @return DTO with all relevant information.
     */
    LoanDto toDto(Loan loan);

    /**
     * Updates an existing Loan entity with data from UpdateLoanCommand.
     *
     * @param command Command containing updated fields.
     * @param loan Entity to update.
     */
    void updateEntityFromCommand(UpdateLoanCommand command, Loan loan);
}
