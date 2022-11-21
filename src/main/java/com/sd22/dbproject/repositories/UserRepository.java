package com.sd22.dbproject.repositories;

import com.sd22.dbproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM users u WHERE u.email = ?1", nativeQuery = true) //TODO: Check if this format is allowed as prepared statement
    User findByUsername(String username);
}
