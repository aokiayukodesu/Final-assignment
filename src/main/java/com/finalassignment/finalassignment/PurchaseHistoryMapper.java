package com.finalassignment.finalassignment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.time.LocalDate;
import java.util.List;


@Mapper
public interface PurchaseHistoryMapper {

    @SelectProvider(type = SqlPurchaseHistory.class, method = "selectByIdAndPurchaseDateAndPurchaseAndPrice")
    List<PurchaseHistory> findBy(@Param("id") Integer id, @Param("purchaseDate") LocalDate purchaseDate, @Param("purchase") String purchase, @Param("price") Integer price);

    class SqlPurchaseHistory {
        public String selectByIdAndPurchaseDateAndPurchaseAndPrice(final Integer id, final LocalDate purchaseDate, final String purchase, final Integer price) {
            return new SQL() {
                {
                    if (id == null && purchaseDate == null && purchase == null && price == null) {
                        throw new IllegalArgumentException("最低1つのパラメータが必須です");
                    }
                    SELECT("*");
                    FROM("purchase_histories");
                    if (id != null) {
                        WHERE("id = #{id}");
                    } else {
                        if (purchaseDate != null) {
                            WHERE("purchaseDate = #{purchaseDate}");
                        }
                        if (purchase != null) {
                            WHERE("purchase = #{purchase}");
                        }
                        if (price != null) {
                            WHERE("price = #{price}");
                        }
                    }
                }
            }.toString();
        }
    }
}

