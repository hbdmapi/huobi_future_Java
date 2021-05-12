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
                .sortBy("update_time")
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
                .sortBy("update_time")
                .build();
        ContractTriggerHisordersResponse response = huobiAPIService.contractTriggerHisorders(request);
        logger.debug("18.获取计划委托历史委托:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTpslOrderRequest(){
        ContractTpslOrderRequest request = ContractTpslOrderRequest.builder()
                .symbol("xrp")
                .contractCode("xrp210326")
                .contractType("quarter")
                .direction("buy")
                .volume("1")
                .tpTriggerPrice(BigDecimal.valueOf(0.2))
                .tpOrderPrice(BigDecimal.valueOf(0.2))
                .tpOrderPriceType("limit")
                .slOrderPrice(BigDecimal.valueOf(0.5))
                .slOrderPriceType("optimal_5")
                .slTriggerPrice(BigDecimal.valueOf(0.5))
                .build();
        ContractTpslOrderResponse response=huobiAPIService.contractTpslOrder(request);
        logger.debug("19.对仓位设置止盈止损订单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTpslCancelRequest(){
        ContractTpslCancelRequest request= ContractTpslCancelRequest.builder()
                .symbol("xrp")
                .orderId("799291000371585024")
                .build();
        ContractTpslCancelResponse response=huobiAPIService.contractTpslCancelResponse(request);
        logger.debug("20.止盈止损撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTpslCancelallRequest(){
        ContractTpslCancelallRequest request= ContractTpslCancelallRequest.builder()
                .symbol("xrp")
                .contractCode("xrp210326")
                .contractType("quarter")
                .build();
        ContractTpslCancelallResponse response=huobiAPIService.contractTpslCancelallResponse(request);
        logger.debug("21.止盈止损全部撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTpslOpenorderRequest(){
        ContractTpslOpenordersRequest request= ContractTpslOpenordersRequest.builder()
                .symbol("xrp")
                .contractCode("")
                .pageIndex(1)
                .pageSize(20)
                .build();
        ContractTpslOpenordersResponse response=huobiAPIService.contractTpslOpenordersResponse(request);
        logger.debug("22.查询止盈止损订单当前委托:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTpslHisorderRequest(){
        ContractTpslHisordersRequset requset= ContractTpslHisordersRequset.builder()
                .symbol("XRP")
                .contractCode("xrp210326")
                .status("0")
                .createDate(30l)
                .pageIndex(1)
                .pageSize(20)
                .sortBy("update_time")
                .build();
        ContractTpslHisordersResponse response=huobiAPIService.contractTpslHisordersResponse(requset);
        logger.debug("23.查询止盈止损订单历史委托:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractRelationTpslOrderRequest(){
        ContractRelationTpslOrderRequest request= ContractRelationTpslOrderRequest.builder()
                .symbol("xrp")
                .orderId(799289975731789824l)
                .build();
        ContractRelationTpslOrderResponse response=huobiAPIService.contractRelationTpslOrderResponse(request);
        logger.debug("24.查询开仓单关联的止盈止损订单详情:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackOrder(){
        ContractTrackOrderRequest request= ContractTrackOrderRequest.builder()
                .symbol("btc")
                .contractType("quarter")
                .contractCode("btc210326")
                .direction("buy")
                .offset("open")
                .leverRate(75)
                .volume(BigDecimal.valueOf(1))
                .activePrice(BigDecimal.valueOf(49111))
                .callbackRate(BigDecimal.valueOf(0.03))
                .orderPriceType("optimal_5")
                .build();
        ContractTrackOrderResponse response=huobiAPIService.contractTrackOrderResponse(request);
        logger.debug("25.跟踪委托订单下单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackCancel(){
        ContractTrackCancelRequest request= ContractTrackCancelRequest.builder()
                .orderId("826490322254073856")
                .symbol("btc")
                .build();
        ContractTrackCancelResponse response=huobiAPIService.contractTrackCancelResponse(request);
        logger.debug("26.跟踪委托订单撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackCancelall(){
        ContractTrackCancelallRequest request= ContractTrackCancelallRequest.builder()
                .symbol("btc")
                .contractCode("")
                .contractType("")
                .direction("")
                .offset("")
                .build();
        ContractTrackCancelallResponse response=huobiAPIService.contractTrackCancelallResponse(request);
        logger.debug("27.跟踪委托订单全部撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackOpenorders(){
        ContractTrackOpenordersRequest request= ContractTrackOpenordersRequest.builder()
                .symbol("btc")
                .contractCode("")
                .tradeType(0)
                .pageIndex(1)
                .pageSize(1)
                .build();
        ContractTrackOpenordersResponse response=huobiAPIService.contractTrackOpenordersResponse(request);
        logger.debug("28.跟踪委托订单当前委托:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackHisorders(){
        ContractTrackHisordersRequest request= ContractTrackHisordersRequest.builder()
                .symbol("btc")
                .contractCode("")
                .createDate(1l)
                .tradeType(1)
                .status("0")
                .pageIndex(1)
                .pageSize(1)
                .sortBy("")
                .build();
        ContractTrackHisordersResponse response=huobiAPIService.contractTrackHisordersResponse(request);
        logger.debug("29.跟踪委托订单历史委托:{}",JSON.toJSONString(response));
    }
}
