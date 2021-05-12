package com.huobi.api.constants;

public class HuobiFutureAPIConstants {

    //合约市场行情接口
    public static final String CONTRACT_CONTRACT_INFO = "/api/v1/contract_contract_info"; // 1.获取合约信息
    public static final String CONTRACT_INDEX = "/api/v1/contract_index"; // 2.获取合约指数信息
    public static final String CONTRACT_PRICE_LIMIT = "/api/v1/contract_price_limit"; // 3.获取合约最高限价和最低限价
    public static final String CONTRACT_OPEN_INTEREST = "/api/v1/contract_open_interest";// 4.获取当前可用合约总持仓量
    public static final String CONTRACT_DELIVERY_PRICE = "/api/v1/contract_delivery_price"; // 5.获取预估交割价

    public static final String MARKET_DEPTH = "/market/depth";// 6.获取行情深度数据
    public static final String MARKET_HISTORY_KLINE = "/market/history/kline";// 7.获取K线数据
    public static final String MARKET_DETAIL_MERGED = "/market/detail/merged"; // 8.获取聚合行情
    public static final String MARKET_TRADE = "/market/trade";// 9.获取市场最近成交记录
    public static final String MARKET_HISTORY_TRADE = "/market/history/trade";  // 10.批量获取最近的交易记录

    public static final String CONTRACT_RISK_INFO = "/api/v1/contract_risk_info";// 11.查询合约风险准备金余额和预估分摊比例
    public static final String CONTRACT_INSURANCE_FUND = "/api/v1/contract_insurance_fund"; // 12.查询合约风险准备金余额历史数据
    public static final String CONTRACT_ADJUSTFACTOR = "/api/v1/contract_adjustfactor";// 13.查询平台阶梯调整系数
    public static final String CONTRACT_HIS_OPEN_INTEREST = "/api/v1/contract_his_open_interest"; // 14.平台持仓量的查询
    public static final String CONTRACT_ELITE_ACCOUNT_RATIO = "/api/v1/contract_elite_account_ratio"; // 15.精英账户多空持仓对比-账户数

    public static final String CONTRACT_ELITE_POSITION_RATIO = "/api/v1/contract_elite_position_ratio"; // 16.精英账户多空持仓对比-持仓量
    public static final String CONTRACT_LIQUIDATION_ORDERS = "/api/v1/contract_liquidation_orders"; // 17.获取强平订单
    public static final String CONTRACT_API_STATE = "/api/v1/contract_api_state"; // 18.查询系统状态
    public static final String MARKET_HISTORY_INDEX = "/index/market/history/index"; // 19.获取指数K线数据
    public static final String MARKET_HISTORY_BASIS = "/index/market/history/basis"; // 20.获取基差数据

    public static final String CONTRACT_SETTLEMENT_RECORDS = "/api/v1/contract_settlement_records"; // 21.查询平台历史结算记录
    public static final String CONTRACT_ESTIMATED_SETTLEMENT_PRICE = "/api/v1/contract_estimated_settlement_price"; // 22.获取预估结算价
    public static final String BATCH_MERGED = "/market/detail/batch_merged"; // 23.批量获取聚合行情
    public static final String CONTRACT_LADDER_MARGIN = "/api/v1/contract_ladder_margin"; // 24.获取平台阶梯保证金
    public static final String MARK_PRICE_KLINE = "/index/market/history/mark_price_kline"; // 25.获取标记价格的K线数据

    public static final String MARKET_BBO = "/market/bbo"; // 26.获取市场最优挂单

    //合约资产接口
    public static final String CONTRACT_ACCOUNT_INFO = "/api/v1/contract_account_info"; // 1.获取用户账户信息
    public static final String CONTRACT_POSITION_INFO = "/api/v1/contract_position_info"; // 2.获取用户持仓信息
    public static final String CONTRACT_SUB_ACCOUNT_LIST = "/api/v1/contract_sub_account_list"; // 3.查询母账户下所有子账户资产信息
    public static final String CONTRACT_SUB_ACCOUNT_INFO = "/api/v1/contract_sub_account_info"; // 4.查询单个子账户资产信息
    public static final String CONTRACT_SUB_POSITION_INFO = "/api/v1/contract_sub_position_info"; // 5.查询单个子账户持仓信息

    public static final String CONTRACT_FINANCIAL_RECORD = "/api/v1/contract_financial_record"; // 6.查询用户财务记录
    public static final String CONTRACT_ORDER_LIMIT = "/api/v1/contract_order_limit"; // 7.查询用户当前的下单量限制
    public static final String CONTRACT_FEE = "/api/v1/contract_fee"; // 8.查询用户当前的手续费费率
    public static final String CONTRACT_TRANSFER_LIMIT = "/api/v1/contract_transfer_limit"; // 9.查询用户当前的划转限制
    public static final String CONTRACT_POSITION_LIMIT = "/api/v1/contract_position_limit"; // 10.用户持仓量限制的查询

