package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.marketdata.TradingStatusReasonType;

import static de.fwidder.iextrading4j.client.mapper.TradingStatusReasonTypeDeserializer.TRADING_STATUS_REASON_TYPE_MAPPER;

class TradingStatusReasonTypeSerializer extends AbstractEnumSerializer<TradingStatusReasonType> {

    TradingStatusReasonTypeSerializer() {
        super(TRADING_STATUS_REASON_TYPE_MAPPER.inverse(), TradingStatusReasonType.UNKNOWN);
    }
}
