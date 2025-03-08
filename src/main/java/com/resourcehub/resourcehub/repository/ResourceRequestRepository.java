package com.resourcehub.resourcehub.repository;

import com.resourcehub.resourcehub.entity.Project;
import com.resourcehub.resourcehub.entity.ResourceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {
    List<ResourceRequest> findByStatus(String status);
    List<ResourceRequest> findByProject(Project project);
}