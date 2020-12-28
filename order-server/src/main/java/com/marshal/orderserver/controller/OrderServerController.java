package com.marshal.orderserver.controller;

import com.marshal.orderserver.service.OrderServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServerController {

    @Autowired
    OrderServerService orderService;

    @RequestMapping("/order")
    public String addOrder(String name, int id) {
        //调用用户，查询用户信息
        String result = orderService.getUder(id);
        return " 》商品：" + name + " 》生成订单：" + result;
    }

}
