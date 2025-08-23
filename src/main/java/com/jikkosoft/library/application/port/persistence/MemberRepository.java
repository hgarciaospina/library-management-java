package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.model.Member;

import java.util.Optional;

/**
 * Port for Member persistence.
 */
public interface MemberRepository {
    Optional<Member> findById(Long id);
    Optional<Member> findByEmailInLibrary(String email, Long libraryId);
    Member save(Member member);
}
