package com.example.carfactory.service;

import com.example.carfactory.command.OrderCommand;
import com.example.carfactory.domain.Order;
import com.example.carfactory.message.MessageSender;
import com.example.carfactory.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final MessageSender messageSender;

    private final ModelMapper modelMapper;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void order(OrderCommand orderCommand) {
        messageSender.sendOrderDTO(modelMapper.map(orderCommand, Order.class));
    }

}
