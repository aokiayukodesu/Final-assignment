package com.finalassignment.finalassignment;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class PurchaseHistory {

    private int id;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate purchaseDate;

    private String purchase;

    private int price;

    public PurchaseHistory(int id, LocalDate purchaseDate, String purchase, int price) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.purchase = purchase;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getPurchase() {
        return purchase;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
