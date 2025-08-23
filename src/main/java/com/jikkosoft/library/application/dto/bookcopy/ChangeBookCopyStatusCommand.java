package com.jikkosoft.library.application.dto.bookcopy;

import com.jikkosoft.library.domain.enums.BookStatus;

/**
 * Command to change the status of a book copy (soft state change).
 */
public record ChangeBookCopyStatusCommand(
        Long bookCopyId,
        BookStatus newStatus
) {}
