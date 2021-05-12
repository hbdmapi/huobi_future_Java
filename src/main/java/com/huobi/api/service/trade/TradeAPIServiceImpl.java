package com.huobi.api.service.trade;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.trade.*;
import com.huobi.api.response.trade.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeAPIServiceImpl implements TradeAPIService {


    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String url_prex = "https://api.hbdm.com";
    Logger logger = LoggerFactory.getLogger(getClass());

    public TradeAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }


    @Override
    public ContractOrderResponse contractOrderRequest(ContractOrderRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("volume", request.getVolume());
            params.put("direction", request.getDirection().getValue());
            params.put("offset", request.getOffset().getValue());
            params.put("lever_rate", request.getLeverRate());
            params.put("order_price_type", request.getOrderPriceType());

            if (StringUtils.isNotEmpty(request.getSymbol()) && StringUtils.isNotEmpty(request.getContractType())) {
                params.put("symbol", request.getSymbol());
                params.put("contract_type", request.getContractType());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (request.getPrice() != null) {
                params.put("price", request.getPrice());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (request.getTpTriggerPrice()!=null && request.getTpTriggerPrice()!= BigDecimal.valueOf(0)){
                params.put("tp_trigger_price",request.getTpTriggerPrice());
            }
            if (request.getTpOrderPrice()!=null && request.getTpOrderPrice()!= BigDecimal.valueOf(0)){
                params.put("tp_order_price",request.getTpOrderPrice());
            }
            if (request.getTpOrderPriceType()!=null){
                params.put("tp_order_price_type",request.getTpOrderPriceType());
            }
            if (request.getSlTriggerPrice()!=null && request.getSlTriggerPrice()!= BigDecimal.valueOf(0)){
                params.put("sl_trigger_price",request.getSlTriggerPrice());
            }
            if (request.getSlOrderPrice()!=null && request.getSlOrderPrice()!= BigDecimal.valueOf(0)){
                params.put("sl_order_price",request.getSlOrderPrice());
            }
            if (request.getSlOrderPriceType()!=null){
                params.put("sl_order_price_type",request.getSlOrderPriceType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER, params);
            ContractOrderResponse response = JSON.parseObject(body, ContractOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractBatchorderResponse contractBatchorderRequest(ContractBatchorderRequest request) {
        List<Map<String, Object>> listMap = new ArrayList<>();
        String body;
        try {

            request.getList().stream()
                    .forEach(e -> {
                        Map<String, Object> params = new HashMap<>();
                        params.put("volume", e.getVolume());
                        params.put("direction", e.getDirection().getValue());
                        params.put("offset", e.getOffset().getValue());
                        params.put("lever_rate", e.getLeverRate());
                        params.put("order_price_type", e.getOrderPriceType());
                        if (StringUtils.isNotEmpty(e.getSymbol()) && StringUtils.isNotEmpty(e.getContractType())) {
                            params.put("symbol", e.getSymbol());
                            params.put("contract_type", e.getContractType());
                        }
                        if (StringUtils.isNotEmpty(e.getContractCode())) {
                            params.put("contract_code", e.getContractCode());
                        }
                        if (e.getPrice() != null) {
                            params.put("price", e.getPrice());
                        }
                        if (e.getClientOrderId() != null) {
                            params.put("client_order_id", e.getClientOrderId());
                        }
                        if (e.getTpTriggerPrice()!=null && e.getTpTriggerPrice()!= BigDecimal.valueOf(0)){
                            params.put("tp_trigger_price",e.getTpTriggerPrice());
                        }
                        if (e.getTpOrderPrice()!=null && e.getTpOrderPrice()!= BigDecimal.valueOf(0)){
                            params.put("tp_order_price",e.getTpOrderPrice());
                        }
                        if (e.getTpOrderPriceType()!=null){
                            params.put("tp_order_price_type",e.getTpOrderPriceType());
                        }
                        if (e.getSlTriggerPrice()!=null && e.getSlTriggerPrice() != BigDecimal.valueOf(0)){
                            params.put("sl_trigger_price",e.getSlTriggerPrice());
                        }
                        if (e.getSlOrderPrice()!=null && e.getSlOrderPrice()!= BigDecimal.valueOf(0)){
                            params.put("sl_order_price",e.getSlOrderPrice());
                        }
                        if (e.getSlOrderPriceType()!=null){
                            params.put("sl_order_price_type",e.getSlOrderPriceType());
                        }
                        listMap.add(params);
                    });
            Map<String, Object> params = new HashMap<>();

            params.put("orders_data", listMap);

            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_BATCHORDER, params);
            ContractBatchorderResponse response = JSON.parseObject(body, ContractBatchorderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 撤销订单
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractCancelResponse contractCancelRequest(ContractCancelRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            params.put("symbol", request.getSymbol().toUpperCase());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_CANCEL, params);
            ContractCancelResponse response = JSON.parseObject(body, ContractCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            System.out.println("body:" + body);
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 全部撤单
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractCancelallResponse contractCancelallRequest(ContractCancelallRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (StringUtils.isNotEmpty(request.getContractType())) {
                params.put("contract_type", request.getContractType());
            }
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            if (request.getOffset()!=null){
                params.put("offset",request.getOffset());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_CANCELALL, params);
            ContractCancelallResponse response = JSON.parseObject(body, ContractCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractOrderInfoResponse contractOrderInfoRequest(ContractOrderInfoRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER_INFO, params);
            ContractOrderInfoResponse response = JSON.parseObject(body, ContractOrderInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 获取订单明细信息
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractOrderDetailResponse contractOrderDetailRequest(ContractOrderDetailRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id", request.getOrderId());
            if (request.getCreatedAt() != null) {
                params.put("created_at", request.getCreatedAt());
            }
            params.put("order_type", request.getOrderType());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER_DETAIL, params);
            ContractOrderDetailResponse response = JSON.parseObject(body, ContractOrderDetailResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 获取合约当前未成交委托
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractOpenordersResponse contractOpenordersRequest(ContractOpenordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            if (request.getTradeType()!=null){
                params.put("trade_type",request.getTradeType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_OPENORDERS, params);
            ContractOpenordersResponse response = JSON.parseObject(body, ContractOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractHisordersResponse contractHisordersRequest(ContractHisordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (request.getTradeType() != null) {
                params.put("trade_type", request.getTradeType());
            }
            if (request.getType() != null) {
                params.put("type", request.getType());
            }
            if (request.getStatus() != null) {
                params.put("status", request.getStatus());
            }
            if (request.getCreateDate() != null) {
                params.put("create_date", request.getCreateDate());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getOrderType())) {
                params.put("order_type", request.getOrderType());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_HISORDERS, params);
            ContractHisordersResponse response = JSON.parseObject(body, ContractHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractMatchresultsResponse contractMatchresultsRequest(ContractMatchresultsRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("trade_type", request.getTradeType());
            params.put("create_date", request.getCreateDate());

            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_MATCHRESULTS, params);
            ContractMatchresultsResponse response = JSON.parseObject(body, ContractMatchresultsResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LightningClosePositionResponse lightningClosePositionRequest(LightningClosePositionRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (StringUtils.isNotEmpty(request.getContractType())) {
                params.put("contract_type", request.getContractType());
            }
            params.put("direction", request.getDirection());
            params.put("volume", request.getVolume());
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.LIGHTNING_CLOSE_POSITION, params);
            LightningClosePositionResponse response = JSON.parseObject(body, LightningClosePositionResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTriggerOrderResponse contractTriggerOrderRequest(ContractTriggerOrderRequest request){
        String body;
        try {
            Map<String,Object> params=new HashMap<>();
            if(StringUtils.isNotEmpty(request.getSymbol()) && StringUtils.isNotEmpty(request.getContractType())){
                params.put("symbol",request.getSymbol().toUpperCase());
                params.put("contract_type",request.getContractType());
            }
            if(StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            params.put("trigger_type",request.getTriggerType());
            params.put("trigger_price",request.getTriggerPrice());
            params.put("order_price",request.getOrderPrice());
            if (request.getOrderPriceType()!=null){
                params.put("order_price_type",request.getOrderPriceType());
            }
            params.put("volume",request.getVolume());
            params.put("direction",request.getDirection().getValue());
            params.put("offset",request.getOffset().getValue());
            params.put("lever_rate",request.getLeverRate());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_TRIGGER_ORDER,params);
            ContractTriggerOrderResponse response=JSON.parseObject(body,ContractTriggerOrderResponse.class);
            if("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTriggerCancelResponse contractTriggerCancelRequest(ContractTriggerCancelRequest request){
        String body;
        try{
            Map<String,Object> params= new HashMap<>();
            if(StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol",request.getSymbol().toUpperCase());
            }
            params.put("order_id",request.getOrderId());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRIGGER_CANCEL,params);
            logger.debug("body:{}",body);
            ContractTriggerCancelResponse response=JSON.parseObject(body,ContractTriggerCancelResponse.class);
            if("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    public ContractTriggerCancelallResponse contractTriggerCancelallRequest(ContractTriggerCancelallRequest request){
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if(StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol",request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            if (request.getOffset()!=null){
                params.put("offset",request.getOffset());
            }
            if (request.getContractType()!=null) {
                params.put("contract_type", request.getContractType());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex+HuobiFutureAPIConstants.CONTRACT_TRIGGER_CANCELALL,params);
            ContractTriggerCancelallResponse response=JSON.parseObject(body,ContractTriggerCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    public ContractTriggerOpenordersResponse contractTriggerOpenordersRequest(ContractTriggerOpenordersRequest request){
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol",request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            if(request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if(request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getTrade_type()!=null){
                params.put("trade_type",request.getTrade_type());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRIGGER_OPENORDERS,params);
            ContractTriggerOpenordersResponse response=JSON.parseObject(body,ContractTriggerOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSwitchLeverRateResponse contractSwitchLeverRateRequest(String symbol, Integer leverRate) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol",symbol.toUpperCase());
            params.put("lever_rate",leverRate);
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_SWITCH_LEVER_RATE,params);
            logger.debug("body:{}",body);
            ContractSwitchLeverRateResponse response=JSON.parseObject(body,ContractSwitchLeverRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractHisordersExactResponse contractHisordersExactRequest(ContractHisordersExactRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol",request.getSymbol().toUpperCase());
            params.put("trade_type",request.getTradeType());
            params.put("type",request.getType());
            params.put("status",request.getStatus());
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            if (request.getOrderPriceType()!=null){
                params.put("order_price_type",request.getOrderPriceType());
            }
            if (request.getStartTime()!=null){
                params.put("start_time",request.getStartTime());
            }
            if (request.getEndTime()!=null){
                params.put("end_time",request.getEndTime());
            }
            if (request.getFromId()!=null){
                params.put("size",request.getSize());
            }
            if (request.getDirect()!=null){
                params.put("direct",request.getDirect());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_HISORDERS_EXACT,params);
            ContractHisordersExactResponse response=JSON.parseObject(body,ContractHisordersExactResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractMatchresultsExactResponse contractMatchresultsExactRequest(ContractMatchresultsExactRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol",request.getSymbol().toUpperCase());
            params.put("trade_type",request.getTradeType());
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            if (request.getStartTime()!=null){
                params.put("start_time",request.getStartTime());
            }
            if (request.getEndTime()!=null){
                params.put("end_time",request.getEndTime());
            }
            if (request.getFromId()!=null){
                params.put("size",request.getSize());
            }
            if (request.getDirect()!=null){
                params.put("direct",request.getDirect());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_MATCHRESULTS_EXACT,params);
            ContractMatchresultsExactResponse response=JSON.parseObject(body,ContractMatchresultsExactResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTriggerHisordersResponse contractTriggerHisorders(ContractTriggerHisordersRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol",request.getSymbol().toUpperCase());
            params.put("trade_type",request.getTradeType());
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            params.put("status",request.getStatus());
            params.put("create_date",request.getCreateDate());
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRIGGER_HISORDERS,params);
            ContractTriggerHisordersResponse response=JSON.parseObject(body,ContractTriggerHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslOrderResponse contractTpslOrder(ContractTpslOrderRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if(StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractType())) {
                params.put("contract_type", request.getContractType());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            params.put("direction",request.getDirection());
            params.put("volume",request.getVolume());
            if (request.getTpTriggerPrice()!=null && request.getTpTriggerPrice()!=BigDecimal.valueOf(0)){
                params.put("tp_trigger_price",request.getTpTriggerPrice());
            }
            if (request.getTpOrderPrice()!=null && request.getTpOrderPrice()!=BigDecimal.valueOf(0)){
                params.put("tp_order_price",request.getTpOrderPrice());
            }
            if (request.getTpOrderPriceType()!=null){
                params.put("tp_order_price_type",request.getTpOrderPriceType());
            }
            if (request.getSlOrderPrice()!=null && request.getSlOrderPrice()!=BigDecimal.valueOf(0)){
                params.put("sl_order_price",request.getSlOrderPrice());
            }
            if (request.getSlOrderPriceType()!=null){
                params.put("sl_order_price_type",request.getSlOrderPriceType());
            }
            if (request.getSlTriggerPrice()!=null && request.getSlTriggerPrice()!=BigDecimal.valueOf(0)){
                params.put("sl_trigger_price",request.getSlTriggerPrice());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_ORDER,params);
            ContractTpslOrderResponse response=JSON.parseObject(body,ContractTpslOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslCancelResponse contractTpslCancelResponse(ContractTpslCancelRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id", request.getOrderId());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_CANCEL,params);
            logger.debug("body:{}",body);
            ContractTpslCancelResponse response=JSON.parseObject(body,ContractTpslCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslCancelallResponse contractTpslCancelallResponse(ContractTpslCancelallRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_CANCELALL,params);
            logger.debug("body:{}",body);
            ContractTpslCancelallResponse response=JSON.parseObject(body,ContractTpslCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslOpenordersResponse contractTpslOpenordersResponse(ContractTpslOpenordersRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getTrade_type()!=null){
                params.put("trade_type",request.getTrade_type());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_OPENORDERS,params);
            ContractTpslOpenordersResponse response=JSON.parseObject(body,ContractTpslOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslHisordersResponse contractTpslHisordersResponse(ContractTpslHisordersRequset request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("status",request.getStatus());
            params.put("create_date",request.getCreateDate());
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_HISORDERS,params);
            logger.debug("body:{}",body);
            ContractTpslHisordersResponse response=JSON.parseObject(body,ContractTpslHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractRelationTpslOrderResponse contractRelationTpslOrderResponse(ContractRelationTpslOrderRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id",request.getOrderId());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_RELATION_TPSL_ORDER,params);
            logger.debug("body:{}",body);
            ContractRelationTpslOrderResponse response=JSON.parseObject(body,ContractRelationTpslOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackOrderResponse contractTrackOrderResponse(ContractTrackOrderRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getLeverRate()!=null){
                params.put("lever_rate",request.getLeverRate());
            }
            params.put("direction",request.getDirection());
            params.put("offset",request.getOffset());
            params.put("volume",request.getVolume());
            params.put("callback_rate",request.getCallbackRate());
            params.put("active_price",request.getActivePrice());
            params.put("order_price_type", request.getOrderPriceType());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_ORDER,params);
            logger.debug("body:{}",body);
            ContractTrackOrderResponse response=JSON.parseObject(body,ContractTrackOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackCancelResponse contractTrackCancelResponse(ContractTrackCancelRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id",request.getOrderId());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_CANCEL,params);
            logger.debug("body:{}",body);
            ContractTrackCancelResponse response=JSON.parseObject(body,ContractTrackCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackCancelallResponse contractTrackCancelallResponse(ContractTrackCancelallRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getContractCode()!=null){
                params.put("contract_code",request.getContractCode());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            if (request.getOffset()!=null){
                params.put("offset",request.getOffset());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_CANCELALL,params);
            logger.debug("body:{}",body);
            ContractTrackCancelallResponse response=JSON.parseObject(body,ContractTrackCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackOpenordersResponse contractTrackOpenordersResponse(ContractTrackOpenordersRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getContractCode()!=null) {
                params.put("contract_code", request.getContractCode());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getTradeType()!=null){
                params.put("trade_type",request.getTradeType());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_OPENORDERS,params);
            logger.debug("body:{}",body);
            ContractTrackOpenordersResponse response=JSON.parseObject(body,ContractTrackOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackHisordersResponse contractTrackHisordersResponse(ContractTrackHisordersRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getContractCode()!=null) {
                params.put("contract_code", request.getContractCode());
            }
            if (request.getStatus()!=null){
                params.put("status",request.getStatus());
            }
            if (request.getTradeType()!=null){
                params.put("trade_type",request.getTradeType());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getCreateDate()!=null){
                params.put("create_date",request.getCreateDate());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_HISORDERS,params);
            logger.debug("body:{}",body);
            ContractTrackHisordersResponse response=JSON.parseObject(body,ContractTrackHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

}
