package com.finalassignment.finalassignment;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseHistory that = (PurchaseHistory) o;
        return Objects.equals(id, that.id) && Objects.equals(purchaseDate, that.purchaseDate) && Objects.equals(purchase, that.purchase) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purchaseDate, purchase, price);
    }
}


