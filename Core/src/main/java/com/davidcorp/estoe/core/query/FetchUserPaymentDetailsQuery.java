package com.davidcorp.estoe.core.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class FetchUserPaymentDetailsQuery {
    private final String userId;
}
