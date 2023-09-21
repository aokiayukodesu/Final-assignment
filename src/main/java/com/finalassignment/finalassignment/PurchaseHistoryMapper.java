package com.finalassignment.finalassignment;

import com.finalassignment.finalassignment.PurchaseHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Mapper
public interface PurchaseHistoryMapper {
    @Select("SELECT * FROM  purchase_histories where purchase_date = #{purchaseHistory.id},#{purchaseHistory.purchase_date} ,purchase = #{purchaseHistory.purchase} ,price =#{purchaseHistory.price}")
    List<PurchaseHistory> findDate(@Param("id") int id, @Param("purchase_date") LocalDate purchase_date, @Param("purchase") String purchase, @Param("price") int price);
}

