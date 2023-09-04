package com.finalassignment.finalassignment;

import com.finalassignment.finalassignment.PurchaseHistory;
import com.finalassignment.finalassignment.PurchaseHistoryMapper;
import com.finalassignment.finalassignment.PurchaseHistoryService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    private final PurchaseHistoryMapper purchaseHistoryMapper;

    public PurchaseHistoryServiceImpl(PurchaseHistoryMapper purchaseHistoryMapper) {
        this.purchaseHistoryMapper = purchaseHistoryMapper;
    }

    @Override
    public List<PurchaseHistory> findDate(LocalDate purchase_date, String purchase, int price) {
        return purchaseHistoryMapper.findDate(purchase_date, purchase, price);
    }
}
