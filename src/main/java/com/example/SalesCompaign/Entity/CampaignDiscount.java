package com.example.SalesCompaign.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CampaignDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int campaignDiscountId;

    private double discount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_p_id")
    private  Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_c_id")
    private Campaign campaign;



}
