package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import com.huobi.api.request.trade.*;
import com.huobi.api.response.trade.*;
import com.huobi.api.service.trade.TradeAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.JVM)
public class TradeAPITest implements BaseTest {


    TradeAPIServiceImpl huobiAPIService = new TradeAPIServiceImpl("", "");

    @Test
    public void contractOrderRequest() {

        ContractOrderRequest request = ContractOrderRequest.builder()
                .symbol("btc")
                .contractType("quarter")
                .volume(1l)
                .price(BigDecimal.valueOf(7450.01))
                .direction(DirectionEnum.BUY)
                .offset(OffsetEnum.OPEN)
                .leverRate(10)
                .orderPriceType("limit")
                .build();
        ContractOrderResponse response =
                huobiAPIService.contractOrderRequest(request);
        logger.debug("1合约下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractBatchorderRequest() {
        List<ContractOrderRequest> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ContractOrderRequest request = ContractOrderRequest.builder()
                    .symbol("btc")
                    .contractType("quarter")
                    .volume(1l)
                    .price(BigDecimal.valueOf(7450.01))
                    .direction(DirectionEnum.SELL)
                    .offset(OffsetEnum.OPEN)
                    .leverRate(10)
                    .orderPriceType("limit")
                    .build();
            list.add(request);

        }
        ContractBatchorderRequest request = ContractBatchorderRequest.builder()
                .list(list)
                .build();
        ContractBatchorderResponse response =
                huobiAPIService.contractBatchorderRequest(request);
        logger.debug("2.合约批量下单：{}", JSON.toJSONString(response));
    }


    @Test
    public void contractCancelRequest() {
        ContractCancelRequest request = ContractCancelRequest.builder()
                .symbol("btc")
                .orderId("634696656176029696,634693443368525824")
                .build();
        ContractCancelResponse response =
                huobiAPIService.contractCancelRequest(request);
        logger.debug("3.撤销订单：{}", JSON.toJSONString(response));
    }


    @Test
    public void contractCancelallRequest() {
        ContractCancelallRequest request = ContractCancelallRequest.builder()
                .symbol("btc")
                .build();
        ContractCancelallResponse response =
                huobiAPIService.contractCancelallRequest(request);
        logger.debug("4全部撤单：{}", JSON.toJSONString(response));
    }


    @Test
    public void contractOrderInfoRequest() {
        ContractOrderInfoRequest request = ContractOrderInfoRequest.builder()
                .symbol("btc")
                .orderId("634696656176029696")
                .build();
        ContractOrderInfoResponse response =
                huobiAPIService.contractOrderInfoRequest(request);
        logger.debug("5获取合约订单信息：{}", JSON.toJSONString(response));
    }


    @Test
    public void contractOrderDetailRequest() {
        ContractOrderDetailRequest request = ContractOrderDetailRequest.builder()
                .symbol("BTC")
                .orderId(634693443251085312l)
                .createdAt(System.currentTimeMillis())
                .orderType(1)
                .build();
        ContractOrderDetailResponse response =
                huobiAPIService.contractOrderDetailRequest(request);
        logger.debug("6.获取订单明细信息：{}", JSON.toJSONString(response));
    }


    @Test
    public void contractOpenordersRequest() {
        ContractOpenordersRequest request = ContractOpenordersRequest.builder()
                .symbol("btc")
                .build();
        ContractOpenordersResponse response =
                huobiAPIService.contractOpenordersRequest(request);
        logger.debug("7.获取合约当前未成交委托：{}", JSON.toJSONString(response));
    }


