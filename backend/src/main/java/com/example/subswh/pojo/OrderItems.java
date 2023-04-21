package com.example.subswh.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/20 13:49
 */
@TableName("order_items")
@Data
public class OrderItems {

    private String order_id;
    private String product_id;
    private String name;
    private String uni_price;
    private int quantity;

    public OrderItems(String order_id, String product_id, String name, String uni_price, int quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.name = name;
        this.uni_price = uni_price;
        this.quantity = quantity;
    }

    public String toString() {
        return "order_id: " + order_id + ", product_id: " + product_id + ", name: " + name + ", uni_price: " + uni_price + ", quantity: " + quantity;
    }
}
