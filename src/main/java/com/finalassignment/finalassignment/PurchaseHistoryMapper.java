package com.finalassignment.finalassignment;

import com.finalassignment.finalassignment.PurchaseHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Mapper
public interface PurchaseHistoryMapper {
    @Select("SELECT * FROM  purchase_histories where purchase_date = #{purchase_date} ,purchase = #{purchase} ,price =#{price}")
    List<PurchaseHistory> findDate(LocalDate purchase_date, String purchase, int price);

}

