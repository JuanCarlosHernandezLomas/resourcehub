package com.resourcehub.resourcehub.repository;

import com.resourcehub.resourcehub.entity.Assignment;
import com.resourcehub.resourcehub.entity.Project;
import com.resourcehub.resourcehub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByUser(User user);
    List<Assignment> findByProject(Project project);
}