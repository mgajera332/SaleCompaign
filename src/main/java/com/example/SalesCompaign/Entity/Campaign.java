package com.example.SalesCompaign.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Entity
@Data
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int campaignID;

    private LocalDate startDate;

    private LocalDate endDate;

    private String title;


    @OneToMany(mappedBy = "campaign",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CampaignDiscount> campaignDiscounts;

    @Override
    public String toString() {
        return "Campaign{" +
                "campaignID=" + campaignID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", campaignDiscounts=" + campaignDiscounts +
                '}';
    }
}
