package com.resourcehub.resourcehub.repository;


import com.resourcehub.resourcehub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmployeeId(String employeeId);
    List<User> findByAvailabilityStatus(String status);
}
