package com.resourcehub.resourcehub.service;


import com.resourcehub.resourcehub.dto.request.CreateResourceRequestDTO;
import com.resourcehub.resourcehub.dto.response.ResourceRequestDTO;
import com.resourcehub.resourcehub.entity.ResourceRequest;
import com.resourcehub.resourcehub.entity.RequestStatus;
import java.util.List;
import java.util.Optional;

public interface ResourceRequestService {
    ResourceRequestDTO createResourceRequest(CreateResourceRequestDTO requestDTO);
    List<ResourceRequestDTO> getAllResourceRequests();
    Optional<ResourceRequestDTO> getResourceRequestById(Long id);
    List<ResourceRequestDTO> getResourceRequestsByStatus(RequestStatus status);
    ResourceRequestDTO approveResourceRequest(Long id);
    ResourceRequestDTO rejectResourceRequest(Long id);
}
