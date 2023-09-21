package com.finalassignment.finalassignment;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@RestController
public class PurchaseHistoryController {

    private final PurchaseHistoryService purchaseHistoryService;

    public PurchaseHistoryController(PurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }
    
    @GetMapping("/purchaseHistories")
    List<PurchaseHistory> getPurchaseHistories(@RequestParam(name = "id", required = false) int id,
                                               @RequestParam(name = "purchase_date", required = false) LocalDate purchase_date,
                                               @RequestParam(name = "purchase", required = false) String purchase,
                                               @RequestParam(name = "price", required = false) int price) {
        List<PurchaseHistory> purchaseHistories = purchaseHistoryService.findDate(id, purchase_date, purchase, price);
        return purchaseHistories;
    }
}
