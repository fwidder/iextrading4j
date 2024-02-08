package de.fwidder.iextrading4j.api.marketdata;

public enum TradingStatusReasonType {

    HALT_NEWS_PENDING,
    IPO_ISSUE_NOT_YET_TRADING,
    IPO_ISSUE_DEFERRED,
    MARKET_WIDE_CIRCUIT_BREAKER_LEVEL3,
    REASON_NOT_AVAILABLE,

    HALT_NEWS_DISSEMINATION,
    IPO_ISSUE_ORDER_ACCEPTANCE_PERIOD,
    IPO_PRE_LAUNCH_PERIOD,
    MARKET_WIDE_CIRCUIT_BREAKER_LEVEL1,
    MARKET_WIDE_CIRCUIT_BREAKER_LEVEL2,

    UNKNOWN;

}