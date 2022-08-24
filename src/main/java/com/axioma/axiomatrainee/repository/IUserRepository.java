package com.axioma.axiomatrainee.repository;

import com.axioma.axiomatrainee.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstnameAndLastname(String firstname, String lastname);

    Optional<User> findByUsername(String username);

}
