package de.fwidder.iextrading4j.client.sse.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.TradingStatus;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class TradingStatusSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<TradingStatus>>,
        TradingStatusSseRequestBuilder> {

    public TradingStatusSseRequestBuilder() {
        this.addChannel(DeepChannel.TRADING_STATUS);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<TradingStatus>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<TradingStatus>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<TradingStatus>>>() {
                })
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
