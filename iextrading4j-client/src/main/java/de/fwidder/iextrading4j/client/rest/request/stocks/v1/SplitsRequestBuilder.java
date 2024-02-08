package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.Split;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.SplitsRange;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SplitsRequestBuilder extends AbstractStocksRequestBuilder<List<Split>, SplitsRequestBuilder> {

    private SplitsRange splitsRange = SplitsRange.ONE_MONTH;

    public SplitsRange getSplitsRange() {
        return splitsRange;
    }

    public SplitsRequestBuilder withSplitsRange(final SplitsRange splitsRange) {
        this.splitsRange = splitsRange;
        return this;
    }

    @Override
    public RestRequest<List<Split>> build() {
        return RestRequestBuilder.<List<Split>>builder()
                .withPath("/stock/{symbol}/splits/{range}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("range", getSplitsRange().getCode()).get()
                .withResponse(new GenericType<List<Split>>() {
                })
                .build();
    }
}