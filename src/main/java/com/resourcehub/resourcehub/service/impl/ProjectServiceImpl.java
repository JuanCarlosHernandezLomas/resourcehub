package com.resourcehub.resourcehub.service.impl;



import com.resourcehub.resourcehub.dto.request.CreateProjectDTO;
import com.resourcehub.resourcehub.dto.response.ProjectDTO;
import com.resourcehub.resourcehub.entity.Project;
import com.resourcehub.resourcehub.mapper.ProjectMapper;
import com.resourcehub.resourcehub.repository.ProjectRepository;
import com.resourcehub.resourcehub.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDTO createProject(CreateProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        return projectMapper.toDTO(projectRepository.save(project));
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toDTO)
                .collect(Collectors.toList());
    }
}
