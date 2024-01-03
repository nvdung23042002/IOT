package org.example.iot_2.services;

import lombok.AllArgsConstructor;
import org.example.iot_2.models.Goods;
import org.example.iot_2.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoodsService {
    @Autowired
    private final GoodsRepository goodsRepository;

    public Goods findById(Integer id) {
        return goodsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Goods insert(Goods goods) {
        return goodsRepository.save(goods);
    }

    public void updateNumberSold(List<Integer> listId) {
        for (int i = 0; i < listId.size(); i++) {
            Integer id = listId.get(i);
            Goods goods = goodsRepository.findById(id).orElseThrow(RuntimeException::new);
            Integer newSoldNum = goods.getSoldNumber() + 1;
            goods.setSoldNumber(newSoldNum);
            goodsRepository.save(goods);
        }
    }

    public List<Goods> findMostSold() {
        return goodsRepository.findMostSold();
    }
}
