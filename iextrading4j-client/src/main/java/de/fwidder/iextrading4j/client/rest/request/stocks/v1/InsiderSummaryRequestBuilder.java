package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.InsiderSummary;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import de.fwidder.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class InsiderSummaryRequestBuilder extends AbstractStocksRequestBuilder<List<InsiderSummary>,
        InsiderSummaryRequestBuilder> implements IEXCloudV1RestRequest<List<InsiderSummary>> {

    @Override
    public RestRequest<List<InsiderSummary>> build() {
        return RestRequestBuilder.<List<InsiderSummary>>builder()
                .withPath("/stock/{symbol}/insider-summary")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<InsiderSummary>>() {})
                .build();
    }

}
