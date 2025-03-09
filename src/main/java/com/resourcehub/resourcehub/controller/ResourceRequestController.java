package com.resourcehub.resourcehub.controller;


import com.resourcehub.resourcehub.dto.request.CreateResourceRequestDTO;
import com.resourcehub.resourcehub.dto.response.ResourceRequestDTO;
import com.resourcehub.resourcehub.entity.RequestStatus;
import com.resourcehub.resourcehub.service.ResourceRequestService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resource-requests")
public class ResourceRequestController {

    private final ResourceRequestService resourceRequestService;

    public ResourceRequestController(ResourceRequestService resourceRequestService) {
        this.resourceRequestService = resourceRequestService;
    }

    @PostMapping
    public ResponseEntity<ResourceRequestDTO> createResourceRequest(
            @Valid @RequestBody CreateResourceRequestDTO requestDTO) {
        return ResponseEntity.ok(resourceRequestService.createResourceRequest(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResourceRequestDTO>> getAllRequests() {
        return ResponseEntity.ok(resourceRequestService.getAllResourceRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceRequestDTO> getRequestById(@PathVariable Long id) {
        Optional<ResourceRequestDTO> request = resourceRequestService.getResourceRequestById(id);
        return request.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ResourceRequestDTO>> getRequestsByStatus(@PathVariable String status) {
        try {
            RequestStatus requestStatus = RequestStatus.valueOf(status.toUpperCase());
            return ResponseEntity.ok(resourceRequestService.getResourceRequestsByStatus(requestStatus));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<ResourceRequestDTO> approveRequest(@PathVariable Long id) {
        return ResponseEntity.ok(resourceRequestService.approveResourceRequest(id));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<ResourceRequestDTO> rejectRequest(@PathVariable Long id) {
        return ResponseEntity.ok(resourceRequestService.rejectResourceRequest(id));
    }
}
