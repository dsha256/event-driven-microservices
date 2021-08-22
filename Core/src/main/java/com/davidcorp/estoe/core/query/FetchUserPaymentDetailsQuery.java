package com.davidcorp.estoe.core.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FetchUserPaymentDetailsQuery {
    private final String userId;
}
