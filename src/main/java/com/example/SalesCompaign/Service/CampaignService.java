package com.example.SalesCompaign.Service;

import com.example.SalesCompaign.Entity.Campaign;
import com.example.SalesCompaign.Entity.CampaignDiscount;
import com.example.SalesCompaign.Repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {


    @Autowired
    private CampaignRepo campaignRepo;

    public void addCampaign(Campaign campaign) {
        for (CampaignDiscount campaignDiscount:campaign.getCampaignDiscounts()){
            campaignDiscount.setCampaign(campaign);
        }
        campaignRepo.save(campaign);
    }
}
