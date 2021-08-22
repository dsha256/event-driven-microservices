package com.davidcorp.paymentsservice.events;

import com.davidcorp.estoe.core.events.PaymentProcessedEvent;
import com.davidcorp.paymentsservice.data.PaymentEntity;
import com.davidcorp.paymentsservice.data.PaymentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventsHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(PaymentEventsHandler.class);
    private final PaymentRepository paymentRepository;


    public PaymentEventsHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent event) {
        LOGGER.info("PaymentProcessedEvent is called for orderId: " + event.getOrderId());

        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(event, paymentEntity);

        paymentRepository.save(paymentEntity);
    }
}
