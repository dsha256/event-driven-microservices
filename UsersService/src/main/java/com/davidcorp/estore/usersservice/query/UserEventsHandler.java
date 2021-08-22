package com.davidcorp.estore.usersservice.query;

import com.davidcorp.estoe.core.model.PaymentDetails;
import com.davidcorp.estoe.core.model.User;
import com.davidcorp.estoe.core.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123card")
                .cvv("123")
                .name("DAVID SHAINIDZE")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        User user = User.builder()
                .firstName("David")
                .lastName("Shainidze")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();

        return user;
    }

}
