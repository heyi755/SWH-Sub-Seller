package com.example.subswh.controller;

import com.example.subswh.config.KafkaConsumerService;
import com.example.subswh.config.KafkaProducer;
import com.example.subswh.util.RedisUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;


/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/20 14:19
 */

//添加跨域请求
@CrossOrigin
@RestController
@RequestMapping
public class TestController {
    @Resource
    private RedisUtil redisUtil;

    @Resource
    private KafkaConsumerService kafkaConsumerService;

    @Resource
    private KafkaProducer kafkaProducer;

    @GetMapping("/api/updates-data")
    public Object getUpdatesData() {
        List<String> messages = kafkaConsumerService.getMessages();
        List<Map<String, Object>> updatesData = new ArrayList<>();
        for (String message : messages) {
            try {
                JSONObject jsonMessage = new JSONObject(message);
                String name = jsonMessage.getString("name");
                String noti = jsonMessage.getString("noti");
                updatesData.add(Map.of("id", System.currentTimeMillis(), "name", name, "noti", noti));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return updatesData;
    }


    @GetMapping("/api/insert-data")
    public String test01(){
        kafkaProducer.sendMessage("test", "hello world");
        System.out.println("send message success");
        return "true";
    }


    @GetMapping("/api/cards-data-values")
    public Object getCardsDataValues() {
        return Map.of(
                "barValue1", 100,
                "value1", "25,000",
                "barValue2", 80,
                "value2", "20,000",
                "barValue3", 20,
                "value3", "5,000"
        );
    }

    @GetMapping("/api/table-data")
    public Object getTableData() {
        return List.of(
                Map.of("name", "Iphone14", "trackingId", 18908424, "num", "999", "status", "已上架"),
                Map.of("name", "MacBook 2021", "trackingId", 18908424, "num", "500", "status", "退回中"),
                Map.of("name", "IPad Air 2023", "trackingId", 18908424, "num", "600", "status", "已送达"),
                Map.of("name", "原神公子手办", "trackingId", 18908421, "num", "10", "status", "未发出")
        );
    }

    @GetMapping("/test")
    public String test() {
        redisUtil.set("user", "heyi");
        return redisUtil.get("user");
    }



}
