package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.model.User;

import java.util.Optional;

/**
 * Port for User persistence.
 */
public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User user);
}
