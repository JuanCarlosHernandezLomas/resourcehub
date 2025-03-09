package com.resourcehub.resourcehub.controller;



import com.resourcehub.resourcehub.dto.request.CreateAssignmentDTO;
import com.resourcehub.resourcehub.dto.response.AssignmentDTO;
import com.resourcehub.resourcehub.entity.AssignmentStatus;
import com.resourcehub.resourcehub.service.AssignmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<AssignmentDTO> createAssignment(@Valid @RequestBody CreateAssignmentDTO assignmentDTO) {
        return ResponseEntity.ok(assignmentService.createAssignment(assignmentDTO));
    }

    @GetMapping
    public ResponseEntity<List<AssignmentDTO>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<AssignmentDTO> updateStatus(@PathVariable Long id, @RequestParam AssignmentStatus status) {
        return ResponseEntity.ok(assignmentService.updateAssignmentStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
