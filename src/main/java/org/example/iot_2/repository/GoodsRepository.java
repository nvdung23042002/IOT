package org.example.iot_2.repository;

import org.example.iot_2.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer>{
    Optional<Goods> findById(Integer Id);

    @Query(
            value = "select * from base_model order by base_model.sold_number desc LIMIT 5;",
            nativeQuery = true)
    List<Goods> findMostSold();
}
