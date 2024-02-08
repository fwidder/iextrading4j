package de.fwidder.iextrading4j.client.sse.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.Trade;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class TradesSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<Trade>>,
        TradesSseRequestBuilder> {

    public TradesSseRequestBuilder() {
        this.addChannel(DeepChannel.TRADES);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<Trade>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<Trade>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<Trade>>>() {
                })
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
