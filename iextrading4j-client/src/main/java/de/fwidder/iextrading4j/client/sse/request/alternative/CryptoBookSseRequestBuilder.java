package de.fwidder.iextrading4j.client.sse.request.alternative;

import de.fwidder.iextrading4j.api.alternative.CryptoBookEvent;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class CryptoBookSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<CryptoBookEvent>,
        CryptoBookSseRequestBuilder> {

    @Override
    public SseRequest<List<CryptoBookEvent>> build() {
        return SseRequestBuilder.<List<CryptoBookEvent>>builder()
                .withPath("/cryptoBook")
                .withResponse(new GenericType<List<CryptoBookEvent>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}