package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.RecommendationTrends;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import de.fwidder.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class RecommendationTrendsRequestBuilder extends AbstractStocksRequestBuilder<List<RecommendationTrends>,
        RecommendationTrendsRequestBuilder> implements IEXCloudV1RestRequest<List<RecommendationTrends>> {

    @Override
    public RestRequest<List<RecommendationTrends>> build() {
        return RestRequestBuilder.<List<RecommendationTrends>>builder()
                .withPath("/stock/{symbol}/recommendation-trends")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<List<RecommendationTrends>>() {})
                .build();
    }
}
