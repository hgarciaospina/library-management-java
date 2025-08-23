package com.jikkosoft.library.domain.enums;

/**
 * Enum representing the lifecycle of a reservation.
 */
public enum ReservationStatus {
    ACTIVE,     // Active and waiting for pickup or loan conversion
    EXPIRED,    // Expired by time window without pickup
    CANCELLED,  // Manually cancelled by member or staff
    FULFILLED   // Converted into a loan
}
