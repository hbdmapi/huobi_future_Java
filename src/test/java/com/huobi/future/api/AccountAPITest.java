package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.request.account.*;
import com.huobi.api.response.account.*;
import com.huobi.api.service.account.AccountAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.JVM)
public class AccountAPITest implements BaseTest {


    AccountAPIServiceImpl huobiAPIService = new AccountAPIServiceImpl("", "");


    @Test
    public void getContractAccountInfo() {
        ContractAccountInfoResponse response = huobiAPIService.getContractAccountInfo("btc");
        logger.debug("1.获取用户账户信息：{}", JSON.toJSONString(response));
        response = huobiAPIService.getContractAccountInfo("");
        logger.debug("1.获取用户账户信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractPositionInfo() {
        ContractPositionInfoResponse response = huobiAPIService.getContractPositionInfo("btc");
        logger.debug("2.获取用户持仓信息：{}", JSON.toJSONString(response));

        response = huobiAPIService.getContractPositionInfo("");
        logger.debug("2.获取用户持仓信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractSubAccountList() {
        ContractSubAccountListResponse response = huobiAPIService.getContractSubAccountList("btc");
        logger.debug("3.查询母账户下所有子账户资产信息：{}", JSON.toJSONString(response));

        response = huobiAPIService.getContractSubAccountList("");
        logger.debug("3.查询母账户下所有子账户资产信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractSubAccountInfo() {
        ContractSubAccountInfoResponse response = huobiAPIService.getContractSubAccountInfo("", 1l);
        logger.debug("4.查询单个子账户资产信息：{}", JSON.toJSONString(response));
        logger.debug(response.getStatus());
    }

    @Test
    public void getContractSubPositionInfo() {
        ContractSubPositionInfoResponse response = huobiAPIService.getContractSubPositionInfo("", 1l);
        logger.debug("5.查询单个子账户持仓信息：{}", JSON.toJSONString(response));
        logger.debug(response.getStatus());
    }


    @Test
    public void getContractFinancialRecord() {

        ContractFinancialRecordRequest request = ContractFinancialRecordRequest.builder()
                .symbol("btc")
                .type("8")
                .build();
        ContractFinancialRecordResponse response = huobiAPIService.getContractFinancialRecord(request);
        logger.debug("6.查询用户财务记录：{}", JSON.toJSONString(response));
    }


    @Test
    public void getContractOrderLimitResponse() {
        ContractOrderLimitResponse response = huobiAPIService.getContractOrderLimitResponse("btc", "limit");
        logger.debug("7.查询用户当前的下单量限制：{}", JSON.toJSONString(response));
        response = huobiAPIService.getContractOrderLimitResponse("", "limit");
        logger.debug("7.查询用户当前的下单量限制：{}", JSON.toJSONString(response));
    }


    @Test
    public void getContractFeeResponse() {
        ContractFeeResponse response = huobiAPIService.getContractFeeResponse("btc");
        logger.debug("8.查询用户当前的手续费费率：{}", JSON.toJSONString(response));
        response = huobiAPIService.getContractFeeResponse("");
        logger.debug("8.查询用户当前的手续费费率：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractTransferLimitResponse() {
        ContractTransferLimitResponse response = huobiAPIService.getContractTransferLimitResponse("btc");
        logger.debug("9.查询用户当前的划转限制：{}", JSON.toJSONString(response));
        response = huobiAPIService.getContractTransferLimitResponse("");
        logger.debug("9.查询用户当前的划转限制：{}", JSON.toJSONString(response));
    }


    @Test
    public void getContractPositionLimitResponse() {
        ContractPositionLimitResponse response = huobiAPIService.getContractPositionLimitResponse("btc");
        logger.debug("10.用户持仓量限制的查询：{}", JSON.toJSONString(response));

        response = huobiAPIService.getContractPositionLimitResponse("");
        logger.debug("10.用户持仓量限制的查询：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractMasterSubTransferResponse() {
        ContractMasterSubTransferRequest request = ContractMasterSubTransferRequest.builder()
                .subUid(1l)
                .symbol("ada")
                .amount(BigDecimal.valueOf(35))
                .type("sub_to_master")
                .build();
        ContractMasterSubTransferResponse response = huobiAPIService.getContractMasterSubTransfer(request);
        logger.debug("11.母子帐户划转：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractFinancialRecordExactResponse() {
        ContractFinancialRecordExactRequest request = ContractFinancialRecordExactRequest.builder()
                .symbol("ADA")
                .type("")
                //.startTime()
                //.endTime()
                //.fromId()
                //.size()
                //.direct()
                .build();
        ContractFinancialRecordExactResponse response = huobiAPIService.gatContractFinancialRecordExact(request);
        logger.debug("12.组合查询用户财务记录：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractUserSettlementRecordsResponse() {
        ContractUserSettlementRecordsRequest request = ContractUserSettlementRecordsRequest.builder()
                .symbol("ada")
                //.startTime("")
                //.endTime("")
                //.pageIndex()
                //.pageSize()
                .build();
        ContractUserSettlementRecordsResponse response = huobiAPIService.getContractUserSettlementRecords(request);
        logger.debug("13.查询用户结算记录：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractAccountPositionInfoResponse() {
        ContractAccountPositionInfoResponse response = huobiAPIService.getContractAccountPositionInfo("ada");
        logger.debug("14.用户持仓量限制的查询：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractMasterSubTransferRecord() {
        ContractMasterSubTransferRecordRequest request = ContractMasterSubTransferRecordRequest.builder()
                .symbol("ada")
                .transferType("")
                .createDate(90)
                .pageIndex(1)
                .pageSize(20)
                .build();
        ContractMasterSubTransferRecordResponse response = huobiAPIService.getContractMasterSubTransferRecord(request);
        logger.debug("15.获取母账户下的所有母子账户划转记录：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractApiTradingStatus() {
        ContractApiTradingStatusResponse response = huobiAPIService.getContractApiTradingStatus();
        logger.debug("16.获取母账户下的所有母子账户划转记录：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractAvailableLevelRate() {
        ContractAvailableLevelRateResponse response = huobiAPIService.getContractAvailableLevelRate("btc");
        logger.debug("17.查询用户可用杠杆倍数：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractSubAuth(){
        ContractSubAuthResponse response=huobiAPIService.getContractSubAuth("1234,12344",1);
        logger.debug("18.批量设置子账户交易权限：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractSubAccountInfoLIst(){
        ContractSubAccountInfoListRequest request= ContractSubAccountInfoListRequest.builder()
                .symbol("btc")
                .pageIndex(1)
                .pageSize(20)
                .build();
        ContractSubAccountInfoListResponse response=huobiAPIService.getContractSubAccountInfoList(request);
        logger.debug("19.批量获取子账户资产信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractBalanceValuation(){
        ContractBalanceValuationResponse response=huobiAPIService.getContractBalanceValuation("");
        logger.debug("20.获取账户总资产估值：{}", JSON.toJSONString(response));
    }
}
