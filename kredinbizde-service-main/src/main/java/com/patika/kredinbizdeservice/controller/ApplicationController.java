package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.enums.ApplicationType;
import com.patika.kredinbizdeservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/loan_application")
    public ResponseEntity<Application> createLoanApplication(@RequestBody Application applicationDetails) {
        applicationDetails.setApplicationType(ApplicationType.LOAN);
        Application savedApplication = applicationService.saveloanapplication(applicationDetails); // Corrected method name
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplication);
    }

    @GetMapping("/byUserEmail")
    public ResponseEntity<List<Application>> getApplicationsByUserEmail(@RequestParam String email) {
        List<Application> applications = applicationService.findByUserEmail(email);
        if (applications.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(applications);
    }
}
