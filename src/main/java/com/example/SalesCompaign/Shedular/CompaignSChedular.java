package com.example.SalesCompaign.Shedular;

import com.example.SalesCompaign.Entity.Campaign;
import com.example.SalesCompaign.Entity.CampaignDiscount;
import com.example.SalesCompaign.Entity.History;
import com.example.SalesCompaign.Entity.Product;
import com.example.SalesCompaign.Repository.CampaignRepo;
import com.example.SalesCompaign.Repository.HistoryRepo;
import com.example.SalesCompaign.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompaignSChedular {


    @Autowired
    private CampaignRepo campaignRepo;

    @Autowired
    private HistoryRepo historyRepo;

    @Autowired
    private ProductRepo productRepo;
    @Scheduled(cron = "0 0 0 * * *")
    public void applyCampaign(){
        List<Campaign> campaignList=campaignRepo.getStaredCampaigns();

        for (Campaign campaign:campaignList){
            List<CampaignDiscount> campaignDiscounts = campaign.getCampaignDiscounts();
            for (CampaignDiscount campaignDiscount:campaignDiscounts){
                Product product = campaignDiscount.getProduct();
                historyRepo.save(makeHistory(product,campaign));

                int discount=(int)((product.getCurrent_price()*campaignDiscount.getDiscount())/100);

                product.setCurrent_price(product.getCurrent_price()-discount);
                product.setDiscount(campaignDiscount.getDiscount()+product.getDiscount());

                productRepo.save(product);
            }
        }
    }


    @Scheduled(cron = "0 59 23 * * *")
    public void endCampaigns(){
        List<Campaign> campaignList=campaignRepo.getEndedCampaigns();

        for(Campaign campaign:campaignList){
            List<CampaignDiscount> campaignDiscounts=campaign.getCampaignDiscounts();

            for (CampaignDiscount campaignDiscount:campaignDiscounts){

                Product product=campaignDiscount.getProduct();
                History history=historyRepo.getHistory(campaign.getStartDate(),product.getProduct_id());
               historyRepo.save( makeHistory(product,campaign));

                product.setDiscount(history.getDiscount());
                product.setCurrent_price(history.getPrice());

                productRepo.save(product);
            }
        }
    }

    private History makeHistory(Product product,Campaign campaign) {
        History history=new History();
        history.setDate(campaign.getStartDate());
        history.setDiscount(product.getDiscount());
        history.setPrice(product.getCurrent_price());
        history.setProduct(product);
        return history;
    }
}
