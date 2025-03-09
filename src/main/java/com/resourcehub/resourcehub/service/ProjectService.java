package com.resourcehub.resourcehub.service;



import com.resourcehub.resourcehub.dto.request.CreateProjectDTO;
import com.resourcehub.resourcehub.dto.response.ProjectDTO;
import java.util.List;

public interface ProjectService {
    ProjectDTO createProject(CreateProjectDTO projectDTO);
    List<ProjectDTO> getAllProjects();
}
