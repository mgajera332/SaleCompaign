package com.example.SalesCompaign.Controller;

import com.example.SalesCompaign.Entity.Campaign;
import com.example.SalesCompaign.Repository.CampaignRepo;
import com.example.SalesCompaign.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignRepo campaignRepo;

    @Autowired
    private CampaignService campaignService;

    @PostMapping("/add-campaign")
    public void addCampaign(@RequestBody Campaign campaign){
        campaignService.addCampaign(campaign);
    }


}
