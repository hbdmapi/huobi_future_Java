package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ContractTriggerHisordersRequest {
    private String symbol;
    private String contractCode;
    private Integer tradeType;
    private String status;
    private Integer createDate;
    private Integer pageIndex;
    private Integer pageSize;
}