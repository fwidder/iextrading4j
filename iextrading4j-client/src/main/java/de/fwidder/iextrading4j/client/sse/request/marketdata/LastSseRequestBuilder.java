package de.fwidder.iextrading4j.client.sse.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.LastTrade;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class LastSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<LastTrade>, LastSseRequestBuilder> {

    @Override
    public SseRequest<List<LastTrade>> build() {
        return SseRequestBuilder.<List<LastTrade>>builder()
                .withPath("/last")
                .withResponse(new GenericType<List<LastTrade>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }
}
