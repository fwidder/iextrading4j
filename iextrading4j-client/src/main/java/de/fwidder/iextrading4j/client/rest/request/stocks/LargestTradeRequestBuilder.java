package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.LargestTrade;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class LargestTradeRequestBuilder extends AbstractStocksRequestBuilder<List<LargestTrade>, LargestTradeRequestBuilder>
        implements IEXCloudV1RestRequest<List<LargestTrade>> {

    @Override
    public RestRequest<List<LargestTrade>> build() {
        return RestRequestBuilder.<List<LargestTrade>>builder()
                .withPath("/stock/{symbol}/largest-trades")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<LargestTrade>>() {})
                .build();
    }

}