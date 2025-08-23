package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.reservation.*;
import com.jikkosoft.library.domain.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between Reservation domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateReservationCommand to Reservation entity.
 * - Convert Reservation entity to ReservationDto.
 * - Update Reservation entity from UpdateReservationCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface ReservationMapper {

    /**
     * Maps a CreateReservationCommand to a Reservation entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create a Reservation.
     * @return New Reservation entity.
     */
    @Mapping(target = "id", ignore = true)
    Reservation toEntity(CreateReservationCommand command);

    /**
     * Converts a Reservation entity to its DTO representation.
     *
     * @param reservation Domain entity.
     * @return DTO with all relevant information.
     */
    ReservationDto toDto(Reservation reservation);

    /**
     * Updates an existing Reservation entity with data from UpdateReservationCommand.
     *
     * @param command Command containing updated fields.
     * @param reservation Entity to update.
     */
    void updateEntityFromCommand(UpdateReservationCommand command, Reservation reservation);
}
