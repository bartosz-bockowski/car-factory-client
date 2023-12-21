package com.example.carfactory.controller;

import com.example.carfactory.command.OrderCommand;
import com.example.carfactory.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public HttpStatus order(@Valid @RequestBody OrderCommand orderCommand) {
        orderService.order(orderCommand);
        return HttpStatus.OK;
    }

}
