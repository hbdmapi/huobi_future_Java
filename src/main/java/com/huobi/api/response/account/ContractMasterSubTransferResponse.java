package com.huobi.api.response.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ContractMasterSubTransferResponse {
    private String status;
    private Long ts;
    private DataBean data;

    @Data
    @AllArgsConstructor
    public static class DataBean{
        @SerializedName("order_id")
        private String orderId;
    }
}
