package com.example.SalesCompaign.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int historyId;

    private LocalDate date;

    private Long price;

    private double discount;

    @ManyToOne(fetch =FetchType.EAGER)
    private Product product;
}
