package com.resourcehub.resourcehub.service;



import com.resourcehub.resourcehub.dto.request.CreateAssignmentDTO;
import com.resourcehub.resourcehub.dto.response.AssignmentDTO;
import com.resourcehub.resourcehub.entity.AssignmentStatus;

import java.util.List;

public interface AssignmentService {
    AssignmentDTO createAssignment(CreateAssignmentDTO assignmentDTO);
    List<AssignmentDTO> getAllAssignments();
    List<AssignmentDTO> getAssignmentsByUser(Long userId);
    List<AssignmentDTO> getAssignmentsByProject(Long projectId);
    AssignmentDTO updateAssignmentStatus(Long assignmentId, AssignmentStatus status);
    void deleteAssignment(Long assignmentId);
}
