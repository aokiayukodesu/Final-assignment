package com.finalassignment.finalassignment;

import com.finalassignment.finalassignment.PurchaseHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Mapper
public interface PurchaseHistoryMapper {

    @SelectProvider(type = SqlPurchaseHistory.class, method = "select")
    List<PurchaseHistory> findDate(@Param("id") Integer id, @Param("purchaseDate") LocalDate purchaseDate, @Param("purchase") String purchase, @Param("price") Integer price);

    public class SqlPurchaseHistory {
        public String selectPurchaseDateSql(final Integer id, final LocalDate purchaseDate, final String purchase, final Integer price) {
            return new SQL() {
                {
                    SELECT("PurchaseHistory.id, PurchaseHistory.purchaseDate, PurchaseHistory.purchase, PurchaseHistory.price");
                    FROM("purchase_histories");
                    WHERE("id = #{id}, purchaseDate = #{purchaseDate},purchase = #{purchase},price= #{price}");
                    if (id == null) {
                    }
                }
            }
        }
    }
}

