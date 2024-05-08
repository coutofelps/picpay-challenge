package com.picpaychallenge.repositories;

import com.picpaychallenge.domain.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserId(Long id);

    Optional<User> findUserByDocument(String document);
}
