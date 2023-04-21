package com.example.subswh.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/api/updates-data")
    public Object getUpdatesData() {
        return List.of(
                Map.of("id", 1, "name", "仓库管理员", "noti", "您的货物存储时间即将到期，请及时续费"),
                Map.of("id", 2, "name", "仓库系统", "noti", "您的货物已经被分配至相关货架"),
                Map.of("id", 3, "name", "货运负责人", "noti", "司机已经就绪，可以开始装运")
        );
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



}
