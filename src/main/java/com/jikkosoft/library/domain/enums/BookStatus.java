package com.jikkosoft.library.domain.enums;

/**
 * Enum representing the physical status of a book copy.
 * Used to manage availability, damage, loss, and deactivation.
 */
public enum BookStatus {
    AVAILABLE,    // The book copy is available to borrow
    ON_LOAN,      // Currently borrowed by a member
    DAMAGED,      // The copy is damaged
    LOST,         // The copy is lost
    DEACTIVATED   // The copy has been marked as removed from the inventory
}
