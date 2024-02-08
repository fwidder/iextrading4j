package de.fwidder.iextrading4j.client.rest.request.refdata.v1;

import de.fwidder.iextrading4j.api.refdata.v1.FxSymbol;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;

public class FxSymbolRequestBuilder extends AbstractRequestFilterBuilder<FxSymbol, FxSymbolRequestBuilder>
        implements IEXCloudV1RestRequest<FxSymbol> {

    @Override
    public RestRequest<FxSymbol> build() {
        return RestRequestBuilder.<FxSymbol>builder()
                .withPath("/ref-data/fx/symbols").get()
                .withResponse(new GenericType<FxSymbol>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
