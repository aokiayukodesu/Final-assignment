package com.finalassignment.finalassignment;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PurchaseHistoryMapperTest {

    @Autowired
    PurchaseHistoryMapper purchaseHistoryMapper;

    @Test
    @DataSet(value = "datasets/initial-data.yml")
    @Transactional
    void idを指定したときに該当するレコードが取得できること() {
        List<PurchaseHistory> actual = purchaseHistoryMapper.findBy(1, null, null, null);
        assertThat(actual).containsExactlyInAnyOrder(
                new PurchaseHistory(1, LocalDate.of(2023, 8, 1), "日用品", 2000)
        );
    }

    @Test
    @DataSet(value = "datasets/initial-data.yml")
    @Transactional
    void purchaseDateを指定したときに該当するレコードが取得できること() {
        List<PurchaseHistory> actual = purchaseHistoryMapper.findBy(null, LocalDate.of(2023, 8, 2), null, null);
        assertThat(actual).containsExactlyInAnyOrder(
                new PurchaseHistory(2, LocalDate.of(2023, 8, 2), "食料品", 3000)
        );
    }

    @Test
    @DataSet(value = "datasets/initial-data.yml")
    @Transactional
    void purchaseを指定したときに該当するレコードが取得できること() {
        List<PurchaseHistory> actual = purchaseHistoryMapper.findBy(null, null, "書籍", null);
        assertThat(actual).containsExactlyInAnyOrder(
                new PurchaseHistory(3, LocalDate.of(2023, 8, 3), "書籍", 1000)
        );
    }

    @Test
    @DataSet(value = "datasets/initial-data.yml")
    @Transactional
    void priceを指定したときに該当するレコードが取得できること() {
        List<PurchaseHistory> actual = purchaseHistoryMapper.findBy(null, null, null, 3000);
        assertThat(actual).containsExactlyInAnyOrder(
                new PurchaseHistory(2, LocalDate.of(2023, 8, 2), "食料品", 3000),
                new PurchaseHistory(4, LocalDate.of(2023, 8, 4), "衣類", 3000)
        );
    }

    @Test
    @DataSet(value = "datasets/initial-data.yml")
    @Transactional
    void 全ての引数がnullの場合に例外をthrowすること() {
        assertThatThrownBy(() -> purchaseHistoryMapper.findBy(null, null, null, null))
                .hasRootCauseInstanceOf(IllegalArgumentException.class)
                .hasRootCauseMessage("最低1つのパラメータが必須です");
    }
}
