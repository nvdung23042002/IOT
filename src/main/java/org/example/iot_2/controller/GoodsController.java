package org.example.iot_2.controller;

import org.example.iot_2.models.Goods;
import org.example.iot_2.models.IdListDto;
import org.example.iot_2.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@CrossOrigin(origins = "*")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/filter")
    public ResponseEntity<?>getGoodsId (@RequestParam(name = "id") Integer id) {
        return new ResponseEntity<>(goodsService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Goods> processNumbers(@RequestBody Goods goods) {
        return new ResponseEntity<>(goodsService.insert(goods), HttpStatus.OK);
    }

    @PostMapping("/sold")
    public ResponseEntity<String> processNumbers(@RequestBody IdListDto idListDto) {
        goodsService.updateNumberSold(idListDto.getIds());
        return new ResponseEntity<>("Update Successful", HttpStatus.OK);
    }

    @GetMapping("/most")
    public List<Goods>getGoodsId () {
        return goodsService.findMostSold();
    }
}
