package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.DelayedQuote;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class DelayedQuoteRequestBuilder extends AbstractStocksRequestBuilder<DelayedQuote, DelayedQuoteRequestBuilder>
        implements IEXCloudV1RestRequest<DelayedQuote> {

    @Override
    public RestRequest<DelayedQuote> build() {
        return RestRequestBuilder.<DelayedQuote>builder()
                .withPath("/stock/{symbol}/delayed-quote")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(DelayedQuote.class)
                .build();
    }

}
