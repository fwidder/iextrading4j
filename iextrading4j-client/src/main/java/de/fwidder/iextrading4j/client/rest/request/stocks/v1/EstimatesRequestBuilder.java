package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.Estimates;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class EstimatesRequestBuilder extends AbstractLastStocksRequestBuilder<Estimates, EstimatesRequestBuilder>
        implements IEXCloudV1RestRequest<Estimates> {

    @Override
    protected RestRequest<Estimates> request() {
        return RestRequestBuilder.<Estimates>builder()
                .withPath("/stock/{symbol}/estimates")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(Estimates.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    protected RestRequest<Estimates> requestWithLast() {
        return RestRequestBuilder.<Estimates>builder()
                .withPath("/stock/{symbol}/estimates/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(Estimates.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
