package com.jikkosoft.library.application.dto.library.dto;

import com.jikkosoft.library.application.dto.bookcopy.dto.BookCopyDto;
import com.jikkosoft.library.application.dto.member.dto.MemberDto;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Full Data Transfer Object for Library.
 *
 * Responsibilities:
 * - Provides a complete and immutable representation of a Library entity.
 * - Includes members, book copies, and audit fields.
 * - Designed for safe exposure to API clients.
 */
public record LibraryDto(

        /** Unique identifier of the library. */
        Long id,

        /** Name of the library. */
        String name,

        /** Physical address of the library. */
        String address,

        /** Set of members associated with the library. */
        Set<MemberDto> members,

        /** Set of book copies associated with the library. */
        Set<BookCopyDto> bookCopies,

        /** Timestamp when the library was created. */
        LocalDateTime createdAt,

        /** Timestamp when the library was last updated. */
        LocalDateTime updatedAt,

        /** Timestamp when the library was logically deleted (if applicable). */
        LocalDateTime deletedAt
) {}
