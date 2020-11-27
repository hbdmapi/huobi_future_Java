package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ContractSettlementRecordsResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @Builder
    @AllArgsConstructor
    @Data
    public static class DataBean{
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("total_size")
        private Integer totalSize;
        @SerializedName("settlement_record")
        private List<SettlementRecordBean> settlementRecord;

        @Builder
        @AllArgsConstructor
        @Data
        public static class SettlementRecordBean{
            private String symbol;
            @SerializedName("settlement_time")
            private Long settlementTime;
            @SerializedName("clawback_ratio")
            private BigDecimal clawbackRatio;
            private List<ListBean> list;

            @Builder
            @AllArgsConstructor
            @Data
            public static class ListBean{
                @SerializedName("contract_code")
                private String contractCode;
                @SerializedName("settlement_price")
                private BigDecimal settlementPrice;
                @SerializedName("settlement_type")
                private String settlementType;
            }
        }
    }
}
