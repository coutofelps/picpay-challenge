package com.picpaychallenge.repositories;

import com.picpaychallenge.domain.user.User;
import com.picpaychallenge.domain.user.UserType;
import com.picpaychallenge.dtos.UserDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Should get user from database")
    void findByDocumentSuccessfully() {
        String document = "valid_document";
        UserDTO data = new UserDTO("Marcos Felipe", "Rodrigues Couto", document, new BigDecimal(10), "0709.marcoscouto@gmail.com", "123456", UserType.COMMON);
        this.createUser(data);

        Optional<User> result = this.userRepository.findByDocument(document);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get user from database")
    void findByDocumentUnsuccessfully() {
        String document = "invalid_document";

        Optional<User> result = this.userRepository.findByDocument(document);

        assertThat(result.isEmpty()).isTrue();
    }

    private User createUser(UserDTO data) {
        User newUser = new User(data);
        this.entityManager.persist(newUser);

        return newUser;
    }
}