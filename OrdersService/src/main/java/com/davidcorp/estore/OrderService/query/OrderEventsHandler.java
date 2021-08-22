package com.davidcorp.estore.OrderService.query;

import com.davidcorp.estore.OrderService.core.data.OrderEntity;
import com.davidcorp.estore.OrderService.core.data.OrdersRepository;
import com.davidcorp.estore.OrderService.core.events.OrderApprovedEvent;
import com.davidcorp.estore.OrderService.core.events.OrderCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsHandler {

    private final OrdersRepository ordersRepository;

    public OrderEventsHandler(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event) throws Exception {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(event, orderEntity);

        this.ordersRepository.save(orderEntity);
    }

    @EventHandler
    public void on(OrderApprovedEvent orderApprovedEvent) {
        OrderEntity orderEntity = ordersRepository.findByOrderId(orderApprovedEvent.getOrderId());

        if (orderEntity == null) {
            // TODO: Do something about it
            return;
        }

        orderEntity.setOrderStatus(orderApprovedEvent.getOrderStatus());

        ordersRepository.save(orderEntity);
    }
}
