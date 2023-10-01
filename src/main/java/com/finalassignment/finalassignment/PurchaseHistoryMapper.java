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
    @Select("SELECT * FROM purchase_histories where id = #{id} AND purchaseDate = #{purchaseDate} AND purchase = #{purchase} AND price = #{price}")
    List<PurchaseHistory> findDate(@Param("id") Integer id, @Param("purchaseDate") LocalDate purchaseDate, @Param("purchase") String purchase, @Param("price") Integer price);

    @Select("SELECT * FROM purchase_histories")
    List<PurchaseHistory> findAll();


}

