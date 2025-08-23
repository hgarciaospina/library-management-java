package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.enums.LoanStatus;
import com.jikkosoft.library.domain.model.Loan;

import java.util.List;
import java.util.Optional;

/**
 * Port for Loan persistence and queries.
 */
public interface LoanRepository {
    Optional<Loan> findById(Long id);
    Loan save(Loan loan);
    List<Loan> findByMemberIdAndStatus(Long memberId, LoanStatus status);
}
