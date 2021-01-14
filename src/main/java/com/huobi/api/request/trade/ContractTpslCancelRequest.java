package com.huobi.api.request.trade;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContractTpslCancelRequest {
    private String symbol;
    private String orderId;
}
