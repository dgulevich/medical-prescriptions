package com.it.app.repository;

import com.it.app.model.Role;
import com.it.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);
}
