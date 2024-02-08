package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.Earnings;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.AbstractLastStocksRequestBuilder;

public class EarningsRequestBuilder extends AbstractLastStocksRequestBuilder<Earnings, EarningsRequestBuilder>
        implements IEXCloudV1RestRequest<Earnings> {

    protected RestRequest<Earnings> request() {
        return RestRequestBuilder.<Earnings>builder()
                .withPath("/stock/{symbol}/earnings")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Earnings.class)
                .addQueryParam(queryParameters)
                .build();
    }

    protected RestRequest<Earnings> requestWithLast() {
        return RestRequestBuilder.<Earnings>builder()
                .withPath("/stock/{symbol}/earnings/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Earnings.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
