package de.fwidder.iextrading4j.client.sse.request.alternative;

import de.fwidder.iextrading4j.api.stocks.Quote;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class CryptoQuoteSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<Quote>,
        CryptoQuoteSseRequestBuilder> {

    @Override
    public SseRequest<List<Quote>> build() {
        return SseRequestBuilder.<List<Quote>>builder()
                .withPath("/cryptoQuotes")
                .withResponse(new GenericType<List<Quote>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }
}
