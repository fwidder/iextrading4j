package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.Financials;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class FinancialsRequestBuilder extends AbstractLastStocksRequestBuilder<Financials, FinancialsRequestBuilder>
        implements IEXCloudV1RestRequest<Financials> {

    @Override
    protected RestRequest<Financials> request() {
        return RestRequestBuilder.<Financials>builder()
                .withPath("/stock/{symbol}/financials")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Financials.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    protected RestRequest<Financials> requestWithLast() {
        return RestRequestBuilder.<Financials>builder()
                .withPath("/stock/{symbol}/financials/{last}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("last", String.valueOf(last)).get()
                .withResponse(Financials.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
