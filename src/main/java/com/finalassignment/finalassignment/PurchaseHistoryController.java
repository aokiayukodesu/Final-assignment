package com.finalassignment.finalassignment;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@RestController
public class PurchaseHistoryController {

    private final PurchaseHistoryService PurchaseHistoryService;
    private PurchaseHistoryMapper purchaseHistoryService;

    public PurchaseHistoryController(PurchaseHistoryService purchaseHistoryService) {
        PurchaseHistoryService = purchaseHistoryService;
    }

    @GetMapping("/purchaseHistories")
    List<PurchaseHistory> getPurchaseHistories(@RequestParam(name = "purchase_date", value = "purchase_date") LocalDate purchase_date,
                                               @RequestParam(name = "purchase", value = "purchase") String purchase,
                                               @RequestParam(name = "price", value = "price") int price) {
        List<PurchaseHistory> purchaseHistories = purchaseHistoryService.findDate(purchase_date, purchase, price);
        return purchaseHistories;
    }
}
