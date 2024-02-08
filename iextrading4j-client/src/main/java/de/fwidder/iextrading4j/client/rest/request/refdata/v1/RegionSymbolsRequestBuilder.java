package de.fwidder.iextrading4j.client.rest.request.refdata.v1;

import de.fwidder.iextrading4j.api.refdata.v1.ExchangeSymbol;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class RegionSymbolsRequestBuilder extends AbstractRequestFilterBuilder<List<ExchangeSymbol>, RegionSymbolsRequestBuilder>
        implements IEXCloudV1RestRequest<List<ExchangeSymbol>> {

    private String region;

    public RegionSymbolsRequestBuilder withRegion(final String region) {
        this.region = region;
        return this;
    }

    @Override
    public RestRequest<List<ExchangeSymbol>> build() {
        return RestRequestBuilder.<List<ExchangeSymbol>>builder()
                .withPath("/ref-data/region/{region}/symbols")
                .addPathParam("region", region).get()
                .withResponse(new GenericType<List<ExchangeSymbol>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}