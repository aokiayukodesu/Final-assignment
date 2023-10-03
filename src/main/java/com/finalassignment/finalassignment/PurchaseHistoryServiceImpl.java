package com.finalassignment.finalassignment;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    private final PurchaseHistoryMapper purchaseHistoryMapper;

    public PurchaseHistoryServiceImpl(PurchaseHistoryMapper purchaseHistoryMapper) {
        this.purchaseHistoryMapper = purchaseHistoryMapper;
    }

    @Override
    public List<PurchaseHistory> findDate(Integer id, LocalDate purchaseDate, String purchase, Integer price) {
        return purchaseHistoryMapper.findBy(id, purchaseDate, purchase, price);
    }

    @Override
    public List<PurchaseHistory> findAll() {
        return Collections.emptyList();
    }
}
