package com.resourcehub.resourcehub.repository;


import com.resourcehub.resourcehub.entity.User;
import com.resourcehub.resourcehub.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillMatrixRepository extends JpaRepository<User, Long> {
    List<User> findBySkills_Name(String skillName);
}
