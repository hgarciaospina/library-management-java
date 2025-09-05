package com.jikkosoft.library.application.dto.mapper;

import com.jikkosoft.library.application.dto.member.*;
import com.jikkosoft.library.domain.model.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between Member domain entities and DTOs.
 *
 * Responsibilities:
 * - Convert CreateMemberCommand to Member entity.
 * - Convert Member entity to MemberDto (full details) or MemberSummaryDto (condensed view).
 * - Update Member entity from UpdateMemberCommand.
 */
@Mapper(config = GlobalMapperConfig.class)
public interface MemberMapper {

    /**
     * Maps a CreateMemberCommand to a Member entity.
     * The ID is ignored because it is generated in the domain.
     *
     * @param command Command containing data to create a Member.
     * @return New Member entity.
     */
    @Mapping(target = "id", ignore = true)
    Member toEntity(CreateMemberCommand command);

    /**
     * Converts a Member entity to MemberDto (full details).
     *
     * @param member Domain entity.
     * @return DTO with all relevant information, including audit or relational fields.
     */
    MemberDto toDto(Member member);

    /**
     * Converts a Member entity to MemberSummaryDto (condensed view for listings).
     *
     * @param member Domain entity.
     * @return Summary DTO with essential information.
     */
    MemberSummaryDto toSummaryDto(Member member);

    /**
     * Updates an existing Member entity with data from UpdateMemberCommand.
     *
     * @param command Command containing updated fields.
     * @param member Entity to update.
     */
    void updateEntityFromCommand(UpdateMemberCommand command, Member member);
}
