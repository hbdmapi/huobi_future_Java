package com.huobi.api.service.trade;

import com.huobi.api.request.trade.*;
import com.huobi.api.response.trade.*;

public interface TradeAPIService {
    ContractOrderResponse contractOrderRequest(ContractOrderRequest request);//合约下单

    ContractBatchorderResponse contractBatchorderRequest(ContractBatchorderRequest request);//合约批量下单

    ContractCancelResponse contractCancelRequest(ContractCancelRequest request);//撤销订单

    ContractCancelallResponse contractCancelallRequest(ContractCancelallRequest request);//全部撤单

    ContractOrderInfoResponse contractOrderInfoRequest(ContractOrderInfoRequest request);//获取合约订单信息

    ContractOrderDetailResponse contractOrderDetailRequest(ContractOrderDetailRequest request);//获取订单明细信息

    ContractOpenordersResponse contractOpenordersRequest(ContractOpenordersRequest request);//获取合约当前未成交委托

    ContractHisordersResponse contractHisordersRequest(ContractHisordersRequest request);//获取合约历史委托

    ContractMatchresultsResponse contractMatchresultsRequest(ContractMatchresultsRequest request);//获取历史成交记录

    LightningClosePositionResponse lightningClosePositionRequest(LightningClosePositionRequest request);//闪电平仓下单

    ContractTriggerOrderResponse contractTriggerOrderRequest(ContractTriggerOrderRequest request);//合约计划委托下单

    ContractTriggerCancelResponse contractTriggerCancelRequest(ContractTriggerCancelRequest request);//合约计划委托撤单

    ContractTriggerCancelallResponse contractTriggerCancelallRequest(ContractTriggerCancelallRequest request);//合约计划委托全部撤单

    ContractTriggerOpenordersResponse contractTriggerOpenordersRequest(ContractTriggerOpenordersRequest request); //获取计划委托当前委托

    ContractSwitchLeverRateResponse contractSwitchLeverRateRequest(String symbol,Integer leverRate);//切换杠杆

    ContractHisordersExactResponse contractHisordersExactRequest(ContractHisordersExactRequest request);//组合查询合约历史委托

    ContractMatchresultsExactResponse contractMatchresultsExactRequest(ContractMatchresultsExactRequest request);//组合查询历史成交记录接口

    ContractTriggerHisordersResponse contractTriggerHisorders(ContractTriggerHisordersRequest request);//获取计划委托历史委托

    ContractTpslOrderResponse contractTpslOrder(ContractTpslOrderRequest request);

    ContractTpslCancelResponse contractTpslCancelResponse(ContractTpslCancelRequest request);

    ContractTpslCancelallResponse contractTpslCancelallResponse(ContractTpslCancelallRequest request);

    ContractTpslOpenordersResponse contractTpslOpenordersResponse(ContractTpslOpenordersRequest request);

    ContractTpslHisordersResponse contractTpslHisordersResponse(ContractTpslHisordersRequset request);

    ContractRelationTpslOrderResponse contractRelationTpslOrderResponse(ContractRelationTpslOrderRequest request);

    ContractTrackOrderResponse contractTrackOrderResponse(ContractTrackOrderRequest request);

    ContractTrackCancelResponse contractTrackCancelResponse(ContractTrackCancelRequest request);

    ContractTrackCancelallResponse contractTrackCancelallResponse(ContractTrackCancelallRequest request);

    ContractTrackOpenordersResponse contractTrackOpenordersResponse(ContractTrackOpenordersRequest request);

    ContractTrackHisordersResponse contractTrackHisordersResponse(ContractTrackHisordersRequest request);
}
