package de.fwidder.iextrading4j.client.sse.request.alternative;

import de.fwidder.iextrading4j.api.alternative.SentimentEvent;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;
import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SentimentSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<SentimentEvent>, SentimentSseRequestBuilder> {

    @Override
    public SseRequest<List<SentimentEvent>> build() {
        return SseRequestBuilder.<List<SentimentEvent>>builder()
                .withPath("/sentiment")
                .withResponse(new GenericType<List<SentimentEvent>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
