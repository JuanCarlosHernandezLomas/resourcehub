package com.resourcehub.resourcehub.service.impl;



import com.resourcehub.resourcehub.dto.request.CreateAssignmentDTO;
import com.resourcehub.resourcehub.dto.response.AssignmentDTO;
import com.resourcehub.resourcehub.entity.*;
import com.resourcehub.resourcehub.mapper.AssignmentMapper;
import com.resourcehub.resourcehub.repository.AssignmentRepository;
import com.resourcehub.resourcehub.repository.ProjectRepository;
import com.resourcehub.resourcehub.repository.UserRepository;
import com.resourcehub.resourcehub.service.AssignmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final AssignmentMapper assignmentMapper;

    public AssignmentServiceImpl(AssignmentRepository assignmentRepository,
                                 UserRepository userRepository,
                                 ProjectRepository projectRepository,
                                 AssignmentMapper assignmentMapper) {
        this.assignmentRepository = assignmentRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.assignmentMapper = assignmentMapper;
    }

    @Override
    public AssignmentDTO createAssignment(CreateAssignmentDTO assignmentDTO) {
        User user = userRepository.findById(assignmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Project project = projectRepository.findById(assignmentDTO.getProjectId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        Assignment assignment = new Assignment();
        assignment.setUser(user);
        assignment.setProject(project);
        assignment.setStartDate(assignmentDTO.getStartDate());
        assignment.setEndDate(assignmentDTO.getEndDate());
        assignment.setStatus(assignmentDTO.getStatus());

        return assignmentMapper.toDTO(assignmentRepository.save(assignment));
    }

    @Override
    public List<AssignmentDTO> getAllAssignments() {
        return assignmentRepository.findAll().stream()
                .map(assignmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssignmentDTO> getAssignmentsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return assignmentRepository.findByUser(user).stream()
                .map(assignmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssignmentDTO> getAssignmentsByProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        return assignmentRepository.findByProject(project).stream()
                .map(assignmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AssignmentDTO updateAssignmentStatus(Long assignmentId, AssignmentStatus status) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));

        assignment.setStatus(status);
        return assignmentMapper.toDTO(assignmentRepository.save(assignment));
    }

    @Override
    public void deleteAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }
}
