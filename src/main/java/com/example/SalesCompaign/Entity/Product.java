package com.example.SalesCompaign.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;
    private String title;
    private String description;
    private int MRP;
    private Long current_price;
    private double discount;
    private int inventory;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<CampaignDiscount> campaignDiscounts;


    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<History> histories;
}
