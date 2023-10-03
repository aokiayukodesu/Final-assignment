package com.finalassignment.finalassignment;

import com.finalassignment.finalassignment.PurchaseHistory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PurchaseHistoryService {

    List<PurchaseHistory> findDate(Integer id, LocalDate purchaseDate, String purchase, Integer price);

    List<PurchaseHistory> findAll();
}
