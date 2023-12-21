package com.example.carfactory.message;

import com.example.carfactory.constants.Constants;
import com.example.carfactory.domain.Order;
import com.example.carfactory.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageReceiver {

    private final RabbitTemplate rabbitTemplate;

    private final OrderService orderService;

    private final ModelMapper modelMapper;

    @Scheduled(fixedDelay = 5000)
    public void receiver() {
        while (true) {
            Object message = rabbitTemplate.receiveAndConvert(Constants.CAR_PRODUCED_QUEUE);
            if (Objects.isNull(message)) {
                break;
            }
            log.info("RabbitMQ: Object received from the server. " + message);
            orderService.save(modelMapper.map(message, Order.class));
        }
    }
}
