package de.fwidder.iextrading4j.client.sse.request.alternative;

import de.fwidder.iextrading4j.api.alternative.CryptoEvent;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class CryptoEventSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<CryptoEvent>,
        CryptoEventSseRequestBuilder> {

    @Override
    public SseRequest<List<CryptoEvent>> build() {
        return SseRequestBuilder.<List<CryptoEvent>>builder()
                .withPath("/cryptoEvents")
                .withResponse(new GenericType<List<CryptoEvent>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }
}
