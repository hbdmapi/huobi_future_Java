package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractTriggerCancelallRequest {
    private String symbol;
    private String contractCode;
    private String contractType;
}
