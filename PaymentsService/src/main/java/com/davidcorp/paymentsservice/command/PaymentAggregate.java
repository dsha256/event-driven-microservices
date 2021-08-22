package com.davidcorp.paymentsservice.command;

import com.davidcorp.estoe.core.commands.ProcessPaymentCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class PaymentAggregate {

    @AggregateIdentifier
    private String paymentId;

    private String orderId;

    public PaymentAggregate () {
    }

    @CommandHandler
    public PaymentAggregate(ProcessPaymentCommand processPaymentCommand) {

        if (processPaymentCommand.getPaymentDetails() == null) {
            throw new IllegalArgumentException("Missing payment details");
        }
        if (processPaymentCommand.getOrderId() == null) {
            throw new IllegalArgumentException("Missing orderId");
        }
        if (processPaymentCommand.getPaymentId() == null) {
            throw new IllegalArgumentException("Missing paymentId");
        }
    }

}
