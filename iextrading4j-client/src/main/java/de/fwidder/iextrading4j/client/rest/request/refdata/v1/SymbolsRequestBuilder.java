package de.fwidder.iextrading4j.client.rest.request.refdata.v1;

import de.fwidder.iextrading4j.api.refdata.v1.ExchangeSymbol;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SymbolsRequestBuilder extends AbstractRequestFilterBuilder<List<ExchangeSymbol>, SymbolsRequestBuilder>
        implements IEXCloudV1RestRequest<List<ExchangeSymbol>> {

    @Override
    public RestRequest<List<ExchangeSymbol>> build() {
        return RestRequestBuilder.<List<ExchangeSymbol>>builder()
                .withPath("/ref-data/symbols").get()
                .withResponse(new GenericType<List<ExchangeSymbol>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
