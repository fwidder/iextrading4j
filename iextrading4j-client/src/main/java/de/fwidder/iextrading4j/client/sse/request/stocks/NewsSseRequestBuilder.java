package de.fwidder.iextrading4j.client.sse.request.stocks;

import de.fwidder.iextrading4j.api.stocks.v1.News;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class NewsSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<News>, NewsSseRequestBuilder> {

    @Override
    public SseRequest<List<News>> build() {
        return SseRequestBuilder.<List<News>>builder()
                .withPath("/news-stream")
                .withResponse(new GenericType<List<News>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
