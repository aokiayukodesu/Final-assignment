package com.finalassignment.finalassignment;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
public class PurchaseHistoryController {

    private final PurchaseHistoryService purchaseHistoryService;

    public PurchaseHistoryController(PurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @GetMapping("/purchaseHistories")
    List<PurchaseHistory> getPurchaseHistories(@RequestParam(name = "id", required = false) Optional<Integer> id,
                                               @RequestParam(name = "purchaseDate", required = false) Optional<LocalDate> purchaseDate,
                                               @RequestParam(name = "purchase", required = false) Optional<String> purchase,
                                               @RequestParam(name = "price", required = false) Optional<Integer> price) {
        if (id.isPresent() || purchaseDate.isPresent() || purchase.isPresent() || price.isPresent()) {
            List<PurchaseHistory> purchaseHistories = purchaseHistoryService.findDate(id.orElse(null), purchaseDate.orElse(null), purchase.orElse(null), price.orElse(null));
            return purchaseHistories;
        } else {
            List<PurchaseHistory> purchaseHistory = purchaseHistoryService.findAll();
            return purchaseHistory;
        }
    }
}

