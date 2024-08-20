package com.example.SalesCompaign.Repository;

import com.example.SalesCompaign.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HistoryRepo extends JpaRepository<History,Integer> {

    @Query(value = "select * from history where date=:date and product_product_id=:id",nativeQuery = true)
    History getHistory(@Param("date") LocalDate  startDate,@Param("id") int  id);
}
