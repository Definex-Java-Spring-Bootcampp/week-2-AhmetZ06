package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaignsSorted() {
        List<Campaign> sortedCampaigns = campaignService.getAllCampaigns().stream()
                .sorted(Comparator.comparing(Campaign::getCreateDate).reversed())
                .collect(Collectors.toList());

        return ResponseEntity.ok(sortedCampaigns);
    }
}
