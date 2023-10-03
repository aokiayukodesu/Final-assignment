package com.finalassignment.finalassignment;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class PurchaseHistory {

    private Integer id;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate purchaseDate;

    private String purchase;

    private Integer price;

    public PurchaseHistory(Integer id, LocalDate purchaseDate, String purchase, Integer price) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.purchase = purchase;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getPurchase() {
        return purchase;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}


