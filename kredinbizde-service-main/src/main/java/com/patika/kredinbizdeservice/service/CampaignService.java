package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.enums.SectorType;
import com.patika.kredinbizdeservice.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService implements ICampaignService {

    private final CampaignRepository campaignRepository = new CampaignRepository();

    @Override
    public Campaign saveCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
        return campaign;
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.getAll();
    }

    @Override
    public Campaign getCampaignByTitle(String title) {
        Optional<Campaign> campaign = campaignRepository.findByTitle(title);
        return campaign.orElse(null); // Veya isteğe bağlı olarak bir özel durum fırlatabilirsiniz
    }

    @Override
    public List<Campaign> getCampaignsBySector(SectorType sector) {
        return campaignRepository.findBySector(sector);
    }

    @Override
    public void deleteCampaign(Campaign campaign) {
        campaignRepository.delete(campaign);
    }
}