    @Test
    public void ContractHisordersRequest() {
        ContractHisordersRequest request = ContractHisordersRequest.builder()
                .symbol("btc")
                .tradeType(1)
                .type(1)
                .status(0)
                .createDate(90)
                .build();
        ContractHisordersResponse response =
                huobiAPIService.contractHisordersRequest(request);
        logger.debug("8.获取合约历史委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractMatchresultsRequest() {
        ContractMatchresultsRequest request = ContractMatchresultsRequest.builder()
                .symbol("btc")
                .tradeType(0)
                .createDate(90)
                .build();
        ContractMatchresultsResponse response =
                huobiAPIService.contractMatchresultsRequest(request);
        logger.debug("9.获取历史成交记录：{}", JSON.toJSONString(response));
    }

    @Test
    public void lightningClosePositionRequest() {
        LightningClosePositionRequest request = LightningClosePositionRequest.builder()
                .symbol("btc")
                .contractType("quarter")
                .direction("sell")
                .volume(1)
                .build();
        LightningClosePositionResponse response =
                huobiAPIService.lightningClosePositionRequest(request);
        logger.debug("10.闪电平仓下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTriggerOrderRequest() {
        ContractTriggerOrderRequest request = ContractTriggerOrderRequest.builder()
                .symbol("eth")
                .contractType("quarter")
                //.contractCode("btc200925")
                .triggerType("le")
                .triggerPrice(BigDecimal.valueOf(340.442))
                .orderPrice(BigDecimal.valueOf(340.24))
                .orderPriceType("limit")
                .volume(1l)
                .direction(DirectionEnum.valueOf("SELL"))
                .offset(OffsetEnum.valueOf("CLOSE"))
                .leverRate(20)
                .build();
        ContractTriggerOrderResponse response = huobiAPIService.contractTriggerOrderRequest(request);
        logger.debug("11.请求的参数：{}", JSON.toJSONString(request));
        logger.debug("11.合约计划委托下单：{}", JSON.toJSONString(response));

    }

    @Test
    public void contractTriggerCancelRequest() {
        ContractTriggerCancelRequest request = ContractTriggerCancelRequest.builder()
                .symbol("btc")
                .orderId("18139221,18139220")
                .build();
        ContractTriggerCancelResponse response = huobiAPIService.contractTriggerCancelRequest(request);
        logger.debug("12.合约计划委托撤单:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTriggerCancelallRequest() {
        ContractTriggerCancelallRequest request = ContractTriggerCancelallRequest.builder()
                .symbol("btc")
                .contractCode("")
                .contractType("")
                .build();
        ContractTriggerCancelallResponse response = huobiAPIService.contractTriggerCancelallRequest(request);
        logger.debug("13.合约计划委托全部撤单:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTriggerOpenordersRequest() {
        ContractTriggerOpenordersRequest request = ContractTriggerOpenordersRequest.builder()
                .symbol("btc")
                .contractCode("btc200925")
                .pageIndex(1)
                .pageSize(20)
                .build();
        ContractTriggerOpenordersResponse response = huobiAPIService.contractTriggerOpenordersRequest(request);
        logger.debug("14.请求的参数:{}", JSON.toJSONString(request));
        logger.debug("14.获取计划委托当前委托:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractSwitchLeverRateRequest() {
        ContractSwitchLeverRateResponse response = huobiAPIService.contractSwitchLeverRateRequest("ada", 10);
        logger.debug("15.切换杠杆:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractHisordersExactRequest() {
        ContractHisordersExactRequest request = ContractHisordersExactRequest.builder()
                .symbol("ada")
                .tradeType(0)
                .type(1)
                .status("0")
                .contractCode("ada201225")
                .startTime(1605856113000l)
                .endTime(1606288113000l)
                .fromId(1l)
                .size(20)
                .direct("prev")
                .build();
        ContractHisordersExactResponse response = huobiAPIService.contractHisordersExactRequest(request);
        logger.debug("16.组合查询合约历史委托:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractMatchresultsExactRequest() {
        ContractMatchresultsExactRequest request = ContractMatchresultsExactRequest.builder()
                .symbol("ada")
                .tradeType(0)
                .contractCode("ada201225")
                .contractCode("ada201225")
                .startTime(1605856113000l)
                .endTime(1606288113000l)
                .fromId(1l)
                .size(20)
                .direct("prev")
                .build();
        ContractMatchresultsExactResponse response = huobiAPIService.contractMatchresultsExactRequest(request);
        logger.debug("17.组合查询历史成交记录接口:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTriggerHisordersRequest() {
        ContractTriggerHisordersRequest request = ContractTriggerHisordersRequest.builder()
                .symbol("ada")
                .contractCode("ada201225")
                .tradeType(0)
                .status("0")
                .createDate(90)
                .pageIndex(1)
                .pageSize(20)
                .build();
        ContractTriggerHisordersResponse response = huobiAPIService.contractTriggerHisorders(request);
        logger.debug("18.获取计划委托历史委托:{}", JSON.toJSONString(response));
    }

}
