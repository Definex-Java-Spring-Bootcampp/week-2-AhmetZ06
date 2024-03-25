package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.enums.SectorType;
import java.util.List;

public interface ICampaignService {
    Campaign saveCampaign(Campaign campaign);
    List<Campaign> getAllCampaigns();
    Campaign getCampaignByTitle(String title);
    List<Campaign> getCampaignsBySector(SectorType sector);
    void deleteCampaign(Campaign campaign);
}
