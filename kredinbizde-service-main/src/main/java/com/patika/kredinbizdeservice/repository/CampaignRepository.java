package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.enums.SectorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CampaignRepository {

    private final List<Campaign> campaignList = new ArrayList<>();

    public void save(Campaign campaign) {
        campaignList.removeIf(existingCampaign -> existingCampaign.getTitle().equals(campaign.getTitle()));
        campaignList.add(campaign);
    }

    public List<Campaign> getAll() {
        return new ArrayList<>(campaignList);
    }

    public Optional<Campaign> findByTitle(String title) {
        return campaignList.stream()
                .filter(campaign -> campaign.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public List<Campaign> findBySector(SectorType sector) {
        return campaignList.stream()
                .filter(campaign -> campaign.getSector() == sector)
                .collect(Collectors.toList());
    }



    public void delete(Campaign campaign) {
        campaignList.remove(campaign);
    }

}
