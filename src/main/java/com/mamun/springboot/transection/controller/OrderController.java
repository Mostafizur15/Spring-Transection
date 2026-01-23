package com.mamun.springboot.transection.controller;

import com.mamun.springboot.transection.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/place-order")
    public void placeOrder(@RequestParam("pid") Long pid, @RequestParam int qnt){
        orderService.placeOrder(pid,qnt);
    }
}
