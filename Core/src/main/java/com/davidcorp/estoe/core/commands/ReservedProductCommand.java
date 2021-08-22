package com.davidcorp.estoe.core.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class ReservedProductCommand {

    @TargetAggregateIdentifier
    private final String productId;
    private final String quantity;
    private final String orderId;
    private final String userId;

}
