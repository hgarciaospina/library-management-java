package com.jikkosoft.library.application.port.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Abstraction for time retrieval to ease testing and deterministic use cases.
 */
public interface ClockPort {
    LocalDate today();
    LocalDateTime now();
}
