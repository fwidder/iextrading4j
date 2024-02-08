package de.fwidder.iextrading4j.client.rest.request.refdata;

import de.fwidder.iextrading4j.api.refdata.ExchangeSymbol;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class SymbolsRequestBuilder extends AbstractRequestFilterBuilder<List<ExchangeSymbol>, SymbolsRequestBuilder>
        implements IEXApiRestRequest<List<ExchangeSymbol>> {

    @Override
    public RestRequest<List<ExchangeSymbol>> build() {
        return RestRequestBuilder.<List<ExchangeSymbol>>builder()
                .withPath("/ref-data/symbols").get()
                .withResponse(new GenericType<List<ExchangeSymbol>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }
}
