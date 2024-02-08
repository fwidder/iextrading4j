package de.fwidder.iextrading4j.client.rest.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.LastTrade;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class LastTradeRequestBuilder extends AbstractMarketDataRequestBuilder<List<LastTrade>, LastTradeRequestBuilder>
        implements IEXApiRestRequest<List<LastTrade>>, IEXCloudV1RestRequest<List<LastTrade>> {

    @Override
    public RestRequest<List<LastTrade>> build() {
        return RestRequestBuilder.<List<LastTrade>>builder()
                .withPath("/tops/last").get()
                .withResponse(new GenericType<List<LastTrade>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
