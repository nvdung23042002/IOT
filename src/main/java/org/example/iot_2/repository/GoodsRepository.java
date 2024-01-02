package org.example.iot_2.repository;

import org.example.iot_2.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer>{
    Optional<Goods> findById(Integer Id);
}
