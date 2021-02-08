package com.huobi.api.request.trade;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ContractTpslOpenordersRequest {
    private String symbol;
    private String contractCode;
    private Integer pageIndex;
    private Integer pageSize;
    private Integer trade_type;
}
