package com.huobi.api.response.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class MarketBatchMergedResponse {
    private String status;
    private Long ts;
    private List<TicksBean> ticks;

    @Builder
    @AllArgsConstructor
    @Data
    public static class TicksBean{
        private String symbol;
        private Long id;
        private String amount;
        private List ask;
        private List bid;
        private String open;
        private String close;
        private BigDecimal count;
        private String high;
        private String low;
        private String vol;
        private Long ts;
    }
}