    public static final String CONTRACT_MASTER_SUB_TRANSFER = "/api/v1/contract_master_sub_transfer";//11、母子账户划转
    public static final String CONTRACT_FINANCIAL_RECORD_EXACT = "/api/v1/contract_financial_record_exact";//12、组合查询用户财务记录
    public static final String CONTRACT_USER_SETTLEMENT_RECORDS = "/api/v1/contract_user_settlement_records";//13、查询用户结算记录
    public static final String CONTRACT_ACCOUNT_POSITION_INFO = "/api/v1/contract_account_position_info";//14、查询用户账户和持仓信息
    public static final String CONTRACT_MASTER_SUB_TRANSFER_RECORD = "/api/v1/contract_master_sub_transfer_record";//15、获取母账户下的所有母子账户划转记录

    public static final String CONTRACT_API_TRADING_STATUS="/api/v1/contract_api_trading_status"; //16、获取用户的API指标禁用信息
    public static final String CONTRACT_AVAILABLE_LEVEL_RATE="/api/v1/contract_available_level_rate"; //17、查询用户可用杠杆倍数
    public static final String CONTRACT_SUB_AUTH="/api/v1/contract_sub_auth"; //18、批量设置子账户交易权限
    public static final String CONTRACT_SUB_ACCOUNT_INFO_LIST="/api/v1/contract_sub_account_info_list"; //19、批量获取子账户资产信息
    public static final String CONTRACT_BALANCE_VALUATION = "/api/v1/contract_balance_valuation"; // 20.获取账户总资产估值

    //合约交易接口
    public static final String CONTRACT_ORDER = "/api/v1/contract_order"; // 1.合约下单
    public static final String CONTRACT_BATCHORDER = "/api/v1/contract_batchorder"; // 2.合约批量下单
    public static final String CONTRACT_CANCEL = "/api/v1/contract_cancel"; // 3.撤销订单
    public static final String CONTRACT_CANCELALL = "/api/v1/contract_cancelall"; // 4.全部撤单
    public static final String CONTRACT_ORDER_INFO = "/api/v1/contract_order_info"; // 5.获取合约订单信息

    public static final String CONTRACT_ORDER_DETAIL = "/api/v1/contract_order_detail"; // 6.获取订单明细信息
    public static final String CONTRACT_OPENORDERS = "/api/v1/contract_openorders"; // 7.获取合约当前未成交委托
    public static final String CONTRACT_HISORDERS = "/api/v1/contract_hisorders"; // 8.获取合约历史委托
    public static final String CONTRACT_MATCHRESULTS = "/api/v1/contract_matchresults"; // 9.获取历史成交记录
    public static final String LIGHTNING_CLOSE_POSITION = "/api/v1/lightning_close_position"; // 10.闪电平仓下单

    public static final String CONTRACT_TRIGGER_ORDER = "/api/v1/contract_trigger_order";// 11.合约计划委托下单
    public static final String CONTRACT_TRIGGER_CANCEL="/api/v1/contract_trigger_cancel"; //12.合约计划委托撤单
    public static final String CONTRACT_TRIGGER_CANCELALL="/api/v1/contract_trigger_cancelall";//合约订单委托全部撤单
    public static final String CONTRACT_TRIGGER_OPENORDERS="/api/v1/contract_trigger_openorders"; //14.获取计划委托当前委托
    public static final String CONTRACT_TRIGGER_HISORDERS="/api/v1/contract_trigger_hisorders"; //15.获取计划委托历史委托

    public static final String CONTRACT_SWITCH_LEVER_RATE="/api/v1/contract_switch_lever_rate"; //16.切换杠杆
    public static final String CONTRACT_HISORDERS_EXACT="/api/v1/contract_hisorders_exact"; //17.组合查询合约历史委托
    public static final String CONTRACT_MATCHRESULTS_EXACT="/api/v1/contract_matchresults_exact"; //18.组合查询历史成交记录接口
    public static final String CONTRACT_TPSL_ORDER="/api/v1/contract_tpsl_order"; //19.对仓位设置止盈止损订单
    public static final String CONTRACT_TPSL_CANCEL="/api/v1/contract_tpsl_cancel"; //20.止盈止损订单撤单

    public static final String CONTRACT_TPSL_CANCELALL="/api/v1/contract_tpsl_cancelall"; //21.止盈止损订单全部撤单
    public static final String CONTRACT_TPSL_OPENORDERS="/api/v1/contract_tpsl_openorders"; //22.查询止盈止损订单当前委托
    public static final String CONTRACT_TPSL_HISORDERS="/api/v1/contract_tpsl_hisorders"; //23.查询止盈止损订单历史委托
    public static final String CONTRACT_RELATION_TPSL_ORDER="/api/v1/contract_relation_tpsl_order"; //24.查询开仓单关联的止盈止损订单详情
    public static final String CONTRACT_TRACK_ORDER = "/api/v1/contract_track_order"; // 跟踪委托订单下单

    public static final String CONTRACT_TRACK_CANCEL= "/api/v1/contract_track_cancel"; // 跟踪委托订单撤单
    public static final String CONTRACT_TRACK_CANCELALL = "/api/v1/contract_track_cancelall"; // 跟踪委托订单全部撤单
    public static final String CONTRACT_TRACK_OPENORDERS = "/api/v1/contract_track_openorders"; // 跟踪委托订单当前委托
    public static final String CONTRACT_TRACK_HISORDERS = "/api/v1/contract_track_hisorders"; // 跟踪委托订单历史委托

    //合约划转接口
    public static final String FUTURES_TRANSFER = "/v1/futures/transfer"; // 1.现货-合约账户间进行资金的划转


}
