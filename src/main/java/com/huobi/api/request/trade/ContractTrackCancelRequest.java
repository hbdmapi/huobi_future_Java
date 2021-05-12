package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ContractTrackCancelRequest {
    private String symbol;
    private String orderId;
}
