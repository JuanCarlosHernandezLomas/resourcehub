package com.resourcehub.resourcehub.service.impl;

import com.resourcehub.resourcehub.dto.request.CreateResourceRequestDTO;
import com.resourcehub.resourcehub.dto.response.ResourceRequestDTO;
import com.resourcehub.resourcehub.entity.*;
import com.resourcehub.resourcehub.mapper.ResourceRequestMapper;
import com.resourcehub.resourcehub.repository.ProjectRepository;
import com.resourcehub.resourcehub.repository.ResourceRequestRepository;
import com.resourcehub.resourcehub.repository.SkillRepository;
import com.resourcehub.resourcehub.repository.UserRepository;
import com.resourcehub.resourcehub.service.ResourceRequestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository resourceRequestRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    private final ResourceRequestMapper resourceRequestMapper;

    public ResourceRequestServiceImpl(ResourceRequestRepository resourceRequestRepository,
                                      ProjectRepository projectRepository,
                                      UserRepository userRepository,
                                      SkillRepository skillRepository,
                                      ResourceRequestMapper resourceRequestMapper) {
        this.resourceRequestRepository = resourceRequestRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
        this.resourceRequestMapper = resourceRequestMapper;
    }

    @Override
    public ResourceRequestDTO createResourceRequest(CreateResourceRequestDTO requestDTO) {
        Project project = projectRepository.findById(requestDTO.getProjectId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        User requestedBy = userRepository.findById(requestDTO.getRequestedById())
                .orElseThrow(() -> new RuntimeException("Usuario solicitante no encontrado"));

        Skill skill = skillRepository.findById(requestDTO.getSkillId())
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada"));

        ResourceRequest request = new ResourceRequest();
        request.setProject(project);
        request.setRequestedBy(requestedBy);
        request.setSkill(skill);
        request.setExperienceLevel(requestDTO.getExperienceLevel());
        request.setStatus(RequestStatus.PENDING);

        ResourceRequest savedRequest = resourceRequestRepository.save(request);
        return resourceRequestMapper.toDTO(savedRequest);
    }

    @Override
    public List<ResourceRequestDTO> getAllResourceRequests() {
        return resourceRequestRepository.findAll().stream()
                .map(resourceRequestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResourceRequestDTO> getResourceRequestById(Long id) {
        return resourceRequestRepository.findById(id).map(resourceRequestMapper::toDTO);
    }

    @Override
    public List<ResourceRequestDTO> getResourceRequestsByStatus(RequestStatus status) {
        return resourceRequestRepository.findByStatus(String.valueOf(status)).stream()
                .map(resourceRequestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ResourceRequestDTO approveResourceRequest(Long id) {
        ResourceRequest request = resourceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud de recurso no encontrada"));
        request.setStatus(RequestStatus.APPROVED);
        return resourceRequestMapper.toDTO(resourceRequestRepository.save(request));
    }

    @Override
    @Transactional
    public ResourceRequestDTO rejectResourceRequest(Long id) {
        ResourceRequest request = resourceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud de recurso no encontrada"));
        request.setStatus(RequestStatus.REJECTED);
        return resourceRequestMapper.toDTO(resourceRequestRepository.save(request));
    }
}
