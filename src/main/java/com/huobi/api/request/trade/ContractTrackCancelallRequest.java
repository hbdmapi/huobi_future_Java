package com.huobi.api.request.trade;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractTrackCancelallRequest {
    private String symbol;
    private String contractType;
    private String contractCode;
    private String direction;
    private String offset;
}
