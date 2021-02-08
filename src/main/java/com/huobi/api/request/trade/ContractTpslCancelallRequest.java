package com.huobi.api.request.trade;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContractTpslCancelallRequest {
    private String symbol;
    private String contractCode;
    private String contractType;
    private String direction;
}
