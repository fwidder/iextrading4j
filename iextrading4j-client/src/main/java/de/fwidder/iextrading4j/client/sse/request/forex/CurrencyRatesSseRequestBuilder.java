package de.fwidder.iextrading4j.client.sse.request.forex;

import de.fwidder.iextrading4j.api.forex.CurrencyRate;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.stocks.QuoteInterval;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class CurrencyRatesSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<CurrencyRate>,
        CurrencyRatesSseRequestBuilder> {

    private QuoteInterval quoteInterval = QuoteInterval.ONE_MINUTE;

    public CurrencyRatesSseRequestBuilder withQuoteInterval(final QuoteInterval quoteInterval) {
        this.quoteInterval = quoteInterval;
        return this;
    }

    @Override
    public SseRequest<List<CurrencyRate>> build() {
        return SseRequestBuilder.<List<CurrencyRate>>builder()
                .withPath("/forex{interval}")
                .addPathParam("interval", quoteInterval.getName())
                .withResponse(new GenericType<List<CurrencyRate>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
