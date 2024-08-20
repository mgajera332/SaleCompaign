package com.example.SalesCompaign.Repository;

import com.example.SalesCompaign.Entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign,Integer> {

    @Query(value = "select * from campaign where start_date=current_date()",nativeQuery = true)
    List<Campaign> getStaredCampaigns();

    @Query(value = "select * from campaign where end_date=current_date()",nativeQuery = true)
    List<Campaign> getEndedCampaigns();

}
