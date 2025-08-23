package com.jikkosoft.library.domain.enums;

/**
 * Enum representing the physical status of a book copy.
 * Only AVAILABLE allows new loans or reservations.
 * ON_LOAN, DAMAGED, LOST, and DEACTIVATED make the copy unavailable.
 */
public enum BookStatus {
    AVAILABLE,   // The book copy is available to borrow/reserve
    ON_LOAN,     // Currently borrowed by a member
    DAMAGED,     // The copy is damaged
    LOST,        // The copy is lost
    DEACTIVATED  // The copy has been removed from the active inventory
}
