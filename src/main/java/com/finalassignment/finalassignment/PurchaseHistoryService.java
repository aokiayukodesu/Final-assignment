package com.finalassignment.finalassignment;

import com.finalassignment.finalassignment.PurchaseHistory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PurchaseHistoryService {

    List<PurchaseHistory> findDate(int id, LocalDate purchase_date, String purchase, int price);

}
