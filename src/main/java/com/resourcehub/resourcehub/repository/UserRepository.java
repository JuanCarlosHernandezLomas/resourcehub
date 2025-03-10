package com.resourcehub.resourcehub.repository;


import com.resourcehub.resourcehub.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles"})
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    List<User> findByAvailabilityStatus(String status);
}
