package de.fwidder.iextrading4j.client.rest.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.TOPS;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class TopsRequestBuilder extends AbstractMarketDataRequestBuilder<List<TOPS>, TopsRequestBuilder>
        implements IEXApiRestRequest<List<TOPS>>, IEXCloudV1RestRequest<List<TOPS>> {

    @Override
    public RestRequest<List<TOPS>> build() {
        return RestRequestBuilder.<List<TOPS>>builder()
                .withPath("/tops").get()
                .withResponse(new GenericType<List<TOPS>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }
}
